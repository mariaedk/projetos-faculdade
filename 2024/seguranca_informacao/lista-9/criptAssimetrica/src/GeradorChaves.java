import java.io.*;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class GeradorChaves {
    public void executar(String chavePublica, String chavePrivada) throws Exception {
        // Gerar par de chaves RSA
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Obter chaves privada e pública
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // Exibir valores do módulo e dos expoentes
        System.out.println("Chave Privada:");
        System.out.println("Módulo: " + ((RSAPrivateKey) privateKey).getModulus());
        System.out.println("Expoente: " + ((RSAPrivateKey) privateKey).getPrivateExponent());

        System.out.println("\nChave Pública:");
        System.out.println("Módulo: " + ((RSAPublicKey) publicKey).getModulus());
        System.out.println("Expoente: " + ((RSAPublicKey) publicKey).getPublicExponent());

        // Salvar chaves em arquivos separados
        salvarChave(privateKey, chavePrivada);
        salvarChave(publicKey, chavePublica);
    }

    private void salvarChave(Key chave, String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(chave);
        }
    }
}