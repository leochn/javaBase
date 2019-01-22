package com.vnext.w00utils.A01comm;

import static org.apache.commons.codec.digest.DigestUtils.sha256Hex;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * @Auther: LEO
 * @Date: 2018/11/15 11:14
 * @Description:
 */
public final class PasswordUtil {

    private PasswordUtil() {
        throw new IllegalStateException();
    }

    /**
     * 使用SHA-256进行密码加密
     * @param plainPassword 密码原文
     */
    public static String encrypt(String plainPassword) {
        return sha256Hex(plainPassword);
    }

    public static boolean validatePassword(String plainPassword, String cipherPassword) {
        return isNotBlank(plainPassword) && encrypt(plainPassword).equals(cipherPassword);
    }

}
