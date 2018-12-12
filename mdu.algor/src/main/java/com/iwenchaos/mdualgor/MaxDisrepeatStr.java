package com.iwenchaos.mdualgor;

/**
 * Created by chaos
 * on 2018/9/17. 20:25
 * 文件描述：
 */
public class MaxDisrepeatStr {

    public static void main(String[] args) {
        System.out.print(maxDisrepeatStrLen("adbchbcef"));

    }

    public static int maxDisrepeatStrLen(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        String maxTarget = new String();
        String tmpStr = String.valueOf(s.charAt(0));
        for (int i = 1, len = s.length(); i < len - 1; i = i + 1) {
            String suf = String.valueOf(s.charAt(i));
            if (!tmpStr.contains(suf)) {
                tmpStr = tmpStr +  suf;
            } else {
                if(maxTarget.length() < tmpStr.length()){
                    maxTarget = tmpStr;
                }
                tmpStr = suf;
            }
        }
        System.out.println(maxTarget);
        return maxTarget.length();
    }
}
