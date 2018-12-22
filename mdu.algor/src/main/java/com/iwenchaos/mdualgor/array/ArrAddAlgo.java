package com.iwenchaos.mdualgor.array;

import java.util.HashMap;

/**
 * Created by chaos
 * on 2018/12/22. 15:26
 * 文件描述：
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class ArrAddAlgo {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};

    }

    /**
     * 算法时间复杂度为O(n^2) 可以通过增加空间，降低时间
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        //1. 基础校验代码

        //2.具体算法
        for (int i = 0; i < nums.length-1; i++) {
            int val = nums[i];
            for (int k = i+1; k < nums.length; k++) {
                if((nums[i] + nums[k] ) ==  target){
                    return new int[]{i,k};
                }
            }
        }
        return null;

    }

    /**
     * 增加空间，降低时间
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (m.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = m.get(target - nums[i]);
                break;
            }
            m.put(nums[i], i);
        }
        return res;
    }

    private static void print(int[] nums) {
        System.out.println();
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
