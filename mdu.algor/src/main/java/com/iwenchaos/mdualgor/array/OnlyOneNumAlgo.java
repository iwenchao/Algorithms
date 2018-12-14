package com.iwenchaos.mdualgor.array;

/**
 * Created by chaos
 * on 2018/12/14. 11:05
 * 文件描述：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现
 */
public class OnlyOneNumAlgo {


    public static void main(String[] args) {
        int[] nums = {17, 12, 5, -6, 12, 4, 17, -5, 2, -3, 2, 4, 5, 16, -3, -4, 15, 15, -4, -5, -6};
        System.out.println(singleNumber(nums)+"");
    }

    private static int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int pos = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[pos] == nums[i]) {//如果两个数相同，则统一放在数组前面；同时需要将pos+1位置上的与i交换
                pos++;
                int _tmp = nums[pos];//取出pos位置的数字
                nums[pos] = nums[i];
                nums[i] = _tmp;
                pos++;//继续走下一个
                i = pos;
            } else {//两个数字不同，
                if (i == nums.length - 1) {//i指针走到最后，则已经找出
                    return nums[pos];
                } else {//i指针没有走到最后，则继续往下找

                }
            }
        }
        return nums[pos];

    }
}
