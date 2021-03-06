package com.meicai.ppblossom.theone.commons.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    public static String getMD5(String content) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.update(content.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                String str = Integer.toHexString(b & 0xFF);
                if (str.length() == 1) {
                    sb.append("0");
                }
                sb.append(str);
            }
            result = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("failed getMD5", e);
        }
        return result;
    }

}
