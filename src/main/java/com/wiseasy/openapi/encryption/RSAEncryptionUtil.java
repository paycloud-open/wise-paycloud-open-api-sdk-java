package com.wiseasy.openapi.encryption;

import com.wiseasy.openapi.utils.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA Encryption Handler
 *
 * Provides methods for encrypting and decrypting data using RSA with OAEP padding.
 *
 * @version 1.1
 * @since 1.0
 */
public abstract class RSAEncryptionUtil {
    /** RSA algorithm */
    public static final String KEY_ALGORITHM = "RSA";

    /** Transformation string for RSA with OAEP padding */
    public static final String TRANSFORMATION = "RSA/ECB/OAEPPadding";

    /** Maximum plaintext size for RSA encryption (adjusted for OAEP padding) */
    private static final int MAX_ENCRYPT_BLOCK = 214;

    /** Maximum ciphertext size for RSA decryption */
    private static final int MAX_DECRYPT_BLOCK = 256;

    /**
     * Encrypts data using the provided public key.
     *
     * @param data the data to be encrypted
     * @param key the public key in Base64 encoded format
     * @return the Base64 encoded encrypted data
     * @throws Exception if any error occurs during encryption
     */
    public static String encryptByPublicKey(byte[] data, String key) throws Exception {
        // Decode and create public key from Base64 encoded string
        byte[] keyBytes = Base64.decode(key);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);

        // Initialize cipher for encryption and process data in chunks
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = processInChunks(data, cipher, MAX_ENCRYPT_BLOCK);

        // Encode encrypted data in Base64
        return Base64.encode(encryptedBytes);
    }

    /**
     * Decrypts data using the provided private key.
     *
     * @param data the encrypted data
     * @param key the private key in Base64 encoded format
     * @return the decrypted data as a string
     * @throws Exception if any error occurs during decryption
     */
    public static String decryptByPrivateKey(byte[] data, String key) throws Exception {
        // Decode and create private key from Base64 encoded string
        byte[] keyBytes = Base64.decode(key);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // Initialize cipher for decryption and process data in chunks
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = processInChunks(data, cipher, MAX_DECRYPT_BLOCK);

        // Convert decrypted bytes to string
        return new String(decryptedBytes);
    }

    /**
     * Processes data in chunks for encryption or decryption.
     *
     * @param data the input data
     * @param cipher the cipher initialized for encryption or decryption
     * @param maxBlockSize the maximum block size for processing
     * @return the processed data
     * @throws IOException if an I/O error occurs
     * @throws IllegalBlockSizeException if the input data block size is invalid
     * @throws BadPaddingException if padding is incorrect
     */
    private static byte[] processInChunks(byte[] data, Cipher cipher, int maxBlockSize)
            throws IOException, IllegalBlockSizeException, BadPaddingException {
        int inputLen = data.length;
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            int offSet = 0;
            while (inputLen - offSet > 0) {
                int chunkSize = Math.min(inputLen - offSet, maxBlockSize);
                byte[] chunk = cipher.doFinal(data, offSet, chunkSize);
                out.write(chunk);
                offSet += chunkSize;
            }
            return out.toByteArray();
        }
    }
}
