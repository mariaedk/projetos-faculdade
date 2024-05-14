/**
 * @author Luan L. Guarnieri
 * @author Maria E. Krutzsch
 */
public class Main {

    public static void main(String[] args) {
        try {
            final String CHAVE_PUBLICA = "chave_publica.dat";
            final String CHAVE_PRIVADA = "chave_privada.dat";
            final String ARQUIVO_CRIPT = "arquivo_criptografado_AES.bin";
            final String CHAVE_AES_CRIPT = "chave_aes_criptografada.bin";
            final String ARQUIVO_DESCRIPT = "arquivo_descriptografado.txt";

            /*Questão 1
            Crie um programa que gere um par de chaves privada e pública relacionadas.
            Exiba o valor do módulo e dos expoentes de cada chave gerada.
            Salve cada uma das chaves num arquivo separado, pois as chaves precisarão ser recuperadas nas questões seguintes.
             */
            new GeradorChaves().executar(CHAVE_PUBLICA, CHAVE_PRIVADA);

            /*
            Questão 2
            Crie um programa que criptografe um arquivo submetido pelo usuário utilizando o algoritmo AES.
            Criptografe a chave simétrica utilizada (do algoritmo AES) utilizando a chave pública gerada na questão 1.
             */
            new CriptografiaAESRSA().executar(CHAVE_PUBLICA, ARQUIVO_CRIPT, CHAVE_AES_CRIPT);

            /*
            Questão 3
            Crie um programa que decriptografe a chave de um algoritmo AES, utilizando a chave simétrica gerada na questão 2.
            Será preciso recorrer a chave privada, gerada na questão 1, para poder decifrar a chave.
             */
            new DecriptografiaAESRSA().executar(CHAVE_PRIVADA, CHAVE_AES_CRIPT, ARQUIVO_CRIPT, ARQUIVO_DESCRIPT);

        } catch (Exception e) {
            System.out.println(String.format("deu BO\n%s", e.getMessage()));
        }
    }
}