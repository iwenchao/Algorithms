package com.iwenchaos.mdualgor.array;

/**
 * Created by chaos
 * on 2019/1/18. 20:00
 * 文件描述：斐波那契系列问题
 * <p>
 * 1. 给定整数N，返回斐波那契数列的第N项
 * <p>
 * 2. 给定整数N，代表台阶数，一个可以跨2个或者1个台阶，返回多少种走法？
 * <p>
 * 3. 兔子繁衍的斐波那契问题
 *
 * f(n) = f(n-1) + f(n-2)
 * f(1) = f(2) = 1;
 */
public class FabnaciSerialQAAlgo {


    public static void main(String[] args){
        System.out.print(fabnaci(5));
    }

    /**
     * 使用递归，导致时间复杂度为O(2^n)过大
     * @return 返回第n项
     */
    private  static int fabnaci(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        return fabnaci(n-1)+fabnaci(n-2);
    }

    /**
     * 不使用递归,for循环计算出从1，到n的每个值，最后f(n-1) + f(n-2)就好
     * 时间复杂度为O(n)
     * @return
     */
    private static int fabnaci2(int n){
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int pre = 1;
        int suf = 1;
        int tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = suf;
            suf = suf + pre;
            pre = tmp;
        }
        return suf;


    }

}
