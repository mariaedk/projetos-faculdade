import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.security.*;

public class DecriptografiaAESRSA {
    public void executar(String privada, String chaveAesCript, String arqCript, String arqDescript) throws Exception {
        // Carregar chave privada RSA
        PrivateKey chavePrivada = carregarChavePrivada(privada);

        // Decriptografar chave AES com RSA
        SecretKey chaveAES = decriptografarChaveSimetricaComRSA(chaveAesCript, chavePrivada);

        // Decriptografar arquivo com AES
        decriptografarComAES(arqCript, arqDescript, chaveAES);
    }

    private PrivateKey carregarChavePrivada(String arquivoChavePrivada) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivoChavePrivada))) {
            return (PrivateKey) ois.readObject();
        }
    }

    private SecretKey decriptografarChaveSimetricaComRSA(String arquivoChaveCriptografadaRSA, PrivateKey chavePrivada) throws Exception {
        try (FileInputStream fis = new FileInputStream(arquivoChaveCriptografadaRSA)) {
            byte[] dadosCriptografados;
            int tamanhoArquivo = fis.available();
            dadosCriptografados = new byte[tamanhoArquivo];
            fis.read(dadosCriptografados);

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, chavePrivada);
            byte[] chaveDecriptografada = cipher.doFinal(dadosCriptografados);

            return new SecretKeySpec(chaveDecriptografada, "AES");
        }
    }

    private void decriptografarComAES(String arquivoCriptografado, String arquivoDecriptografado, SecretKey chaveAES) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, chaveAES);
        byte[] conteudoCriptografado = Files.readAllBytes(new File(arquivoCriptografado).toPath());
        byte[] textoDecriptografado = cipher.doFinal(conteudoCriptografado);
        try (FileOutputStream fos = new FileOutputStream(arquivoDecriptografado)) {
            fos.write(textoDecriptografado);
        }
    }
}
