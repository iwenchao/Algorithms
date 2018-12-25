package com.iwenchaos.mdualgor.string;

/**
 * Created by chaos
 * on 2018/12/24. 17:06
 * 文件描述：给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class PalindromeAlgo {


    public static void main(String[] args) {
        System.out.println("结果："+isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }

        char[] sChars = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();

        int len = sChars.length;
        int lenBy2 = len / 2;
        for (int i = 0; i < lenBy2; i++) {
            if (sChars[i] != sChars[len - i - 1]) {
                return false;
            }
        }

        return true;


    }


}
