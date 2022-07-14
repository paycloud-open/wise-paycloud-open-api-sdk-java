
package com.wiseasy.openapi.sign;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: RSA tools
 */
public class RSA {

    // RSA
    private static final String RSA = "RSA";

    // Encryption Algorithm, Private key length 2048
    private static final String SIGN_ALGORITHMS = "SHA256WithRSA";

    /**
     * RSA signature
     *
     * @param content    Data to be signed
     * @param privateKey Private key
     * @param charset    charset
     * @return Signature string
     */
    public static String sign(String content, String privateKey, String charset) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
            KeyFactory keyf = KeyFactory.getInstance(RSA);
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);

            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);

            signature.initSign(priKey);
            signature.update(content.getBytes(charset));

            byte[] signed = signature.sign();

            return Base64.encode(signed);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Sign verification
     *
     * @param content   Data to be signed
     * @param sign      Signature string
     * @param publicKey Public key
     * @param charset
     * @return
     */
    public static boolean verify(String content, String sign, String publicKey, String charset) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(RSA);
            byte[] encodedKey = Base64.decode(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

            java.security.Signature signature = java.security.Signature
                    .getInstance(SIGN_ALGORITHMS);

            signature.initVerify(pubKey);
            signature.update(content.getBytes(charset));
            return signature.verify(Base64.decode(sign));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
