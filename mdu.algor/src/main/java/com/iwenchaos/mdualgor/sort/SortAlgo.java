package com.iwenchaos.mdualgor.sort;

import java.util.Arrays;

/**
 * Created by chaos
 * on 2019/2/13. 17:08
 * 文件描述： 常见的排序算法
 * <p>
 * 1. 直接插入排序 √
 * 2. 希尔排序
 * 3. 简单选择排序 x
 * 4. 堆排序 x  涉及到树结构，暂且忽略
 * 5. 冒泡排序 √
 * 6. 快速排序 √
 * 7. 归并排序 √
 * 8. 基数排序
 * https://itimetraveler.github.io/2017/07/18/%E5%85%AB%E5%A4%A7%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95%E6%80%BB%E7%BB%93%E4%B8%8Ejava%E5%AE%9E%E7%8E%B0/
 */
public class SortAlgo {


    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 26, 49, 55, 4};
        selectSort(arr);
        printArray(arr);
    }


    /**
     * 插入排序的设计初衷是往有序的数组中快速插入一个新的元素。
     * 它的算法思想是：把要排序的数组分为了两个部分,
     * 一部分是数组的全部元素(除去待插入的元素),另一部分是待插入的元素;
     * 先将第一部分排序完成, 然后再插入这个元素.
     * 其中第一部分的排序也是通过再次拆分为两部分来进行的.
     * <p>
     * 1. 直接插入排序
     * 2. 折半插入排序（二分插入排序）
     * 3. 链表插入排序
     * 4. 希尔排序
     * <p>
     * <p>
     * 直接插入排序：基本思想是：将数组中的所有元素依次跟前面已经排好的元素相比较，
     * 如果选择的元素比已排序的元素小，则交换，直到全部元素都比较过为止。
     */

    public static int[] directInsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int k = i; k >= 0; k--) {
                if (k > 0 && temp < arr[k - 1]) {//选择的元素temp比已排序的元素小，则交换
                    arr[k] = arr[k - 1];
                } else {
                    arr[k] = temp;
                    break;
                }
            }
        }
        return arr;
    }


    /**
     * 冒泡排序
     * <p>
     * 1. 比较相邻的元素，如果第一个比第二个大，就交换他们俩
     * 2. 对每一对相邻元素做同样的工作，从开始到结尾，每一次轮回，都会将最值冒泡到尾端
     * 3. 重复2
     * 4. 直到没有任何一对数字需要做比较
     * <p>
     * 改进点：
     */
    public static int[] bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {//前者比后者大，则交换之
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 快速排序：是对冒泡排序的一种改进。采用了分治的思想。
     * <p>
     * 算法描述：
     * 1. 从数列中挑出一个元素，称为基准
     * 2. 重新排序数列，所有比基准值小的元素放在前边，大的放在后边（相等的任意选择一边）。
     * 在这个分区结束后，该基准就位于数列的中间位置。
     * 3. 递归地把小于基准值元素的子序列和大于基准值的子数列排序
     *
     * @param arr
     * @return
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length <= 0) return;
        if (low >= high) return;
        int left = low;
        int right = high;

        int temp = arr[left];//挖槽1，保存基准值
        while (left < right) {
            //挖槽2：从后向前找到比基准值小的元素，复给arr[left]
            while (left < right && arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right];
            //挖槽3：从前向后找到比基准值大的元素，复给arr[right]
            while (left < right && arr[left] <= temp) {
                left++;
            }
            arr[right] = arr[left];
        }
        //一轮下来，将基准值补到挖槽3中
        arr[left] = temp;
        System.out.println("Sorting: " + Arrays.toString(arr));
        //然后依次从左侧，右侧递归进行
        quickSort(arr, low, left - 1);
        quickSort(arr, left + 1, high);
    }


    /**
     * 归并排序：采用分治法，各层分治递归进行
     * 算法思想：将两个或者两个以上的有序表合成一个新的有序表。
     * 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并成整体有序序列
     * <p>
     * 算法实现：
     * 1. 自上而下的递归
     * 2. 自下而上的迭代
     */
    public static int[] mergingSort(int[] arr) {
        if (arr.length <= 1) return arr;

        int num = arr.length >> 1;
        int[] leftArr = Arrays.copyOfRange(arr, 0, num);
        int[] rightArr = Arrays.copyOfRange(arr, num, arr.length);
        return mergeLRArr(mergingSort(leftArr), mergingSort(rightArr));
    }

    static int[] mergeLRArr(int[] leftArr, int[] rightArr) {
        int[] result = new int[leftArr.length + rightArr.length];
        int i = 0, j = 0, k = 0;
        //从两个有序子序列中，找出最小的元素，赋值给result[k],k++
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                result[k++] = leftArr[i++];
            } else {
                result[k++] = rightArr[j++];
            }
        }
        //检查两个子序列是否有多余元素
        while (i < leftArr.length) {
            result[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            result[k++] = rightArr[j++];
        }
        return result;
    }


    /**
     * 选择排序
     *
     * 1. 从待排序的序列中，找到最小值的元素；
     * 2. 如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
     * 3. 从余下的N-1个元素中，重复1，2操作，直到排序结束
     * @param arr
     */
    public static void selectSort(int[] arr){

        for (int i = 0; i < arr.length-1; i++) {
            //遍历剩余序列，找到最小值
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            //如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
            if(minIndex != i){
                int minValue = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = minValue;
            }

        }


    }



    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "->");
        }
    }
}
