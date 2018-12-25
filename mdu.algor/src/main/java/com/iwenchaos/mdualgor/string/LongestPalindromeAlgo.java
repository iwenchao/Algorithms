package com.iwenchaos.mdualgor.string;

/**
 * Created by chaos
 * on 2018/12/25. 10:12
 * 文件描述：最长回文子串
 */
public class LongestPalindromeAlgo {


    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaba"));
    }


    /**
     * 采用中心扩展法
     *
     * @param s
     * @return
     */
    private static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        String tmp = null;
        for (int i = 0; i < s.length(); i++) {
            tmp = getCenterPalindrome(s, i, i);
            if(tmp.length() > longest.length()){
                longest = tmp;
            }
        }

        return longest;
    }

    private static String getCenterPalindrome(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1
                && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        String palindrome = s.substring(begin + 1, end);


        return palindrome;
    }


    /**
     * 判断是否回文
     *
     * @param s
     * @return
     */
    public static boolean isRalindrome(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
