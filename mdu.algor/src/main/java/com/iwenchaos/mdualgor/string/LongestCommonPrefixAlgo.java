package com.iwenchaos.mdualgor.string;

/**
 * Created by chaos
 * on 2018/12/26. 10:29
 * 文件描述：编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefixAlgo {


    public static void main(String[] args) {
        String[] arr = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(arr));
    }

    private static String longestCommonPrefix(String[] sArr) {
        if (sArr == null || sArr.length == 0) {
            return "";
        }
        if(sArr.length == 1){
            return sArr[0];
        }
        String outer = sArr[0];
        StringBuilder comm = new StringBuilder("");
        for (int i = 0; i < outer.length(); i++) {//以第一个String作为目标对象，依次对每位的char进行比较
            char tmp = outer.charAt(i);
            boolean validChared = false;
            for (int k = 1; k < sArr.length; k++) {
                if (sArr[k].length() - 1 < i || sArr[k].charAt(i) != tmp) {
                    validChared = false;
                    break;
                } else {
                    validChared = true;
                }
            }
            if (validChared) {
                comm.append(tmp);
            } else {
                break;
            }
        }


        return comm.toString();
    }

}
