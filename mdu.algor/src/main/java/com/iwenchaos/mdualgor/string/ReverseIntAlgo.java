package com.iwenchaos.mdualgor.string;

/**
 * Created by chaos
 * on 2018/12/24. 14:45
 * 文件描述：给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 */
public class ReverseIntAlgo {


    public static void main(String[] args) {
        System.out.println(reverse(456465119) + "");
    }


    public static int reverse(int x) {
        long result = 0L;
        while (x != 0) {
            result = result * 10 + (x % 10);
            x /= 10;
        }
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            result = 0;
        }
        return (int) result;
    }


}
