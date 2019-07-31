package com.purchaseorder.dataservice.services;

import com.purchaseorder.dataservice.model.User;
import static com.purchaseorder.dataservice.services.SecretGenerator.printKey;

import javax.crypto.SecretKey;
import java.util.HashMap;
import java.util.Map;

public class LoggedUsers {
    public LoggedUsers() {
    }

    private Map<String, User> loggedUsersDictionary = new HashMap<>();

    public void addUser(String nNumber, User user) {
        loggedUsersDictionary.put(nNumber, user);
    }

    public Enum getUserType(String nNumber) {
        if (loggedUsersDictionary.containsKey(nNumber)) {
            return loggedUsersDictionary.get(nNumber).getUserType();
        }
        return null;
    }

    public SecretKey getSecret(String nNumber) {
        if (loggedUsersDictionary.containsKey(nNumber)) {
            return loggedUsersDictionary.get(nNumber).getSecret();
        }
        return null;
    }

    public void printDictionary() {
        System.out.println(loggedUsersDictionary.size());
        for (Map.Entry<String, User> entry : loggedUsersDictionary.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + printKey(entry.getValue().getSecret()));
    }
}