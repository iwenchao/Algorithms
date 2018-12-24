package com.iwenchaos.mdualgor.string;

/**
 * Created by chaos
 * on 2018/12/24. 14:18
 * 文件描述：
 */
public class ReverseStrAlgo {

    public static void main(String[] args) {
        System.out.println(reverseString("hel  lo"));

    }

    public static String reverseString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 此方法会不断产生新的变量以及string对象，弃用
     * @param s
     * @return
     */
//    public static String reverseString2(String s) {
//        if (s == null || s.length() <= 1) {
//            return s;
//        }
//        int len = s.length();
//        int lenBy2 = len / 2;
//        char tmp0,tmp1;
//        for (int i = 0; i < lenBy2; i++) {
//            tmp0 = s.charAt(i);
//            tmp1 = s.charAt(len-i-1);
//            s.replace(tmp0,tmp1);
//
//        }
//    }


}
