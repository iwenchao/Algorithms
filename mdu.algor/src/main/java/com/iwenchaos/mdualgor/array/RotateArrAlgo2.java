package com.iwenchaos.mdualgor.array;

/**
 * Created by chaos
 * on 2018/12/22. 18:23
 * 文件描述：
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 */
public class RotateArrAlgo2 {


    public static void main(String[] args) {

    }


    private static void rotateArr(int[][] matrix) {
        int dim = matrix[0].length;
        int tmp;
        for (int i = 0; i < dim / 2; i++) {
            for (int j = i; j < dim - 1 - i; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[dim - i - 1][j];
                matrix[dim - i - 1][j] = matrix[dim - i - 1][dim - j - 1];
                matrix[dim - i - 1][dim - j - 1] = matrix[i][dim - j - 1];
                matrix[i][dim - j - 1] = tmp;
            }
        }
    }

}
