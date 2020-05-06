package com.company.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password {

    public static Password createFromPassword(String passwordString) {
        Password newPwd = new Password();
        newPwd.setPassword(passwordString);
        return newPwd;
    }

    public static Password createFromHash(String hash) {
        Password newPwd = new Password();
        newPwd.setHash(hash);
        return newPwd;
    }

    private String hash;

    public String getHash() {
        return hash;
    }

    private void setHash(String hash) {
        this.hash = hash;
    }

    private void setPassword(String password) {
        this.hash = toHex1(getHash(password));
    }

    private Password() { }

    protected static byte[] getHash(String password) {
        try {
            MessageDigest encoder = MessageDigest.getInstance("MD5");
            encoder.update(password.getBytes());
            return encoder.digest();
        }
        catch(NoSuchAlgorithmException ex) {
            return null;
        }
    }

    
    private static final String DIGITS = "0123456789abcdef";
    protected static String toHex1(byte[] data){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i != data.length; i++)
        {
            int b = data[i] & 0xff;
            builder.append(DIGITS.charAt(b >> 4));
            builder.append(DIGITS.charAt(b & 0xf));
        }
        return builder.toString();
    }

    public boolean equalsTo(Password otherPassword) {
        return hash.equalsIgnoreCase(otherPassword.getHash());
    }

    @Override
    public String toString() {
        return "Password{" +
                "hash='" + hash + '\'' +
                '}';
    }
}