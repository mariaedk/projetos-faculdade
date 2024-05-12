package org.example;

public class ExpansaoChave {

    private final int[][] sbox; // Mudança aqui para int[][]

    private final int[] roundConstantMatriz = {
            0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80, 0x1b, 0x36
    };

    public ExpansaoChave(int[][] sbox) {
        this.sbox = sbox;
    }

    public int[] rotWord(int[] palavra) {
        // rotacionar os bytes. o primeiro byte se torna o último byte.
        int primeiroByte = palavra[0];
        for (int i = 0; i < palavra.length - 1; i++) {
            palavra[i] = palavra[i + 1];
        }
        palavra[palavra.length - 1] = primeiroByte;
        return palavra;
    }

    public int[] subWord(int[] word) {
        // cria um novo array com os bytes substituídos na SBOX
        int[] novosValores = new int[word.length];
        for (int i = 0; i < word.length; i++) {
            // 0xF0 -> máscara que isola os bits mais significativos, faz um AND pra pegar só eles
            // >> 4 -> desloca os bits para a direita em 4 posições, ou seja, descarta os 4 bits menos significativos
            // faz o deslocamento pois quando converter para decimal, obtém a linha
            /**
             * Exemplo: 0xAB. Em binário, isso seria 1010 1011.
             * Quando fazemos a operação & 0xF0, estamos "zerando" os 4 bits menos significativos do byte original.
             * Isso resulta em 1010 0000 (ou 0xA0 em hexadecimal).
             * Agora, se fizermos >> 4, estamos deslocando esses 4 bits mais significativos para a direita, deixando-os na posição dos bits menos significativos.
             * O resultado é 0000 1010, que em decimal é 10. Esse é o valor que usamos para determinar a linha na S-Box.
             */
            int linha = (word[i] & 0xF0) >> 4;
            // 0x0F -> máscara que isola os bits menos significativos, faz um AND pra pegar só eles
            int coluna = word[i] & 0x0F;
            // & 0xFF Converte em um inteiro sem sinal, ou seja, retorna a representação do hexadecimal na SBOX, em decimal.
            novosValores[i] = sbox[linha][coluna] & 0xFF;
        }
        return novosValores;
    }

    public int[] roundConstant(int roundKeyNumero) {
        // roundKeyNumero -> número da rodada. o primeiro byte do array que retorna é o byte relativo ao número da roundkey
        // o resto é 0.
        int[] roundConstants = new int[Main.TAMANHO_COLUNAS_LINHAS];
        int roundKeyByte = this.roundConstantMatriz[roundKeyNumero];
        roundConstants[0] = roundKeyByte;
        return roundConstants;
    }

    public int[] xor(int[] array1, int[] array2) {
        // literalmente aplica um xor entre os arrays. ele consegue aplicar mesmo sendo um int pq ele interpreta
        // byte como int também.
        int[] result = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i] ^ array2[i];
        }
        return result;
    }
}