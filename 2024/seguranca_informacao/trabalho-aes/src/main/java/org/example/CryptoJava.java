package org.example;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CryptoJava {

    // Método para criptografar um arquivo
    public static void encryptFile(String inputFilePath, String outputFilePath, SecretKey secretKey) throws Exception {
        byte[] inputFileBytes = Files.readAllBytes(Paths.get(inputFilePath));

        // Inicializa o cifrador
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Criptografa os bytes do arquivo
        byte[] encryptedBytes = cipher.doFinal(inputFileBytes);

        // Escreve os bytes criptografados em um novo arquivo
        Files.write(Paths.get(outputFilePath), encryptedBytes);

        System.out.println("Arquivo criptografado com sucesso: " + outputFilePath);
    }

    // Método para descriptografar um arquivo
    public static void decryptFile(String inputFilePath, String outputFilePath, SecretKey secretKey) throws Exception {
        byte[] inputFileBytes = Files.readAllBytes(Paths.get(inputFilePath));

        // Inicializa o cifrador
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Descriptografa os bytes do arquivo
        byte[] decryptedBytes = cipher.doFinal(inputFileBytes);

        // Escreve os bytes descriptografados em um novo arquivo
        Files.write(Paths.get(outputFilePath), decryptedBytes);

        System.out.println("Arquivo descriptografado com sucesso: " + outputFilePath);
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Solicita o caminho do arquivo a ser criptografado
            //System.out.print("Digite o caminho do arquivo a ser criptografado: ");
            //String inputFilePath = scanner.nextLine();

            // Define o caminho para o arquivo criptografado
            //String encryptedFilePath = inputFilePath + ".encrypted";

            // Define o caminho para o arquivo descriptografado
            String decryptedFilePath = "C:/Users/maria/OneDrive/Documentos/GERADO-AUTO" + ".decrypted";

            // Chave AES
            byte[] keyBytes = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80};
            SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");

            // Criptografa o arquivo
            //encryptFile(inputFilePath, encryptedFilePath, secretKey);

            // Solicita o caminho do arquivo a ser descriptografado
            System.out.print("Digite o caminho do arquivo a ser descriptografar: ");
            String descriptar = scanner.nextLine();

            // Descriptografa o arquivo criptografado
            decryptFile(descriptar, decryptedFilePath, secretKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
