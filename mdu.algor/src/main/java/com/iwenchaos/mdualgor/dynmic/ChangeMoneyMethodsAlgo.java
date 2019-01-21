package com.iwenchaos.mdualgor.dynmic;

/**
 * Created by chaos
 * on 2019/1/21. 21:18
 * 文件描述： 换钱的方法数
 * 给定一组面值不同的纸币，不重复，可以使用任意张，在给定一个aim目标值，求组成目标值的纸币可能张数。
 * <p>
 * 涉及：暴利递归-->记忆搜索-->动态规划
 */
public class ChangeMoneyMethodsAlgo {

    public static void main(String[] args) {
        int[] arr = {5, 10, 25, 1};
        System.out.println(System.currentTimeMillis());
        int result = coins(arr, 1000);
        System.out.println(result);
        System.out.println(System.currentTimeMillis());
    }

    public static int coins(int[] arr, int aim) {
        //常规合法性校验
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }


        return fabProcess(arr, 0, aim);

//        int[][] note = new int[arr.length + 1][aim + 1];
//        int result = noteProcess(arr, 0, aim);

    }

    /**
     * 暴利递归算法之所以暴力，是因为存在大量重复的计算
     * 比如 0张5元，1张10元，【25，1】组成的剩下990的方法总数
     * 和  2张5元，0张10元，25，1】组成的剩下990的方法总数 这部分计算重复
     * <p>
     * O(aim^N)
     */
    public static int fabProcess(int[] arr, int index, int aim) {
        int result = 0;
        if (index == arr.length) {
            result = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                result += fabProcess(arr, index + 1, aim - arr[index] * i);
            }
        }
        return result;
    }

    /**
     * 方法改进1：通过记录中间已经计算好的方案，下次递归过程中优先查找是否已有算好的相应方案
     */
    private static int noteProcess(int[] arr, int index, int aim, int[][] note) {
        int result = 0;
        if (index == arr.length) {
            result = aim == 0 ? 1 : 0;
        } else {
            int noteValue = 0;
            for (int i = 0; arr[index] * i <= aim; i++) {
                noteValue = note[index + 1][aim - arr[index] * i];
                if (noteValue != 0) {
                    result += noteValue == -1 ? 0 : noteValue;
                } else {
                    result += noteProcess(arr, index + 1, aim - arr[index] * i, note);
                }
            }
        }
        note[index][aim] = result == 0 ? -1 : result;
        return result;
    }

}
