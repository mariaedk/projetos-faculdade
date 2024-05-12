package org.example;

import java.util.ArrayList;
import java.util.List;

public class Chaves {

    public static final int TAMANHO_COLUNAS_LINHAS = 4;

    public List<int[][]> getRoundKeys(String chave) {
        return gerarChaves(getMatrizEstado(chave));
    }

    private List<int[][]> gerarChaves(int[][] matrizEstado) {
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

    private int[] gerarPrimeiraPalavraRoundKey(int[][] matrizEstado, ExpansaoChave expansaoChave, int roundKeyNumero) {
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

    private int[] getColuna(int[][] matrizEstado, int indexColuna) {
        int comprimento = matrizEstado.length;
        int[] coluna = new int[comprimento];
        for (int i = 0; i < comprimento; i++) {
            coluna[i] = matrizEstado[i][indexColuna];
        }
        return coluna;
    }

    private int[][] armazenaColuna(int[][] matriz, int[] coluna, int indexColuna) {
        for (int i = 0; i < TAMANHO_COLUNAS_LINHAS; i++) {
            matriz[i][indexColuna] = coluna[i];
        }
        return matriz;
    }

    private int[][] getMatrizEstado(String chave) {
        if (chave == null) {
            throw new IllegalArgumentException(String.format("%s - %d", "chave inválida", 9999L));
        }

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

}
