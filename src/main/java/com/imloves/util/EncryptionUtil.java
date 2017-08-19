package com.imloves.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by wujianchuan
 * 2017/8/19 14:13
 */
public class EncryptionUtil {

    public static final String MD5 = "MD5";

    public static String enctyption(String source, String hashType) {

        try {
            MessageDigest messageDigest = MessageDigest.getInstance(hashType);
            messageDigest.update(source.getBytes("UTF-8"));
            BigInteger bigInt = new BigInteger(1, messageDigest.digest());
            return bigInt.toString(16);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
