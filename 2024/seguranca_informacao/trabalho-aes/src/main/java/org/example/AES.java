package org.example;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AES {

    File arquivo;

    public void iniciar() {
        try {
            Scanner scn = new Scanner(System.in);
            Chaves chaves = new Chaves();
            CifraAES cifra = new CifraAES();

            final String conteudo = getArquivo();
            // exemplo chave slide -> 65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80
            final String chave = getTextoUsuario(scn, "Chave da criptografia: ", "Chave inválida!\n");

            List<int[][]> roundKeys = chaves.getRoundKeys(chave);
            List<int[][]> listaBlocos = preencherPKCS7(conteudo.getBytes());
            List<int[][]> blocosCifrados = cifra.cifrarArquivo(listaBlocos, roundKeys);

            montarArquivoEncriptografado(scn, blocosCifrados);

            scn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String getArquivo() throws IllegalArgumentException, IOException {
        // caminho para arquivo teste - C:/Users/maria/OneDrive/Documentos/TESTE.txt
        StringBuilder conteudo = new StringBuilder();
        JFileChooser jfc = new JFileChooser();

        // filtro para somente arquivos .txt e .bin
        jfc.setFileFilter(new FileNameExtensionFilter("Arquivo para criptografar", "txt", "bin"));

        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            arquivo = jfc.getSelectedFile();
        }

        // verifica se o arquivo existe
        if (arquivo == null || !arquivo.exists()) {
            throw new IllegalArgumentException(String.format("%s - %d", "Falha ao ler arquivo selecionado", 1000L));
        }

        // le o arquivo selecionado
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(arquivo))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                conteudo.append(line);
            }
        }

        return conteudo.toString();
    }

    private String getTextoUsuario(Scanner scn, String msg, String msgErro) {

        String chave;
        boolean condicao;

        do {
            System.out.print(msg);
            chave = scn.nextLine();

            condicao = chave == null || chave.isEmpty() || chave.isBlank();

            if (condicao) {
                System.out.println(msgErro);
            }

        } while (condicao);

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

    private List<int[][]> preencherPKCS7ComLimitador(byte[] bytesArquivo) {
        int tamanhoBloco = 16;
        // para o PKCS7
        int tamanhoPreencher = 0;
        int diferenca = tamanhoBloco - (bytesArquivo.length % tamanhoBloco);

        if(bytesArquivo.length < 16) {
            tamanhoPreencher = diferenca;
        }
        else if(bytesArquivo.length > 16) {
            tamanhoPreencher = (bytesArquivo.length % tamanhoBloco) == 0 ? 0 : diferenca;
        }

        byte[] arquivoPreenchido = Arrays.copyOf(bytesArquivo, bytesArquivo.length + tamanhoPreencher);
        // para o bloco
        List<int[][]> blocosHexDecimal = new ArrayList<>();

        // preecher para ficar multiplo de 16 caso necessite
        for (int i = bytesArquivo.length; i < arquivoPreenchido.length; i++) {
            arquivoPreenchido[i] = (byte) tamanhoPreencher;
        }

        for (int i = 0; i < arquivoPreenchido.length; i += tamanhoBloco) {
            // 16 em 16 bytes
            byte[] bytesBloco = Arrays.copyOfRange(arquivoPreenchido, i, i + tamanhoBloco);
            // cria o bloco em hexadecimal e adiciona na lista de blocos
            blocosHexDecimal.add(getBlocoArquivo(bytesBloco));
        }
        return blocosHexDecimal;
    }
    private int[][] getBlocoArquivo(byte[] bytesBloco) {

        if (bytesBloco == null || bytesBloco.length != 16) {
            throw new IllegalArgumentException("tamanho de bytes inválidos - esperado 16 bytes");
        }

        int[][] decimalBloco = new int[4][4];

        // adiciona cs bytes e tranforma para hexadecimal
        for (int coluna = 0; coluna < 4; coluna++) {
            for (int linha = 0; linha < 4; linha++) {
                decimalBloco[linha][coluna] = bytesBloco[coluna * 4 + linha] & 0xFF;
            }
        }

        return decimalBloco;
    }

    private void montarArquivoEncriptografado(Scanner scn, List<int[][]> blocosCriptografados) throws IOException {
        if(blocosCriptografados == null || blocosCriptografados.isEmpty()) {
            throw new IllegalArgumentException(String.format("%s - %d", "Não existe bloco criptografado", 9998L));
        }

        String nomeArquivo = getTextoUsuario(scn, "Nome do arquivo a ser gerado: ", "Nome inválido\n");
        gravarArquivo(nomeArquivo, "dec", "decimal", blocosCriptografados);
        gravarArquivo(nomeArquivo, "hex", "hexadecimal", blocosCriptografados);
        gravarArquivo(nomeArquivo, "bin", "binario", blocosCriptografados);

        System.out.println("Arquivo criptografado com sucesso!");
    }

    private void gravarArquivo(String nomeArquivo, String extensao, String tipoDadoGravar, List<int[][]> blocosCriptografados) throws IOException {
        File arqCript = new File(alterarNomeArquivo(arquivo.getPath(), nomeArquivo, extensao));
        boolean condicao = arqCript.exists();
        int index = 1;

        while (condicao) {
            arqCript = new File(alterarNomeArquivo(arquivo.getPath(), String.format("%s(%d)", nomeArquivo, index++), extensao));
            condicao = arqCript.exists();
        }

        FileOutputStream fos = new FileOutputStream(arqCript);

        for (int[][] blocoCript : blocosCriptografados) {
            for (int coluna = 0; coluna < 4; coluna ++) {
                for (int linha = 0; linha < 4; linha ++) {
                    fos.write(validaTipoDadoGravar(tipoDadoGravar, blocoCript[linha][coluna]));
                }
            }
        }

        fos.close();
        System.out.printf("Arquivo %s gerado com sucesso!\n", arqCript.getName());
    }

    private byte[] validaTipoDadoGravar(String tipo, int decimal) {
        byte[] retorno = null;

        switch (tipo.toLowerCase()) {
            case "decimal":
                retorno = Integer.toString(decimal).getBytes();
                break;

            case "hexadecimal":
                retorno = Integer.toHexString(decimal).getBytes();
                break;

            case "binario":
                retorno = Integer.toBinaryString(decimal).getBytes();
                break;

            default:
                break;
        }

        return retorno;
    }

    /**
     * Método para alterar o nome do arquivo em um caminho, mantendo a extensão original
     */
    private String alterarNomeArquivo(String caminho, String novoNome, String extensao) {
        // encontrando a posição do último caractere '\\'
        int ultimaBarraIndex = caminho.lastIndexOf('\\');

        // extraindo o diretório do caminho original
        String diretorio = caminho.substring(0, ultimaBarraIndex + 1);

        // concatenando o novo nome do arquivo com a extensão original e o diretório
        return String.format("%s%s.%s", diretorio, novoNome, extensao);
    }

    public static void main(String[] args) {
        new AES().iniciar();
    }
}
