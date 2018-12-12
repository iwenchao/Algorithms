package com.iwenchaos.mdualgor.array;

/**
 * Created by chaos
 * on 2018/12/12. 10:35
 * 文件描述：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 */
public class RotateArrAlgo {

    public static void main(String[] args) {
        int[] nums = {5, 4, 7, 4, 4, 3, -2};
        print(nums);
        nums = rotate2(nums, 1);
        print(nums);
//        System.out.println(7 % 7);
    }

    /**
     * 解法1： 递归
     * 空间复杂度 不为 O(1)
     * 递归算法空间复杂度：递归深度k*每次递归所要的辅助空间，如果每次递归所需要的辅助空间为常数，则递归空间复杂度o（k）
     */
    public static int[] rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        print(nums);
        if (k <= 0) {
            return nums;
        } else {
            k = k - 1;
            int i = 0;
            int tmp = nums[i];
            for (; i < nums.length - 1; i++) {
                int _tmp = nums[i + 1];
                nums[i + 1] = tmp;
                tmp = _tmp;
            }
            nums[0] = tmp;
            return rotate(nums, k);
        }

    }

    /**
     * 解法2 采用 取模方式
     */
    public static int[] rotate2(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int len = nums.length;
        int mod = k % len;
        int tmp = nums[0];
        for (int i = 0, count = 0; count < len; count++) {
            int _tmp = nums[(i + mod) % len];
            nums[(i + mod) % len] = tmp;
            tmp = _tmp;
            i = i + mod;
        }
        return nums;
    }

    private static void print(int[] nums) {
        System.out.println();
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
