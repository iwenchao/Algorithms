package com.iwenchaos.mdualgor.string;

/**
 * Created by chaos
 * on 2018/12/24. 16:51
 * 文件描述： 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class AnagramAlgo {

    public static void main(String[] args){

    }


    /**
     * 采用字母表哈希算法
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        //异常校验

        int[] alph = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alph[s.charAt(i)-'a']++;
        }
        int[] alph2 = new int[26];
        for (int i = 0; i < t.length(); i++) {
            alph2[t.charAt(i)-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if(alph[i] != alph2[i]){
                return false;
            }
        }
        return true;
    }
}
