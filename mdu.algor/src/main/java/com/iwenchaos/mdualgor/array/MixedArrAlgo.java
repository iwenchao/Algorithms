package com.iwenchaos.mdualgor.array;

import java.util.Arrays;

/**
 * Created by chaos
 * on 2018/12/14. 14:32
 * 文件描述：给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class MixedArrAlgo {


    public static void main(String[] args) {

        int[] nums1 = {2, 4, 4, 5, 9, 9}, nums2 = {1, 3, 4, 4, 8, 9, 9};
        print(intersect(nums1,nums2));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return null;
        }
        if (nums2 == null || nums2.length == 0) {
            return null;
        }
        //先将两个数组排序，这样才遍历的时候，可以及时break
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (nums1.length > nums2.length) {//保持nums1为长度较小的一个
            int[] tmp = nums2;
            nums2 = nums1;
            nums1 = tmp;
        }
        int[] result = new int[nums1.length];
        int index = 0;
        int kIndex = 0;
        for (int i = 0; i < nums1.length; i++) {

            for (int k = kIndex; k < nums2.length; k++) {
                if (nums1[i] == nums2[k]) {
                    result[index++] = nums1[i];
                    kIndex = k + 1;
                    break;
                } else {
                    if (nums1[i] < nums2[k]) {//如果i位置上的数字小于k的， 则后边的不用再比较
                        break;
                    }
                }
            }
        }

        return  Arrays.copyOf(result, index);

    }

    private static void print(int[] nums) {
        System.out.println();
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
