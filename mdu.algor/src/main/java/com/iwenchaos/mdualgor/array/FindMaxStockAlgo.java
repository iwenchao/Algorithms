package com.iwenchaos.mdualgor.array;

/**
 * Created by chaos
 * on 2018/12/10. 14:10
 * 文件描述：
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * [7,1,5,3,6,4]
 */
public class FindMaxStockAlgo {


    public static void main(String[] args) {

    }

    private static int findMaxStock(int[] array) {
        int maxProfit = 0;
        if (array == null || array.length <= 1) {
            return maxProfit;
        }
        for (int i = 1; i < array.length; i++) {
            int profit = array[i] - array[i - 1];
            if(profit <= 0){
                continue;
            }
            maxProfit = maxProfit + profit;
        }

        return maxProfit;
    }

    public static void findBestTime(int[] array){

    }

}
