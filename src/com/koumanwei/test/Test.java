package com.koumanwei.test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by koumanwei on 2017/3/24.
 */
public class Test {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String nihaoshijie = getMD5("nihaoshijie");
        System.out.println(nihaoshijie);
        String messageDigest = getMessageDigest("nihaoshijie".getBytes());
        System.out.println(messageDigest);
    }

    public final static String getMessageDigest(byte[] buffer) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(buffer);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
    public static String getMD5(String str) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes());
        BigInteger bigInteger = new BigInteger(1, md.digest());
        String s = bigInteger.toString(16);
        // 如果不够32位补上"0"
        if (s.length() < 32) {
            int count = 32 - s.length();
            for (int i = 0; i < count; i++) {
                s = "0" + s;
            }
            return s;
        }
        return s;
    }
}
