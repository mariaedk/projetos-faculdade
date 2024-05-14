import javax.crypto.*;
import java.io.*;
import java.nio.file.Files;
import java.security.*;
import java.util.Scanner;

public class CriptografiaAESRSA {
    public void executar(String publica, String arqCript, String arqChaveAesCript) throws Exception {
        // Carregar chave pública RSA
        PublicKey chavePublica = carregarChavePublica(publica);

        // Gerar chave simétrica AES
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey chaveAES = keyGenerator.generateKey();

        // Criptografar arquivo com AES
        criptografarComAES(caminhoArquivoCriptografar(), arqCript, chaveAES);

        // Criptografar chave AES com RSA
        criptografarChaveSimetricaComRSA(arqChaveAesCript, chaveAES, chavePublica);
    }

    private PublicKey carregarChavePublica(String arquivoChavePublica) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivoChavePublica))) {
            return (PublicKey) ois.readObject();
        }
    }

    private void criptografarComAES(String arquivoOriginal, String arquivoCriptografado, SecretKey chaveAES) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, chaveAES);
        byte[] conteudoArquivo = Files.readAllBytes(new File(arquivoOriginal).toPath());
        byte[] textoCriptografado = cipher.doFinal(conteudoArquivo);
        try (FileOutputStream fos = new FileOutputStream(arquivoCriptografado)) {
            fos.write(textoCriptografado);
        }
    }

    private void criptografarChaveSimetricaComRSA(String arquivoChaveCriptografadaRSA, SecretKey chaveAES, PublicKey chavePublica) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, chavePublica);
        byte[] chaveCriptografada = cipher.doFinal(chaveAES.getEncoded());
        try (FileOutputStream fos = new FileOutputStream(arquivoChaveCriptografadaRSA)) {
            fos.write(chaveCriptografada);
        }
    }

    private String caminhoArquivoCriptografar() {
        System.out.println("caminho arquivo: ");
        return new Scanner(System.in).next();
    }
}
