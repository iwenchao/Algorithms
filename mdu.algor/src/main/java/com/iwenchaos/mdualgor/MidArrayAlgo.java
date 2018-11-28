package com.iwenchaos.mdualgor;

/**
 * Created by chaos
 * on 2018/11/28. 13:51
 * 文件描述：
 */
public class MidArrayAlgo {


    public static void main(String[] args) {


    }


    /**
     * 找到两个有序数组的中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0;
        }
        if (nums1 == null) {
            int len2 = nums2.length;
            if (len2 % 2 == 0) {
                return (nums2[len2 / 2] + nums2[len2 / 2 + 1]) / 2.0;
            } else {
                return nums2[len2 / 2 + 1];
            }

        }

        if (nums2 == null) {
            int len1 = nums1.length;
            if (len1 % 2 == 0) {
                return (nums1[len1 / 2] + nums1[len1 / 2 + 1]) / 2.0;
            } else {
                return nums1[len1 / 2 + 1];
            }
        }
        return safeFind(nums1,nums2);

    }

    private static double safeFind(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] tmps = nums1;
            nums1 = nums2;
            nums2 = tmps;
            int tmp = m;
            m = n;
            n = tmp;

        }

        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;

            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;// i 太小
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                //i 过大
                iMax = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
