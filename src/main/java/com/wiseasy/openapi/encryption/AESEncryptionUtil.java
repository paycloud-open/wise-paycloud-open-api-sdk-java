package com.wiseasy.openapi.encryption;

import com.wiseasy.openapi.utils.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class AESEncryptionUtil {

    // Generates a 256-bit AES key
    public static SecretKey generateAESKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // Initialize key generator for 256-bit AES key
        return keyGen.generateKey();
    }

    // Encodes the key into a Base64 string for storage or transmission
    public static String encodeKeyToBase64(SecretKey key) {
        return Base64.encode(key.getEncoded());
    }

    // Decodes the Base64 string back to a SecretKey
    public static SecretKey decodeKeyFromBase64(String base64Key) {
        byte[] decodedKey = Base64.decode(base64Key);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }

    // AES-256 encryption method (ECB mode)
    public static String encrypt(String plaintext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        return Base64.encode(encryptedBytes);
    }

    // AES-256 decryption method (ECB mode)
    public static String decrypt(String ciphertext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.decode(ciphertext));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    // Test the encryption and decryption process
    public static void main(String[] args) throws Exception {
        String plaintext = "This is a secret message";

        // Generate AES key
        SecretKey key = generateAESKey();

        // Convert the key to Base64 string for storage or transmission
        String base64Key = encodeKeyToBase64(key);
        System.out.println("Base64 Encoded AES Key: " + base64Key);

        // Encrypt the plaintext
        String encryptedText = encrypt(plaintext, key);
        System.out.println("Encrypted Text: " + encryptedText);

        // Decrypt the ciphertext
        SecretKey restoredKey = decodeKeyFromBase64(base64Key);
        String decryptedTextWithRestoredKey = decrypt(encryptedText, restoredKey);
        System.out.println("Decrypted Text: " + decryptedTextWithRestoredKey);
    }
}


