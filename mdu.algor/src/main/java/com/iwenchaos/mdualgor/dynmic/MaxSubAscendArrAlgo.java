package com.iwenchaos.mdualgor.dynmic;

/**
 * Created by chaos
 * on 2019/1/25. 20:34
 * 文件描述：最长递增子序列
 * <p>
 * 给定数组arr，返回arr的最长递增子序列
 * 如[2,1,5,3,6,4,8,9,7]  返回[1,3,4,8,9]
 */
public class MaxSubAscendArrAlgo {


    public static void main(String args[]) {

    }


    /**
     * 先获取截止到i位置的中最长递增子序列的长度，即dp[i]
     *
     * @param arr
     * @return
     */
    public static int[] getdp(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;//赋初值，递增子序列最短为1
            for (int k = 0; k < i; k++) {
                if (arr[i] > arr[k]) {
                    dp[i] = Math.max(dp[i], dp[k] + 1);
                }
            }
        }

        return dp;
    }


    /**
     * 根据dp[],找到最大值value以及其下标index，
     * 该值就是所要寻找的最大递增子序列长度，
     * 其下标就是需要从该arr[index]往左依次遍历，使得dp[i]==dp[index]-1 ;index=i,依次遍历到最后截止
     *
     * @param arr
     * @param dp
     * @return
     */
    public static int[] generateLIS(int[] arr, int[] dp) {
        //1.找到最大值value以及其下标index，
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                maxIndex = i;
                max = dp[i];
            }
        }

        int[] result = new int[max];
        result[--max] = arr[maxIndex];
        for (int i = maxIndex; i >= 0; i--) {
            if (arr[i] < arr[maxIndex] && dp[i] == dp[maxIndex] - 1) {
                result[--max] = arr[i];
                maxIndex = i;
            }
        }
        return result;
    }


}
