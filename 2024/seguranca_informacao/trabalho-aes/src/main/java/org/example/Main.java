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

    public static final int[][] SBOX = {
            { 0x63, 0x7c, 0x77, 0x7b, 0xf2, 0x6b, 0x6f, 0xc5, 0x30, 0x01, 0x67, 0x2b, 0xfe, 0xd7, 0xab, 0x76 },
            { 0xca, 0x82, 0xc9, 0x7d, 0xfa, 0x59, 0x47, 0xf0, 0xad, 0xd4, 0xa2, 0xaf, 0x9c, 0xa4, 0x72, 0xc0 },
            { 0xb7, 0xfd, 0x93, 0x26, 0x36, 0x3f, 0xf7, 0xcc, 0x34, 0xa5, 0xe5, 0xf1, 0x71, 0xd8, 0x31, 0x15 },
            { 0x04, 0xc7, 0x23, 0xc3, 0x18, 0x96, 0x05, 0x9a, 0x07, 0x12, 0x80, 0xe2, 0xeb, 0x27, 0xb2, 0x75 },
            { 0x09, 0x83, 0x2c, 0x1a, 0x1b, 0x6e, 0x5a, 0xa0, 0x52, 0x3b, 0xd6, 0xb3, 0x29, 0xe3, 0x2f, 0x84 },
            { 0x53, 0xd1, 0x00, 0xed, 0x20, 0xfc, 0xb1, 0x5b, 0x6a, 0xcb, 0xbe, 0x39, 0x4a, 0x4c, 0x58, 0xcf },
            { 0xd0, 0xef, 0xaa, 0xfb, 0x43, 0x4d, 0x33, 0x85, 0x45, 0xf9, 0x02, 0x7f, 0x50, 0x3c, 0x9f, 0xa8 },
            { 0x51, 0xa3, 0x40, 0x8f, 0x92, 0x9d, 0x38, 0xf5, 0xbc, 0xb6, 0xda, 0x21, 0x10, 0xff, 0xf3, 0xd2 },
            { 0xcd, 0x0c, 0x13, 0xec, 0x5f, 0x97, 0x44, 0x17, 0xc4, 0xa7, 0x7e, 0x3d, 0x64, 0x5d, 0x19, 0x73 },
            { 0x60, 0x81, 0x4f, 0xdc, 0x22, 0x2a, 0x90, 0x88, 0x46, 0xee, 0xb8, 0x14, 0xde, 0x5e, 0x0b, 0xdb },
            { 0xe0, 0x32, 0x3a, 0x0a, 0x49, 0x06, 0x24, 0x5c, 0xc2, 0xd3, 0xac, 0x62, 0x91, 0x95, 0xe4, 0x79 },
            { 0xe7, 0xc8, 0x37, 0x6d, 0x8d, 0xd5, 0x4e, 0xa9, 0x6c, 0x56, 0xf4, 0xea, 0x65, 0x7a, 0xae, 0x08 },
            { 0xba, 0x78, 0x25, 0x2e, 0x1c, 0xa6, 0xb4, 0xc6, 0xe8, 0xdd, 0x74, 0x1f, 0x4b, 0xbd, 0x8b, 0x8a },
            { 0x70, 0x3e, 0xb5, 0x66, 0x48, 0x03, 0xf6, 0x0e, 0x61, 0x35, 0x57, 0xb9, 0x86, 0xc1, 0x1d, 0x9e },
            { 0xe1, 0xf8, 0x98, 0x11, 0x69, 0xd9, 0x8e, 0x94, 0x9b, 0x1e, 0x87, 0xe9, 0xce, 0x55, 0x28, 0xdf },
            { 0x8c, 0xa1, 0x89, 0x0d, 0xbf, 0xe6, 0x42, 0x68, 0x41, 0x99, 0x2d, 0x0f, 0xb0, 0x54, 0xbb, 0x16 }
    };

    public static final int TAMANHO_COLUNAS_LINHAS = 4;

    public static void main(String[] args) throws IOException {

        try {
            final String conteudo = getArquivo();
            // exemplo chave slide -> 65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80
            final String chave = getChaveCriptografia();

            int[][] matrizEstado = getMatrizEstado(chave);
            byte[] dadosPreenchidos = preencherPKCS7(conteudo.getBytes());

            List<int[][]> roundKeys = gerarChaves(matrizEstado);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<int[][]> gerarChaves(int[][] matrizEstado) {
        ExpansaoChave expansaoChave = new ExpansaoChave(SBOX);
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
        int[][] newValue = matriz;
        for (int i = 0; i < TAMANHO_COLUNAS_LINHAS; i++) {
            newValue[i][indexColuna] = coluna[i];
        }
        return newValue;
    }

    private static byte[] preencherPKCS7(byte[] dados) {
        int tamanhoBloco = 16; // 16 bytes -> 128 bits
        int tamanhoPreencher = tamanhoBloco - (dados.length % tamanhoBloco);
        byte[] dadosPreenchidos = Arrays.copyOf(dados, dados.length + tamanhoPreencher);
        for (int i = dados.length; i < dadosPreenchidos.length; i++) {
            dadosPreenchidos[i] = (byte) tamanhoPreencher;
        }
        return dadosPreenchidos;
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