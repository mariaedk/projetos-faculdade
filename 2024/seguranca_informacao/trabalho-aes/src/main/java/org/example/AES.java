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

public class AES {

    public AES() {
        iniciar();
    }

    private void iniciar() {
        try {
            Chaves chaves = new Chaves();
            CifraAES cifra = new CifraAES();

            final String conteudo = getArquivo();
            // exemplo chave slide -> 65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80
            final String chave = getChaveCriptografia();

            List<int[][]> roundKeys = chaves.getRoundKeys(chave);
            List<int[][]> listaBlocos = preencherPKCS7(conteudo.getBytes());

            cifra.cifrarArquivo(listaBlocos, roundKeys);
            //TODO escolher arquivo, gerar arquivo e salvar

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String getArquivo() throws IllegalArgumentException, IOException {
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
            throw new IllegalArgumentException(String.format("%s - %d", "Falha ao ler arquivo selecionado", 1000L));
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

    private String getChaveCriptografia() {
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
    private List<int[][]> preencherPKCS7(byte[] bytesArquivo) {
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

    private int[][] getBlocoArquivo(byte[] bytesBloco) {

        if (bytesBloco == null || bytesBloco.length != 16) {
            throw new IllegalArgumentException("tamanho de bytes inválidos - esperado 16 bytes");
        }

        int[][] decimalBloco = new int[4][4];

        //adiciona cs bytes e tranforma para hexadecimal
        for (int coluna = 0; coluna < 4; coluna++) {
            for (int linha = 0; linha < 4; linha++) {
                decimalBloco[linha][coluna] = bytesBloco[coluna * 4 + linha] & 0xFF;
            }
        }

        return decimalBloco;
    }

    public static void main(String[] args) {
        new AES();
    }
}
