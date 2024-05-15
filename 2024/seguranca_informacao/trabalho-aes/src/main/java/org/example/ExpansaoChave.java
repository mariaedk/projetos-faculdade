package org.example;

public class ExpansaoChave {

    private final int[] roundConstantMatriz = {
            0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80, 0x1b, 0x36
    };

    protected int[] rotWord(int[] palavra) {
        // rotacionar os bytes. o primeiro byte se torna o último byte.
        int primeiroByte = palavra[0];
        for (int i = 0; i < palavra.length - 1; i++) {
            palavra[i] = palavra[i + 1];
        }
        palavra[palavra.length - 1] = primeiroByte;
        return palavra;
    }

    protected int[] subWord(int[] word) {
        // cria um novo array com os bytes substituídos na SBOX
        int[] novosValores = new int[word.length];

        for (int i = 0; i < word.length; i++) {
            novosValores[i] = Matrizes.getSboxValor(word[i]);
        }

        return novosValores;
    }

    protected int[] roundConstant(int roundKeyNumero) {
        // roundKeyNumero -> número da rodada. o primeiro byte do array que retorna é o byte relativo ao número da roundkey
        // o resto é 0.
        int[] roundConstants = new int[Chaves.TAMANHO_COLUNAS_LINHAS];
        int roundKeyByte = this.roundConstantMatriz[roundKeyNumero];
        roundConstants[0] = roundKeyByte;
        return roundConstants;
    }

    protected int[] xor(int[] array1, int[] array2) {
        // literalmente aplica um xor entre os arrays. ele consegue aplicar mesmo sendo um int pq ele interpreta
        // byte como int também.
        int[] result = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i] ^ array2[i];
        }
        return result;
    }
}