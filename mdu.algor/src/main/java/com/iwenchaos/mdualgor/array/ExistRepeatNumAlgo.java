package com.iwenchaos.mdualgor.array;

/**
 * Created by chaos
 * on 2018/12/12. 18:14
 * 文件描述：
 */
public class ExistRepeatNumAlgo {


    public static void main(String[] args) {

    }

    public static boolean exist(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int k = i+1; k < nums.length; k++) {
                if(nums[i] == nums[k]){
                    return true;
                }
            }
        }
        return true;
    }
}
