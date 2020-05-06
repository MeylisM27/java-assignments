package edu.pte.mik.model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

// Passwords have to be treated in a special way.
// For security reasons, plain text passwords are not stored
// In web based (apache php) systems usually MD5 hash is used instead.
// MD5 generates 32 character long hash
// for passwords shorter than 32 characters there is no hash collision
//
// 1 static method creates byte array representing password hash bytes
// 3 static methods are presented to convert byte array to HEX string
//
// Because password generation is implemented in this class,
// password matching is also implemented in this class
//
// For testing HexString generation, a UnitTest is generated: PasswordTest
//      On class name, right click, Generate..., Tests..., Select the methods to test
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
            // byte is a primitive data type -128..127
            // has to be converted to unsigned value
            // ref: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
            int b = data[i] & 0xff;
            builder.append(DIGITS.charAt(b >> 4));
            builder.append(DIGITS.charAt(b & 0xf));
        }
        return builder.toString();
    }

    protected static String toHex2(final byte[] data)
    {
        Formatter formatter = new Formatter();
        for (byte b : data)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    protected static String toHex3(byte[] data) {
        return String.format("%032x", new BigInteger(1, data));
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
