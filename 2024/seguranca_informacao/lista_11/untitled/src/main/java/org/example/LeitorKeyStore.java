package org.example;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Enumeration;

/**
 * @author Luan L. Guarnieri, Maria E. Krutzsch
 */
public class LeitorKeyStore {

    private KeyStore keystore;

    public LeitorKeyStore(String caminhoKeystore, char[] senhaKeystore) throws Exception {
        FileInputStream is = new FileInputStream(caminhoKeystore);
        keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        keystore.load(is, senhaKeystore);
    }

    public void exibirCertificados() throws Exception {
        Enumeration<String> aliases = keystore.aliases();
        while (aliases.hasMoreElements()) {
            String alias = aliases.nextElement();
            System.out.println("Alias: " + alias);

            Certificate cert = keystore.getCertificate(alias);
            if (cert instanceof X509Certificate) {
                X509Certificate x509Cert = (X509Certificate) cert;
                exibirDados(x509Cert);
            }
        }
    }

    private void exibirDados(X509Certificate certificado) {
        boolean isSelfSigned = certificado.getSubjectDN().equals(certificado.getIssuerDN());

        System.out.println("Período de Validade: " + certificado.getNotBefore() + " até " + certificado.getNotAfter());
        System.out.println("Proprietário: " + certificado.getSubjectDN());
        System.out.println("Emissor: " + certificado.getIssuerDN());
        System.out.println("Certificado válido: " + ((new Date().before(certificado.getNotAfter())) ? "sim" : "não"));
        System.out.println("Auto-assinado: " + (isSelfSigned ? "Sim" : "Não"));
        System.out.println();
    }

    public void cifrarImagem(String alias, String caminhoImagem, String caminhoImagemCifrada, String caminhoChaveAES) throws Exception {
        Certificate cert = keystore.getCertificate(alias);
        if (!(cert instanceof X509Certificate)) {
            throw new RuntimeException("Certificado não é do tipo X509");
        }
        X509Certificate x509Cert = (X509Certificate) cert;
        PublicKey publicKey = x509Cert.getPublicKey();

        byte[] chaveAESBytes = new byte[16];
        for (int i = 0; i < chaveAESBytes.length; i++) {
            chaveAESBytes[i] = 'A';
        }
        SecretKeySpec chaveAES = new SecretKeySpec(chaveAESBytes, "AES");

        byte[] imagemBytes = Files.readAllBytes(Paths.get(caminhoImagem));

        Cipher cipherAES = Cipher.getInstance("AES");
        cipherAES.init(Cipher.ENCRYPT_MODE, chaveAES);
        byte[] imagemCifrada = cipherAES.doFinal(imagemBytes);

        Files.write(Paths.get(caminhoImagemCifrada), imagemCifrada);

        Cipher cipherRSA = Cipher.getInstance("RSA");
        cipherRSA.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] chaveAESCifrada = cipherRSA.doFinal(chaveAES.getEncoded());

        try (FileOutputStream fos = new FileOutputStream(caminhoChaveAES)) {
            fos.write(chaveAESCifrada);
        }

        System.out.printf("\nImagem cifrada e chave AES armazenada com sucesso: %s", caminhoImagemCifrada);
    }

    public static void main(String[] args) {
        try {
            //para obter dados dos certificados
            String caminhoKeystore = "certificados/certificados.jks";
            char[] senhaKeystore = "furb123".toCharArray();

            //para cifrar a imagem
            String alias = "gilvan";
            String caminhoImagem = "certificados/imagemparacifrar.jpg";
            String caminhoImagemCifrada = "certificados/imagem-cifrada.aes";
            String caminhoChaveAES = "certificados/key.aes";

            LeitorKeyStore lks = new LeitorKeyStore(caminhoKeystore, senhaKeystore);

            System.out.println("Exibindo certificados:");
            lks.exibirCertificados();

            System.out.println("Cifrando imagem:");
            lks.cifrarImagem(alias, caminhoImagem, caminhoImagemCifrada, caminhoChaveAES);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
