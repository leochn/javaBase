package com.vnext.w00utils.A01comm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Auther: LEO
 * @Date: 2018/11/15 14:27
 * @Description:
 */
public class Str2MD5Util {

    private final static String KEY_SALT = "WpgCzWaterSALT18";


    public static String MD5(String sourceStr) {
        String srcString = sourceStr + KEY_SALT;
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(srcString.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            // MD5,32位
            result = buf.toString();
            //System.out.println("MD5(" + sourceStr + ",32) = " + result);

            // MD5, 16位
            //String substring = buf.toString().substring(8, 24);
            //System.out.println("MD5(" + sourceStr + ",16) = " + buf.toString().substring(8, 24));

        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }


//    public static void main(String[] args) {
//        String s = MD5("1234");
//        System.out.println(s);
//    }
}
