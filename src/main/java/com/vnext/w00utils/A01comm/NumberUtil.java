package com.vnext.w00utils.A01comm;

import java.math.BigDecimal;

/**
 * @Auther: LEO
 * @Date: 2018/11/24 14:34
 * @Description:
 */
public final class NumberUtil {

    public static BigDecimal resetValue(Double oldValue, Float serviceRatio) {
        Double f = (oldValue * serviceRatio);
        BigDecimal b = new BigDecimal(f);
        return b.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public static String double2String(Double oldValue) {
        BigDecimal b = new BigDecimal(oldValue);
        return b.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    public static String formatDouble(double d) {
        BigDecimal bg = new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP);
        double num = bg.doubleValue();
        if (Math.round(num) - num == 0) {
            return String.valueOf((long) num);
        }
        return String.valueOf(num);
    }


    public static String trimStr(String oldStr){
//        int oldLength = oldStr.length();
//        int trimLength = oldStr.indexOf(".");
//
//        if (trimLength != -1 && oldLength > trimLength + 3){
//            return oldStr.substring(0,oldStr.indexOf(".")+3);
//        }else {
//            return oldStr;
//        }

        return formatDouble(Double.valueOf(oldStr));


    }

}
