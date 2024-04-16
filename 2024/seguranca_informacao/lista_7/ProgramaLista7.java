import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class ProgramaLista7 {

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        byte[] keyBytes = {65, 66, 67, 68, 69};

        // Utilizar o algoritmo Blowfish com ECB
        SecretKey key = new SecretKeySpec(keyBytes, "Blowfish");
        Cipher cipherECB = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
        cipherECB.init(Cipher.ENCRYPT_MODE, key);

        caso1(cipherECB);
        caso2(cipherECB);
        caso3(cipherECB);
        caso4(cipherECB);
        caso5(cipherECB);


        Cipher cipherCBC = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
        caso6(cipherCBC, key);
        caso7(cipherCBC, key);
        caso8(cipherCBC, key);
        caso9(cipherCBC, key);
    }

    private static void caso9(Cipher cipherCBC, SecretKey key) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] ivBytes = {10,20,30,40,50,60,70,80}; // Vetor de inicialização para CBC
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        cipherCBC.init(Cipher.ENCRYPT_MODE, key, ivSpec);

        System.out.println("CASO 9");
        byte[] SABONETE = getTextoCifrado(cipherCBC, "SABONETESABONETESABONETE");
        System.out.print("9.1 Texto cifrado (em hexadecimal): ");
        getHexadecimal(SABONETE);
        System.out.println("9.2 Apesar de aplicar o mesmo algoritmo, os vetores de inicialização são diferentes, o que" +
                " consequentemente produz resultados diferentes na criptografia, já que é um parâmetro importante.");

        ivBytes = new byte[]{1, 1, 2, 2, 3, 3, 4, 4}; // Vetor de inicialização para CBC
        ivSpec = new IvParameterSpec(ivBytes);
        cipherCBC.init(Cipher.DECRYPT_MODE, key, ivSpec);
        byte[] textoDescifrado = cipherCBC.doFinal(SABONETE);
        System.out.println("9.3 Texto descifrado: " + new String(textoDescifrado));
        System.out.println("9.3 Não foi possível obter o resultado correto no primeiro bloco pois o vetor de inicialização" +
                " impacta diretamente no primeiro bloco. Como o vetor que estamos usando para descriptografar é diferente" +
                " do utilizado para criptografar, acabamos falhando ao descriptografar o bloco 1.");
        System.out.println("======================================================");
        System.out.println();
    }

    private static void caso8(Cipher cipherCBC, SecretKey key) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] ivBytes = {1, 1, 2, 2, 3, 3, 4, 4}; // Vetor de inicialização para CBC
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        cipherCBC.init(Cipher.ENCRYPT_MODE, key, ivSpec);
        System.out.println("CASO 8");
        byte[] SABONETE = getTextoCifrado(cipherCBC, "SABONETESABONETESABONETE");
        System.out.print("8.1 Texto cifrado (em hexadecimal): ");
        getHexadecimal(SABONETE);
        // Foi assumido que a questão pedia a comparação com o caso 5, que parece fazer mais sentido devido a mesma
        // palavra ter sido usada nestes casos
        System.out.println("8.2 A repetição dos mesmos hexadecimais no caso 5 indica que o mesmo bloco de texto foi" +
                " criptografado várias vezes. No caso 8 não há repetições, ou seja, isso torna o texto cifrado" +
                " mais seguro.");
        System.out.println("======================================================");
        System.out.println();
    }

    private static void caso7(Cipher cipherCBC, SecretKey key) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] ivBytes = {1, 1, 2, 2, 3, 3, 4, 4}; // Vetor de inicialização para CBC
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        cipherCBC.init(Cipher.ENCRYPT_MODE, key, ivSpec);
        System.out.println("CASO 7");
        byte[] furbCBC = getTextoCifrado(cipherCBC, "FURB");
        System.out.print("7.1 Texto cifrado (em hexadecimal): ");
        getHexadecimal(furbCBC);
        System.out.println("======================================================");
        System.out.println();
    }

    private static void caso6(Cipher cipherCBC, SecretKey key) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        // cipherCBC.init(Cipher.ENCRYPT_MODE, key);
        byte[] ivBytes = {70, 71, 72, 73, 74, 75, 76, 77}; // Vetor de inicialização definido para o caso
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        cipherCBC.init(Cipher.ENCRYPT_MODE, key, ivSpec);

        System.out.println("CASO 6");
        byte[] furbCBC = getTextoCifrado(cipherCBC, "FURB");
        System.out.print("6.1 Texto cifrado (em hexadecimal): ");
        getHexadecimal(furbCBC);

        // decifrar
        cipherCBC.init(Cipher.DECRYPT_MODE, key, ivSpec);
        byte[] textoDescifrado = cipherCBC.doFinal(furbCBC);
        System.out.println("6.2 Texto descifrado: " + new String(textoDescifrado));
        System.out.println("6.2 Inicialmente, pode ocorrer erro, pois o vetor de inicialização não foi definido" +
                " para a descriptografia");

        System.out.println("======================================================");
        System.out.println();
    }

    /**
     * Caso 5
     */
    private static void caso5(Cipher c) throws IllegalBlockSizeException, BadPaddingException {
        System.out.println("CASO 5");
        byte[] sabonetesabonetesabonete = getTextoCifrado(c, "SABONETESABONETESABONETE");
        System.out.print("5.1 Texto cifrado (em hexadecimal): ");
        getHexadecimal(sabonetesabonetesabonete);
        System.out.println("5.2 Extensão do texto cifrado: " + sabonetesabonetesabonete.length + " bytes");
        System.out.println("5.3 Pode-se concluir que a cifra gerada se repete os mesmos hexadecimais para a palavra sabonete, pois a mesma se repete 3 vezes."
                + " Porém, gera um bloco a mais pois todos os blocos foram preenchidos, gerando um extra.");

        System.out.println("======================================================");
        System.out.println();
    }

    /**
     * Caso 4
     */
    private static void caso4(Cipher c) throws IllegalBlockSizeException, BadPaddingException {
        System.out.println("CASO 4");
        byte[] caso4 = {8, 8, 8, 8, 8, 8, 8, 8};
        byte[] doFinal = c.doFinal(caso4);
        System.out.print("4.1 Texto cifrado (em hexadecimal): ");
        getHexadecimal(doFinal);

        System.out.println("4.2 É igual, pois o último bloco gerado no caso 3, foi gerado automaticamente pelo algoritmo. Ou seja, "
                + "o array do caso 4 é o bloco padrão gerado pelo algoritmo." );

        System.out.println("======================================================");
        System.out.println();
    }

    /**
     * Caso 3
     */
    private static void caso3(Cipher c) throws IllegalBlockSizeException, BadPaddingException {
        System.out.println("CASO 3");
        byte[] sabonete = getTextoCifrado(c, "SABONETE");
        System.out.print("3.1 Texto cifrado (em hexadecimal): ");
        getHexadecimal(sabonete);

        System.out.println("3.2 Extensão do texto cifrado: " + sabonete.length + " bytes");
        System.out.println("3.3 O texto cifrado tem " + sabonete.length + " bytes. No caso, o texto contém 8 bytes, porém quando o último bloco não precisa de"
                + " preenchimento, ainda assim, gera um bloco adicional." );

        System.out.println("======================================================");
        System.out.println();
    }

    /**
     * Caso 2
     */
    private static void caso2(Cipher c) throws IllegalBlockSizeException, BadPaddingException {
        System.out.println("CASO 2");
        byte[] computador = getTextoCifrado(c, "COMPUTADOR");
        System.out.print("2.1 Texto cifrado (em hexadecimal): ");
        getHexadecimal(computador);

        System.out.println("2.2 Extensão do texto cifrado: " + computador.length + " bytes");
        System.out.println("2.3 O texto cifrado tem " + computador.length + " bytes, pois como o algoritmo trabalha com blocos de 8 bytes"
                + " e a palavra tem 10 bytes, será dividido em 2 blocos de 8 bytes, sendo que o último terá 6 bytes preenchidos pelo padding");
        System.out.println("======================================================");
        System.out.println();
    }

    /**
     * Caso 1
     */
    private static void caso1(Cipher c) throws IllegalBlockSizeException, BadPaddingException {
        System.out.println("CASO 1");
        byte[] furb = getTextoCifrado(c, "FURB");
        System.out.print("1.1 Texto cifrado (em hexadecimal): ");
        getHexadecimal(furb);

        System.out.println("1.2 Extensão do texto cifrado: " + furb.length + " bytes");
        System.out.println("======================================================");
        System.out.println();
    }

    public static byte[] getTextoCifrado(Cipher c, String textoSimples) throws IllegalBlockSizeException, BadPaddingException {
        byte[] textoSimplesBytes = textoSimples.getBytes();
        // Criptografar
        return c.doFinal(textoSimplesBytes);
    }

    public static void getHexadecimal(byte[] textoCifrado) {
        for (byte b : textoCifrado) {
            System.out.printf("%02X ", b);
        }
        System.out.println();
    }
}