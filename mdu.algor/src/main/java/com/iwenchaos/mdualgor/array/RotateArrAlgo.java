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
        int[] nums = {1, 2, 3, 4, 5, 6, 9};
//        nums = rotate(nums, 3);

        rotate3(nums, 4);


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
     * 没有在原来的数组操作
     */
    public static void rotate2(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int len = nums.length;
        k = k % len;
        int tmp = nums[0];
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            int j = (i + k) % len;
            result[j] = nums[i];
        }
        print(nums);
        print(result);
    }

    /**
     * 解法2 采用 取模方式
     * 在原来的数组操作
     */
    private static void rotate3(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        }
        print(nums);
        int len = nums.length;
        k = k % len;
        int offset = 0;
        int count = 0;
        int i = 0;
        int tmp = nums[i];

        while (count++ < nums.length) {
            i = (i + k) % len;
            int _tmp = nums[i];
            nums[i] = tmp;

            if (i == offset) {
                ++offset;
                ++i;
                tmp = nums[i];
            } else {
                tmp = _tmp;
            }

        }
        print(nums);

    }

    private static void print(int[] nums) {
        System.out.println();
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
