package com.iwenchaos.mdualgor.stack;

import java.util.LinkedList;

/**
 * Created by chaos
 * on 2019/2/24. 16:58
 * 文件描述：
 */
public class MaxWindowAlgo {


    /**
     * 4.3.5.4.3.6.7
     *
     * @param data
     * @param wLen
     * @return
     */
    public static int[] getMaxWindow(int[] data, int wLen) {
        if (data == null || wLen < 1 || data.length < wLen) {
            return null;
        }
        int[] res = new int[data.length - wLen + 1];
        LinkedList<Integer> qmax = new LinkedList<>();//存放下标
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            while (!qmax.isEmpty() && data[qmax.peekLast()] <= data[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            //qmax的队头下标 == i-wLen 说明其已经过期，不在窗口内
            if (qmax.peekFirst() == (i - wLen)) {
                qmax.pollFirst();
            }
            //说明qmax的队头为窗口内的最大值下标
            if (i - wLen + 1 > 0) {
                res[index++] = data[qmax.peekFirst()];
            }
        }
        return res;

    }


}
