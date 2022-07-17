package com.liu.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DecimalUtils {

    private DecimalUtils() {}

    public final static BigDecimal THOUSAND = new BigDecimal("1000");


    public static boolean gt(Number d1,Number d2) {
        if (d1 == null || d2 == null){
            return false;
        }
        return BigDecimal.valueOf(d1.doubleValue()).compareTo(BigDecimal.valueOf(d2.doubleValue())) > 0;
    }

    public static boolean ge(Number d1,Number d2) {
        if (d1 == null || d2 == null){
            return false;
        }
        return BigDecimal.valueOf(d1.doubleValue()).compareTo(BigDecimal.valueOf(d2.doubleValue())) >= 0;
    }

    public static boolean lt(Number d1,Number d2) {
        if (d1 == null || d2 == null){
            return false;
        }
        return BigDecimal.valueOf(d1.doubleValue()).compareTo(BigDecimal.valueOf(d2.doubleValue())) < 0;
    }

    public static boolean le(Number d1,Number d2) {
        if (d1 == null || d2 == null){
            return false;
        }
        return BigDecimal.valueOf(d1.doubleValue()).compareTo(BigDecimal.valueOf(d2.doubleValue())) <= 0;
    }

    public static BigDecimal divExceptionDefaultZero(Number d1,Number d2) {
        if (d1 == null || d2 == null){
            return BigDecimal.ZERO;
        }
        if (d2.equals(0)){
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(d1.doubleValue()).divide(BigDecimal.valueOf(d2.doubleValue()),4, RoundingMode.HALF_DOWN);
    }

    public static BigDecimal div(Number d1,Number d2,int scale) {
        if (d1 == null || d2 == null){
            return BigDecimal.ZERO;
        }
        if (d2.equals(0)){
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(d1.doubleValue()).divide(BigDecimal.valueOf(d2.doubleValue()),scale, RoundingMode.HALF_DOWN);
    }

    public static BigDecimal divExceptionDefaultZero(BigDecimal d1,BigDecimal d2) {
        if (d1 == null || d2 == null || d2.compareTo(BigDecimal.ZERO) == 0){
            return BigDecimal.ZERO;
        }
        return d1.divide(d2,4, RoundingMode.HALF_DOWN);
    }

    public static BigDecimal multiplyRemoveDecimal(BigDecimal d1,BigDecimal d2) {
        if (d1 == null || d2 == null || d2.compareTo(BigDecimal.ZERO) == 0){
            return BigDecimal.ZERO;
        }
        return d1.multiply(d2).setScale(0,RoundingMode.FLOOR);
    }

    public static BigDecimal multiply(BigDecimal d1,BigDecimal d2,int scale) {
        if (d1 == null || d2 == null || d2.compareTo(BigDecimal.ZERO) == 0){
            return BigDecimal.ZERO;
        }
        return d1.multiply(d2).setScale(scale,RoundingMode.HALF_UP);
    }

}
