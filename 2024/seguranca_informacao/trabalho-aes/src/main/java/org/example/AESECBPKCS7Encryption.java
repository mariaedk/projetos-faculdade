package org.example;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Scanner;

public class AESECBPKCS7Encryption {

    public static void main(String[] args) {
        try {
            // Scanner para entrada do usuário
            Scanner scanner = new Scanner(System.in);

            // Caminho do arquivo
            System.out.print("Digite o caminho do arquivo: ");
            String caminhoArquivo = scanner.nextLine();

            // Chave AES de 128 bits (16 bytes)
            System.out.print("Digite a chave (16 bytes): ");
            String chave = scanner.nextLine();

            // Verifica se a chave tem 16 bytes
            if (chave.length() != 16) {
                System.out.println("A chave deve ter 16 bytes.");
                return;
            }

            // Converte a chave para o formato adequado
            SecretKeySpec secretKeySpec = new SecretKeySpec(chave.getBytes(), "AES");

            // Cria uma instância do Cipher para criptografar os dados
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            // Carrega o arquivo que você deseja criptografar
            File inputFile = new File(caminhoArquivo);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            FileInputStream inputStream = new FileInputStream(inputFile);
            inputStream.read(inputBytes);
            inputStream.close();

            // Criptografa os dados
            byte[] encryptedBytes = cipher.doFinal(inputBytes);

            // Salva os dados criptografados em um novo arquivo
            FileOutputStream outputStream = new FileOutputStream("arquivoCriptografado.enc");
            outputStream.write(encryptedBytes);
            outputStream.close();

            System.out.println("Arquivo criptografado com sucesso.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}