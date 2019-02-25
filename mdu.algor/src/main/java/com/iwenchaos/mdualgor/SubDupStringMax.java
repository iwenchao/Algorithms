package com.iwenchaos.mdualgor;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chaos
 * on 2018/9/18. 20:43
 * 文件描述： 字符串中的最长子串
 */
public class SubDupStringMax {

    public static void main(String[] args) {

        System.out.print(lengthOfLongestSubstring("adchcdaefg"));

    }

    /**
     * 滑动窗口算法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int len = s.length();
        int result = 0, i = 0, j = 0;
        Set<Character> characterSet = new HashSet<>();
        while (i < len && j < len) {
            if(!characterSet.contains(s.charAt(j))){
                characterSet.add(s.charAt(j++));//先取值，再对变量进行加运算
                result = Math.max(result,j-i);
            }else {
                characterSet.remove(s.charAt(i++));
            }
        }

        return result;

    }
}
