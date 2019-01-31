package com.iwenchaos.mdualgor.dynmic;

/**
 * Created by chaos
 * on 2019/1/31. 17:08
 * 文件描述：最长公共子串问题
 *
 * 典型的动态规划问题
 * 1算法核心：记住求过的解来节省时间
 * 2.求解的方式：
 * 方式一：自顶向下的备忘录解法，递归以及优化递归算法
 * 方式二：自底向上。这也就是动态规划的核心，先计算子问题，再由子问题计算父问题。
 *3.动态规划原理
 *      1. 最优子结构：如果一个问题的解结构包含其子问题的最优解，就称此问题具有最优子结构性质（判断是否合适动态规划算法）
 *      2. 重叠子问题
 *4. 经典模型
 *      1. 线性模型
 *      2. 区间模型：最长公共子串
 *      3. 背包问题
 */
public class MaxCommonSubStrAlgo {


    public static void main(String[] args){
        String str1 = "1AB2345CD";
        String str2 = "123456EF";
        System.out.print(getMaxCommonStr(str1,genDynamicMatric(str1,str2)));
    }


    /**
     * 研究算法，先确定算法的类型。动态规划？递归（优化递归）？
     * 给出动态规划矩阵，确定dp[i][j]的含义
     * @param str1
     * @param str2
     * @return
     */
    public static int[][] genDynamicMatric(String str1,String str2){
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        int[][] dp = new int[char1.length][char2.length];
        //先计算首行首列
        for (int i = 0; i < char1.length; i++) {
            if(char1[i] == char2[0]){
                dp[i][0] = 1;
            }else {
                dp[i][0] = 0;
            }
        }
        for (int j = 0; j < char2.length; j++) {
            if(char2[j] == char1[0]){
                dp[0][j] = 1;
            }else {
                dp[0][j] = 0;
            }
        }

        for (int i = 1; i < char1.length ; i++) {
            for (int j = 1; j < char2.length; j++) {
                if(char1[i] != char2[j]){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
            }
        }

        return dp;
    }


    public static String getMaxCommonStr(String str1,int[][] dp){
        int maxValue = 0;
        int endIndex = 0;
        for (int i = 0; i < dp.length ; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(dp[i][j] > maxValue){
                    maxValue = dp[i][j];
                    endIndex = i;
                }
            }
        }
        return str1.substring(endIndex-maxValue+1,endIndex+1);
    }


}
