package com.si.mensagem.cadastrousuario.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SenhaHashService {

    private static final String HASH_ALGORITHM = "SHA-256";
    // 32 bytes (256 bits)
    private static final int SALT_LENGTH = 32;

    //vai gerar um salt para a senha
    public static byte[] gerarSalt() {
        byte[] salt = new byte[SALT_LENGTH];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(salt);
        return salt;
    }

    //gera o hash da senha com auxilio do salt
    public static byte[] hashSenha(String senha, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
        digest.reset();
        digest.update(salt);
        return digest.digest(senha.getBytes());
    }

    /**
     * compara senha com o hash
     *
     * @Param SENHA - senha do usuário
     * @Param SALT - o salt usado para gerar a senha
     * @Param HASHBANCO -  o hash da senha armazenado no banco
     */
    public static boolean verificarSenha(String senha, byte[] salt, byte[] hashBanco) throws NoSuchAlgorithmException {
        byte[] newHash = hashSenha(senha, salt);
        return MessageDigest.isEqual(newHash, hashBanco);
    }

}
