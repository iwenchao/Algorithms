package com.iwenchaos.mdualgor;

/**
 * Created by chaos
 * on 2018/9/17. 20:06
 * 文件描述：
 */
public class Stone {

    public static void main(String[] args) {
//        System.out.println(numJewelsInStones("aA","aAABBBB"));

        System.out.print(test()+"");

    }


    public static int test(){
        int b = 0;
        try {
            int a = 5/0;
            b = 1;
            return b;
        }catch (Exception e){
            b = 3;
            return b;
        }finally {
            b = 4;
            return b;
        }
    }

    public static int numJewelsInStones(String J, String S) {
        int result = 0;

        if (J == null || J.isEmpty()) {
            return result;
        }
        if (S == null || S.isEmpty()) {
            return result;
        }
        int originLen = S.length();
        for (int i = 0, jLenght = J.length(); i < jLenght; i++) {
            String c = String.valueOf(J.charAt(i));
            S = S.replace(c, "");
        }
        result = originLen - S.length();

        return result;
    }



}
