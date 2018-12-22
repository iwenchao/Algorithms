package com.iwenchaos.mdualgor.array;

/**
 * Created by chaos
 * on 2018/12/22. 11:25
 * 文件描述：
 */
public class PlusNumAlgo {


    public static void main(String[] args) {

    }

    /**
     * 这种做法有数字溢出问题，放弃
     *
     * @param digits
     * @return
     */
    @Deprecated
    private static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        int origin = 0;
        for (int i = 0; i < digits.length; i++) {
            origin = origin + digits[i] * (int) Math.pow(10, digits.length - 1 - i);
        }
        origin += 1;
        String originStr = String.valueOf(origin);
        int[] result = new int[originStr.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = originStr.charAt(i) - '0';
        }

        return result;
    }

    private static int[] plusOne2(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        boolean decimaled = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            int value = digits[i] + (decimaled ? 1 : 0);
            if (value == 10) {
                digits[i] = 0;
                decimaled = true;
            } else {//是否继续前进
                digits[i] = value;
                decimaled = false;

                break;
            }
        }

        if (decimaled) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        } else {
            return digits;
        }
    }

    /**
     * 这个方法可以做到 对数组加法任一数字
     *
     * @param digits
     * @return
     */
    private static int[] plusNum(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        boolean decimaled = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            int value = digits[i] + (decimaled ? 1 : 0);
            digits[i] = value % 10;
            decimaled = value == 10;
            if (!decimaled) {
                break;
            }
        }

        if (decimaled) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        } else {
            return digits;
        }
    }

}
