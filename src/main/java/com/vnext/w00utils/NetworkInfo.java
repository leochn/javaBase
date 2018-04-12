package com.vnext.w00utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author leo
 * @since 2018/4/4 13:14
 */
public class NetworkInfo {

    private final static char[] HEX = "0123456789ABCDEF".toCharArray();

    public static void main(String[] args) throws SocketException {
        for(Enumeration<NetworkInterface> i = NetworkInterface.getNetworkInterfaces(); i.hasMoreElements(); ) {
            NetworkInterface ni = i.nextElement();
            System.out.println("NETWORK CARD NAME: " + ni.getDisplayName());
            System.out.println("MAC: " + toMacString(ni.getHardwareAddress()));
            for(Enumeration<InetAddress> j = ni.getInetAddresses(); j.hasMoreElements(); ) {
                System.out.println("   " + j.nextElement());
            }
        }
    }

    private static String toMacString(byte[] bys) {
        if(bys == null) {
            return null;
        }
        char[] chs = new char[bys.length * 3 - 1];
        for(int i = 0, k = 0; i < bys.length; i++) {
            if(i > 0) {
                chs[k++] = '-';
            }
            chs[k++] = HEX[(bys[i] >> 4) & 0xf];
            chs[k++] = HEX[bys[i] & 0xf];
        }
        return new String(chs);
    }
}
