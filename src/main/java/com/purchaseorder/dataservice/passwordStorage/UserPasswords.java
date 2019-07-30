package com.purchaseorder.dataservice.passwordStorage;

import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class UserPasswords {

    public UserPasswords() {
        this.populate();
    }

    private Map<String, String> passwordDictionary = new HashMap<>();

    private void populate () {
        passwordDictionary.put("n1111111", "karen");
        passwordDictionary.put("n2222222", "david");
        passwordDictionary.put("n3333333", "joe");
    }

    public boolean isValid (String nnumber, String password) {
        if (passwordDictionary.containsKey(nnumber)) {
            return passwordDictionary.get(nnumber).equals(password);
        }
        return false;
    }
}
