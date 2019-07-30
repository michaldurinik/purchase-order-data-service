package com.purchaseorder.dataservice.services;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SecretGenerator {

        SecretKey generateKey() {
            KeyGenerator keyGen = null;
            try {
                keyGen = KeyGenerator.getInstance("AES");
                keyGen.init(256);
            }
            catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            SecretKey secretkey = keyGen.generateKey();
            return secretkey;
        }

        public String printKey(SecretKey key) {
            byte encoded[] = key.getEncoded();
            return Base64.getEncoder().encodeToString(encoded);
        }
}
