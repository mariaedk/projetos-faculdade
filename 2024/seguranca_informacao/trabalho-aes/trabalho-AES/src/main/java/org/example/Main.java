package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Caminho do arquivo: ");
        String caminho = scanner.nextLine();
        // C:/Users/maria/OneDrive/Documentos/TESTE.txt
        File file = new File(caminho);

        if (!isFileValid(file)) return;

        final String conteudo = lerArquivo(file);
        // 20,1,94,33,199,0,48,9,31,94,112,40,59,30,100,248
        System.out.print("Chave da criptografia: ");
        String chave = scanner.nextLine();

        // receber valores dos bytes da chave em formato decimal, separado por vírgula
        String[] bytes = chave.split(",");
        // tratando a matriz de estado de chave como String
        String[][] matrizEstadoChave = new String[4][4];
        int contador = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String valorHexadecimal = Integer.toHexString(Integer.parseInt(bytes[contador]));
                matrizEstadoChave[j][i] = valorHexadecimal;
                contador++;
            }
        }
    }

    private static String lerArquivo(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder conteudo = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            conteudo.append(line);
            conteudo.append(System.lineSeparator());
        }
        bufferedReader.close();
        return conteudo.toString();
    }

    private static boolean isFileValid(File file) {
        if (!file.exists()) {
            System.out.println("Arquivo não encontrado.");
            return false;
        }
        return true;
    }
}
