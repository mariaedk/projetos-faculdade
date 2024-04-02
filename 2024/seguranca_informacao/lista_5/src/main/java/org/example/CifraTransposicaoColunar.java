package org.example;

import java.util.Scanner;

/**
 * @author maria eduarda krutzsch
 * @author luan lavandoski guarnieri
 */
public class CifraTransposicaoColunar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String textoCifrar = scanner.nextLine(); // texto para cifrar
        int qtdColunas =  scanner.nextInt(); // quantidade de colunas
        String textoSemEspacos = textoCifrar.replaceAll(" ", "");
        double qtdLinhas = Math.ceil((double) textoSemEspacos.length() / qtdColunas);

        char[][] matriz = new char[(int) qtdLinhas][qtdColunas];

        int contador = 0;
        for (int i = 0; i < qtdLinhas; i++) {
            for (int j = 0; j < qtdColunas; j++) {
                if (contador >= textoSemEspacos.length()) {
                    matriz[i][j] = 'x';
                } else {
                    matriz[i][j] = textoSemEspacos.charAt(contador);
                    contador++;
                }
            }
        }
        // Cifrar
        for (int i = 0; i < qtdColunas; i++) {
            for (int j = 0; j < qtdLinhas; j++) {
                System.out.print(matriz[j][i]);
            }
        }

        System.out.println();
        // Decifrar
        for (int i = 0; i < qtdLinhas; i++) {
            for (int j = 0; j < qtdColunas; j++) {
                System.out.print(matriz[i][j]);
            }
        }
    }
}
