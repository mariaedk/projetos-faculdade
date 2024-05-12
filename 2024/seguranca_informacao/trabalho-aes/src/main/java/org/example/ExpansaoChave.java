package org.example;

public class ExpansaoChave {

    private final byte[][] sbox;

    private final byte[] roundConstantMatriz = {
            (byte) 0x00, (byte) 0x01, (byte) 0x02, (byte) 0x04, (byte) 0x08, (byte) 0x10, (byte) 0x20, (byte) 0x40, (byte) 0x80, (byte) 0x1b, (byte) 0x36
    };

    public ExpansaoChave(byte[][] sbox) {
        this.sbox = sbox;
    }

    // na primeira execução vai fornecer como parâmetro a última palavra (última coluna da matriz de estado de entrada)
    public byte[] rotWord(byte[] palavra) {
        // o primeiro byte vira o último.
        byte primeiroByte = palavra[0];
        for (int i = 0; i < palavra.length - 1; i++) {
            palavra[i] = palavra[i + 1];
        }
        palavra[palavra.length - 1] = primeiroByte;
        return palavra;
    }

    public byte[] subWord(byte[] word) {
        // vai gerar um novo array com valores mapeados da sbox
        byte[] novosValores = new byte[word.length];
        for (int i = 0; i < word.length; i++) {
            // & -> operador bitwise que compara cada bit de dois operandos
            // 0xF0 -> máscara hexadecimal usada para isolar o bit mais significativo
            // >> 4 -> desloca os bits para a direita em 4 posições, ou seja, descarta os 4 bits menos significativos
            // e coloca os 4 mais significativos na posição deles, converte para decimal para ter a linha na sbox (pois nao reconhece A por exemplo, que é 10)
            int row = (word[i] & 0xF0) >> 4;
            // 0xF0 -> máscara hexadecimal usada para isolar o bit menos significativos
            // retorna um inteiro que vai representar a coluna na sbox
            int col = word[i] & 0x0F;
            // na sbox, pesquisa os valores pela linha e coluna
            novosValores[i] = sbox[row][col];
        }
        return novosValores;
    }

    public byte[] roundConstant(int roundKeyNumero) {
        byte[] roundConstants = new byte[Main.TAMANHO_COLUNAS_LINHAS];
        byte roundKeyByte = this.roundConstantMatriz[roundKeyNumero];
        // o primeiro byte é relativo a roundKey
        roundConstants[0] = roundKeyByte;
        for (int i = 1; i < Main.TAMANHO_COLUNAS_LINHAS; i++) {
            roundConstants[i] = (byte) 0;
        }
        return roundConstants;
    }

}
