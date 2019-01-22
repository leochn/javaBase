package com.vnext.w00utils.A01comm;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Random;
import java.util.UUID;

/**
 * @Auther: LEO
 * @Date: 2018/11/15 16:22
 * @Description:
 */
@Slf4j
public class SecUtil {

    /**
     * 自定义 KEY
     */
    private static byte[] keybytes = { 0x31, 0x32, 0x33, 0x34, 0x35, 0x50,
            0x37, 0x38, 0x39, 0x40, 0x41, 0x42, 0x43, 0x44, 0x45, 0x46 };


    public static String encrypt(String value) {
        String s = null;
        int mode = Cipher.ENCRYPT_MODE;
        try {
            Cipher cipher = initCipher(mode);
            byte[] outBytes = cipher.doFinal(value.getBytes());
            s = String.valueOf(Hex.encodeHex(outBytes));
        } catch (Exception e) {
        }
        return s;
    }


    public static String decrypt(String value) {
        String s = null;
        int mode = Cipher.DECRYPT_MODE;
        try {
            Cipher cipher = initCipher(mode);
            byte[] outBytes = cipher.doFinal(Hex.decodeHex(value.toCharArray()));
            s = new String(outBytes);
        } catch (Exception e) {

        }
        return s;
    }



    private static Cipher initCipher(int mode) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        Key key = new SecretKeySpec(keybytes, "AES");
        cipher.init(mode, key);
        return cipher;
    }

    public static String getUUId() {
        int first = new Random(10).nextInt(8) + 1;
        System.out.println(first);
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return first + String.format("%015d", hashCodeV);
    }


//    public static void main(String[] args) {
//        String encrypt = encrypt("string");
//        System.out.println(encrypt);
//
//        String decrypt = decrypt("35471e73db9f77a40d611b76884f6e213e083f943071763bd610f31e50e8890304");
//        System.out.println(decrypt);
//
//        System.out.println(getUUId());
//    }

}
