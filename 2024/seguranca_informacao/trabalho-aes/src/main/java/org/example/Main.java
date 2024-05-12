package org.example;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final int TAMANHO_COLUNAS_LINHAS = 4;

    public static void main(String[] args) {

        try {
            final String conteudo = getArquivo();
            // exemplo chave slide -> 65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80
            final String chave = getChaveCriptografia();

            int[][] matrizEstado = getMatrizEstado(chave);

            List<int[][]> roundKeys = gerarChaves(matrizEstado);
            List<int[][]> listaBlocos = preencherPKCS7(conteudo.getBytes());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<int[][]> gerarChaves(int[][] matrizEstado) {
        ExpansaoChave expansaoChave = new ExpansaoChave();
        List<int[][]> roundKeys = new ArrayList<>();
        // a primeira roundKey é a própria chave fornecida
        roundKeys.add(matrizEstado);

        // gerar as outras 10 chaves
        for (int i = 1; i < 11; i++) {
            int[][] roundKeyAnterior = roundKeys.get(i - 1);
            // copia a última palavra da round key anterior e gera a primeira palavra para esta round key
            int[] primeiraSubChave = gerarPrimeiraPalavraRoundKey(roundKeyAnterior, expansaoChave, i - 1);
            // coloca a primeira palavra para a primeira coluna
            int[][] subkey = armazenaColuna(new int[4][4], primeiraSubChave, 0);

            // completa as colunas restantes
            for (int j = 1; j < TAMANHO_COLUNAS_LINHAS; j++) {
                // pega a palavra anterior
                int[] palavraAnterior = getColuna(subkey, j - 1);
                // pega a palavra da posição correspondente a atual, na roundkey anterior
                int[] palavraRoundKeyAnterior = getColuna(roundKeyAnterior, j);
                // XOR
                int[] xor = expansaoChave.xor(palavraAnterior, palavraRoundKeyAnterior);
                // preenche a coluna da subkey
                subkey = armazenaColuna(subkey, xor, j);
            }

            roundKeys.add(subkey);
        }
        return roundKeys;
    }

    private static int[] gerarPrimeiraPalavraRoundKey(int[][] matrizEstado, ExpansaoChave expansaoChave, int roundKeyNumero) {
    // precisa gerar a primeira palavra por esse processo. o resto teoricamente é só fazer XOR, ver slide 18 do conteúdo
        int[] primeiraPalavraRoundKey;
        int ultimaColuna = matrizEstado.length - 1;

        primeiraPalavraRoundKey = expansaoChave.rotWord(getColuna(matrizEstado, ultimaColuna));
        primeiraPalavraRoundKey = expansaoChave.subWord(primeiraPalavraRoundKey);
        int[] roundConstant = expansaoChave.roundConstant(roundKeyNumero);
        primeiraPalavraRoundKey = expansaoChave.xor(primeiraPalavraRoundKey, roundConstant);
        primeiraPalavraRoundKey = expansaoChave.xor(primeiraPalavraRoundKey, getColuna(matrizEstado, 0));
        return primeiraPalavraRoundKey;
    }

    private static int[] getColuna(int[][] matrizEstado, int indexColuna) {
        int comprimento = matrizEstado.length;
        int[] coluna = new int[comprimento];
        for (int i = 0; i < comprimento; i++) {
            coluna[i] = matrizEstado[i][indexColuna];
        }
        return coluna;
    }

    private static int[][] armazenaColuna(int[][] matriz, int[] coluna, int indexColuna) {
        for (int i = 0; i < TAMANHO_COLUNAS_LINHAS; i++) {
            matriz[i][indexColuna] = coluna[i];
        }
        return matriz;
    }

    private static List<int[][]> preencherPKCS7(byte[] bytesArquivo) {
        int tamanhoBloco = 16;
        //para o PKCS7
        int tamanhoPreencher = tamanhoBloco - (bytesArquivo.length % tamanhoBloco);
        byte[] arquivoPreenchido = Arrays.copyOf(bytesArquivo, bytesArquivo.length + tamanhoPreencher);
        //para o bloco
        List<int[][]> blocosHexDecimal = new ArrayList<>();

        //preecher para ficar multiplo de 16 caso necessite
        for (int i = bytesArquivo.length; i < arquivoPreenchido.length; i++) {
            arquivoPreenchido[i] = (byte) tamanhoPreencher;
        }

        for (int i = 0; i < arquivoPreenchido.length; i += tamanhoBloco) {
            //16 em 16 bytes
            byte[] bytesBloco = Arrays.copyOfRange(arquivoPreenchido, i, i + tamanhoBloco);
            //cria o bloco em hexadecimal e adiciona na lista de blocos
            blocosHexDecimal.add(getBlocoArquivo(bytesBloco));
        }

        return blocosHexDecimal;
    }

    private static int[][] getMatrizEstado(String chave) {
        String[] bytes = chave.split(",");
        int[][] matrizEstadoChave = new int[TAMANHO_COLUNAS_LINHAS][TAMANHO_COLUNAS_LINHAS];
        int contador = 0;
        for (int i = 0; i < TAMANHO_COLUNAS_LINHAS; i++) {
            for (int j = 0; j < TAMANHO_COLUNAS_LINHAS; j++) {
                matrizEstadoChave[j][i] = Integer.parseInt(bytes[contador].trim());
                contador++;
            }
        }
        return matrizEstadoChave;
    }

    private static int[][] getBlocoArquivo(byte[] bytesBloco) {
        int[][] hexaBloco = new int[4][4];

        if (bytesBloco == null || bytesBloco.length != 16) {
            throw new IllegalArgumentException("tamanho de bytes inválidos - esperado 16 bytes");
        }

        //adiciona cs bytes e tranforma para hexadecimal
        for (int coluna = 0; coluna < 4; coluna++) {
            for (int linha = 0; linha < 4; linha++) {
                hexaBloco[linha][coluna] = bytesBloco[coluna * 4 + linha] & 0xFF;
            }
        }

        return hexaBloco;
    }

    private static String getArquivo() throws IllegalArgumentException, IOException {
        //caminho para arquivo teste - C:/Users/maria/OneDrive/Documentos/TESTE.txt
        StringBuilder conteudo = new StringBuilder();
        JFileChooser jfc = new JFileChooser();
        File arq = null;

        //filtro para somente arquivos .txt e .bin
        jfc.setFileFilter(new FileNameExtensionFilter("Arquivo para criptografar", "txt", "bin"));

        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            arq = jfc.getSelectedFile();
        }

        // Verifica se o arquivo existe
        if (arq == null || !arq.exists()) {
            throw new IllegalArgumentException("Falha ao ler arquivo selecionado");
        }

        //le o arquivo selecionado
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(arq))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                conteudo.append(line);
                conteudo.append(System.lineSeparator());
            }
        }

        return conteudo.toString();
    }

    private static String getChaveCriptografia() {
        Scanner scn = new Scanner(System.in);
        String chave;
        boolean condicao;

        do {
            System.out.print("Chave da criptografia: ");
            chave = scn.nextLine();

            condicao = chave == null || chave.isEmpty() || chave.isBlank();

            if (condicao) {
                System.out.println("Chave inválida!\n");
            }

        } while (condicao);

        scn.close();

        return chave;
    }

}