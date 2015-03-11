package com.miki.email.domain.model.account.specifications;


import org.apache.commons.codec.binary.Base64;

/**
 * Created by miki on 10.03.2015.
 */
public class PasswordSecurity {


    public String encrypt(String plainText) {
        byte[] byteArray = Base64.encodeBase64(plainText.getBytes());
        return new String(byteArray);
    }

    public String decrypt(String encryptedText) {
        byte[] byteArray = Base64.decodeBase64(encryptedText.getBytes());
        return new String(byteArray);
    }


}
