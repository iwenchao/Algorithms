package com.iwenchaos.mdualgor.string;

/**
 * Created by chaos
 * on 2018/12/24. 15:15
 * 文件描述：给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class UniqCharAlgo {


    public static void main(String[] args) {
        findUniqChar2("loveleetcode");
    }

    /**
     * 该方法属于常规算法，在长文本场景中耗时严重
     *
     * @param s
     * @return
     */
    public static int findUniqChar(String s) {
        if (s == null || s.length() < 1) {
            return -1;
        }
        String tmp = null;
        for (int i = 0; i < s.length(); i++) {
            tmp = s.replace(s.charAt(i) + "", "");
            if ((s.length() - tmp.length()) == 1) {
                return i;
            } else {

            }
        }

        return -1;
    }

    /**
     * 注意事项里只有小写字母，从此思考
     *
     * @param s
     * @return
     */
    public static int findUniqChar2(String s) {
        if (s == null || s.length() < 1) {
            return -1;
        }
        int[] alph = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alph[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (alph[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }


        return -1;
    }
}
