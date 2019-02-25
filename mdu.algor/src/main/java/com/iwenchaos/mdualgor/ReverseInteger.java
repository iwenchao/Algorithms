package com.iwenchaos.mdualgor;

/**
 * Created by chaos
 * on 2018/9/19. 19:43
 * 文件描述： 本道算法题的关键在于，
 * 1. 通过数学 % 、/ 取余和取模的运算 ，进行 pop和push的操作
 * 2. 找到运算过程中整数溢出的条件
 * pop 123
 * pop = x % 10//取余
 * x = x/10;//循环处理
 * <p>
 * push 321
 * temp = rev * 10 + pop  //这一行就是找出运算过程中可能出现的溢出条件 >MAX_VALUE  或者 <MIN_VALUE
 * rev = temp
 */
public class ReverseInteger {

    public static void main(String[] args) {
        //    public static final int MIN_VALUE = -2147483648;
        //    public static final int MAX_VALUE = 2147483647;
        System.out.println(reverse(2147483));
    }

    //12345678
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) {//溢出
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            result = result * 10 + pop;
        }
        return result;
    }


    //12345678

    /**
     * 错误的解法
     * @param x
     * @return
     */
    public static int reverseWrong(int x) {
        boolean symbol = x < 0;// true 表示 负数


        String absXStr = String.valueOf(Math.abs(x));
        char[] chars = absXStr.toCharArray();
        for (int i = 0, len = chars.length; i < len / 2; i++) {
            char p = chars[i];
            char q = chars[len - 1 - i];

            chars[i] = q;
            chars[len - 1 - i] = p;
        }
        long reverXL = Long.valueOf(String.valueOf(chars));
        if (!(reverXL <= Integer.MAX_VALUE && reverXL >= Integer.MIN_VALUE)) {
            return 0;
        }
        if (symbol) {
            return -Integer.valueOf(String.valueOf(chars));
        }

        return Integer.valueOf(String.valueOf(chars));
    }
}
