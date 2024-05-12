package org.example;

import java.util.ArrayList;
import java.util.List;

public class AES {

    /**
     * Criptografa o arquivo
     *
     * @param listaBlocos - blocos de 16Bytes de texto não criptografado
     * @param roundKey - lista das chaves geradas para a criptografia
     * @return Listint[][] lista com blocos de 16Bytes criptografados em formato decimal
     */
    private List<int[][]> cifrarArquivo(List<int[][]> listaBlocos, List<int[][]> roundKey) {

        List<int[][]> blocosCifrados = new ArrayList<>();
        int[][] matriz;

        for (int[][] bloco : listaBlocos) {
            //primeira etapa
            matriz = efetuarXor(bloco, roundKey.get(0));

            for (int rodada = 1; rodada < 10; rodada ++) {
                //segunda etapa
                matriz = subBytes(matriz);
                //terceira etapa
                matriz = shiftRows(matriz);
                //quarta etapa
                matriz = mixColumns(matriz);
                //quinta etapa
                matriz = efetuarXor(matriz, roundKey.get(rodada));
            }

            matriz = subBytes(matriz);
            matriz = shiftRows(matriz);
            matriz = efetuarXor(matriz, roundKey.get(10));

            //adicionando o bloco cifrado a lista
            blocosCifrados.add(matriz);
        }

        return blocosCifrados;
    }

    /**
     * Efetua operação xor com duas matrizes
     * (se valor matriz 1 == valor matriz 2 = 1 senão 0
     *
     * @param bloco matriz 4x4
     * @param key matriz 4x4, a roundKey
     * @return matriz 4x4
     */
    private int[][] efetuarXor(int[][] bloco, int[][] key) {
        int[][] resultado = new int[4][4];

        if(bloco.length != key.length) {
            throw new IllegalArgumentException("Matrizes com tamanhos diferentes");
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                resultado[i][j] = bloco[i][j] ^ key[i][j];
            }
        }

        return resultado;
    }

    /**
     *  Troca os valores da matriz, de acordo com a tabela de valores do SBox
     *
     * @param matriz matriz 4x4
     * @return matriz 4x4
     */
    private int[][] subBytes(int[][] matriz) {
        int[][] resultado =  new int[4][4];

        if(matriz != null && matriz.length != 16) {
            for (int coluna = 0; coluna < 4; coluna ++) {
                for (int linha = 0; linha < 4; linha ++) {
                    resultado[linha][coluna] = SBox.getValor(matriz[linha][coluna]);
                }
            }
        }

        return resultado;
    }

    /**
     * Embaralha a matriz
     * 1ª linha não mexe
     * 2ª linha vai uma pos para a esquerda
     * 3ª linha vai duas pos para a esquerda
     * 4ª linha vai tres pos para a esquerda
     *
     * @param matriz matriz 4x4
     * @return matriz 4x4
     */
    private int[][] shiftRows(int[][] matriz) {
        int[][] retorno = new int[4][4];

        // Primeira linha permanece inalterada
        retorno[0] = matriz[0];

        // Segunda linha é rotacionada uma posição para a esquerda
        for (int col = 0; col < 4; col++) {
            retorno[1][col] = matriz[1][(col + 1) % 4];
        }

        // Terceira linha é rotacionada duas posições para a esquerda
        for (int col = 0; col < 4; col++) {
            retorno[2][col] = matriz[2][(col + 2) % 4];
        }

        // Quarta linha é rotacionada três posições para a esquerda
        for (int col = 0; col < 4; col++) {
            retorno[3][col] = matriz[3][(col + 3) % 4];
        }

        return retorno;
    }

    /**
     *
     * @param matriz matriz 4x4
     * @return matriz 4x4
     */
    private int[][] mixColumns(int[][] matriz) {
        int[][] retorno = new int[4][4];
        //TODO implementar

        return retorno;
    }

}
