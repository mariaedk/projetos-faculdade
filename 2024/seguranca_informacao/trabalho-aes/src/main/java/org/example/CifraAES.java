package org.example;

import java.util.ArrayList;
import java.util.List;

public class CifraAES {

    /**
     * Criptografa o arquivo
     *
     * @param listaBlocos - blocos de 16Bytes de texto não criptografado
     * @param roundKey - lista das chaves geradas para a criptografia
     * @return Listint[][] lista com blocos de 16Bytes criptografados em formato decimal
     */
    public List<int[][]> cifrarArquivo(List<int[][]> listaBlocos, List<int[][]> roundKey) {

        List<int[][]> blocosCifrados = new ArrayList<>();
        int[][] matriz;

        for (int[][] bloco : listaBlocos) {
            //primeira etapa
            matriz = efetuarXor(bloco, roundKey.get(0));

            for (int rodada = 1; rodada < 10; rodada ++) {
                // segunda etapa
                matriz = subBytes(matriz);
                // terceira etapa
                matriz = shiftRows(matriz);
                // quarta etapa
                matriz = mixColumns(matriz);
                // quinta etapa
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

        if((bloco == null || key == null) || (bloco.length != key.length)) {
            throw new IllegalArgumentException(String.format("%s - %d", "Bloco ou chave inválido", 1001L));
        }

        int[][] resultado = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                resultado[i][j] = bloco[i][j] ^ key[i][j];
            }
        }

        return resultado;
    }

    /**
     * Troca os valores da matriz, de acordo com a tabela de valores do SBox
     *
     * @param matriz matriz 4x4
     * @return matriz 4x4
     */
    private int[][] subBytes(int[][] matriz) {

        if (matriz == null || matriz.length != 4) {
            throw new IllegalArgumentException(String.format("%s - %d", "Matriz sem valor", 1002L));
        }

        int[][] resultado =  new int[4][4];

        for (int coluna = 0; coluna < 4; coluna ++) {
            for (int linha = 0; linha < 4; linha ++) {
                resultado[linha][coluna] = MATRIZES.getSboxValor(matriz[linha][coluna]);
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

        if (matriz == null) {
            throw new IllegalArgumentException(String.format("%s - %d", "Matriz sem valor", 1003L));
        }

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

        if (matriz == null) {
            throw new IllegalArgumentException(String.format("%s - %d", "Matriz sem valor", 1004L));
        }

        int[][] newState = new int[4][4];

        for (int coluna = 0; coluna < 4; coluna++) {
            for (int linha = 0; linha < 4; linha++) {
                // para cada elemento
                multiplicacaoGalois(matriz, linha, coluna, newState);
            }
        }

        return newState;
    }

    private void multiplicacaoGalois(int[][] matriz, int linha, int coluna, int[][] newState) {
        final int[][] MIX_COLUMN_MATRIX = {
                {0x02, 0x03, 0x01, 0x01},
                {0x01, 0x02, 0x03, 0x01},
                {0x01, 0x01, 0x02, 0x03},
                {0x03, 0x01, 0x01, 0x02}
        };

        // linha pega na matriz de multiplicacao, coluna pega da matriz de estado
        int[] linhaMatrizMultiplicacao = MIX_COLUMN_MATRIX[linha];
        int[] colunaMatrizEstado = getColuna(matriz, coluna);
        int[] resultadoMultiplicacaoElementos = new int[4];

        for (int i = 0; i < linhaMatrizMultiplicacao.length; i++) {
            // condições slide 28
            // Se um dos termos for 0, o resultado da multiplicação é 0
            if (linhaMatrizMultiplicacao[i] == 0 || colunaMatrizEstado[i] == 0) {
                resultadoMultiplicacaoElementos[i] = 0;
                // Se um dos termos for 1, o resultado da multiplicação é igual ao outro termo
            } else if (linhaMatrizMultiplicacao[i] == 1) {
                resultadoMultiplicacaoElementos[i] = colunaMatrizEstado[i];
            } else if (colunaMatrizEstado[i] == 1) {
                resultadoMultiplicacaoElementos[i] = linhaMatrizMultiplicacao[i];
                // Se os termos não forem 0 e nem 1, deve-se recorrer à tabela L e à tabela E
            } else {
                resultadoMultiplicacaoElementos[i] = recorrerTabelas(linhaMatrizMultiplicacao, i, colunaMatrizEstado);
            }
        }
        int result = 0;
        for (int i = 0; i < resultadoMultiplicacaoElementos.length; i++) {
            result ^= resultadoMultiplicacaoElementos[i];
        }
        newState[linha][coluna] = result;
    }

    private static int recorrerTabelas(int[] linhaMatrizMultiplicacao, int i, int[] colunaMatrizEstado) {
        int valorLinha = MATRIZES.getTabelaLValor(linhaMatrizMultiplicacao[i]);
        int valorColuna = MATRIZES.getTabelaLValor(colunaMatrizEstado[i]);
        int soma = valorLinha + valorColuna;

        // se o resultado da soma ultrapassar 0𝑥FF, faz-se ajuste, subtraindo o valor de 0𝑥FF: 𝑟𝑒𝑠𝑢𝑙𝑡𝑎𝑑𝑜 - 0𝑥FF
        if (soma > 0xFF) {
            soma = soma - 0xFF;
        }
        return MATRIZES.getTabelaEValor(soma);
    }

    private int[] getColuna(int[][] matrizEstado, int indexColuna) {
        int comprimento = matrizEstado.length;
        int[] coluna = new int[comprimento];
        for (int i = 0; i < comprimento; i++) {
            coluna[i] = matrizEstado[i][indexColuna];
        }
        return coluna;
    }

}
