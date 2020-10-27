package com.razvan.papurica.proiect3.security;

import com.razvan.papurica.proiect3.entity.User;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityAuthorizer {

    private static User user = null;

    public static boolean isUserAuthenticated() {
        if(user == null)
            return false;

        return true;
    }

    // SHA-512 encryption method

    public static String encrypt(String password) {
        String hashPwd = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigset = md.digest(password.getBytes());
            BigInteger number = new BigInteger(1, messageDigset);

            hashPwd = number.toString(16);

            while(hashPwd.length() < 32) {
                hashPwd = "0" + hashPwd;
            }
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hashPwd;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        SecurityAuthorizer.user = user;
    }

    public static void unsetUser() {
        SecurityAuthorizer.user = null;
    }
}
