package com.iwenchaos.mdualgor.string;

/**
 * Created by chaos
 * on 2018/12/25. 14:17
 * 文件描述：实现 atoi，将字符串转为整数。
 * 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 * 若函数不能执行有效的转换，返回 0。
 * <p>
 * 说明：
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1]。如果数值超过可表示的范围，则返回 INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
 */
public class AtoiAlgo {


    public static void main(String[] args) {

    }


    private static int atoi(String s) {
        if (s == null ) {
            return 0;
        }

        //去掉空格符
        s = s.trim();
        if(s.isEmpty()){
            return 0;
        }
        //
        int index = 0, sign = 1, value = 0, len = s.length();
        //符号位
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            sign = 1 - 2 * (s.charAt(0) == '-' ? 1 : 0);
            index++;
        }

        while (index < len
                && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            if (value > Integer.MAX_VALUE / 10
                    || (value == Integer.MAX_VALUE / 10 && s.charAt(index) - '0' > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            value = value * 10 + s.charAt(index++) - '0';
        }

        return value * sign;


    }

}
