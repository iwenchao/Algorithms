package com.iwenchaos.mdualgor.array;

/**
 * Created by chaos
 * on 2018/12/22. 14:25
 * 文件描述：
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数
 */
public class MoveZeroAlgo {


    public static void main(String[] args) {
        int[] nums = {17, 12, 5, 0, 12, 0, 0, -5, 2, -3, 2, 4, 5, 16, -3, -4, 15, 15, -4, -5, -6};
        print(moveZeroes(nums));
    }


    /**
     * 这类数组原地删除数据的题目，考察的就是两根指针的应用，
     *
     * 我们设置两根指针slow和fast，fast每次都递增，所以称之为fast，当遍历到不是0的时候，slow指针就存储fast此时遍历的元素，slow加一，当遍历到需要删除的元素0(就相当于移动0到最后)时，略过slow，直接fast++，相当于删除了0.同时设置一个变量记录新数组的长度。
     * 最后我们再遍历剩下的元素，并给他们赋值为0即可。
     * ** 这道题可以看作是删除元素那道题的扩展应用**
     *
     * @param nums
     */
    public static int[] moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                ++slow;
            }
            fast++;
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
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
