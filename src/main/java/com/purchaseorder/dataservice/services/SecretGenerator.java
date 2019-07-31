package com.purchaseorder.dataservice.services;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class SecretGenerator {

    public static void main(String[] args) {
        // for testing purposes
        generateSecret();
    }

    public static SecretKey generateSecret() {
        KeyGenerator keyGen;
        SecureRandom random = new SecureRandom();
        try {
            keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256, random);
            return keyGen.generateKey();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String printKey(SecretKey key) {
        byte encoded[] = key.getEncoded();
        return Base64.getEncoder().encodeToString(encoded);
    }
}


