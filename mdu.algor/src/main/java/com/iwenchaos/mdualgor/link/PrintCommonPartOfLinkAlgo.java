package com.iwenchaos.mdualgor.link;

/**
 * Created by chaos
 * on 2019/2/24. 17:13
 * 文件描述：打印两个链表的公共(相同)部分
 */
public class PrintCommonPartOfLinkAlgo {


    public static void print(ListNode node1, ListNode node2) {
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                node1 = node1.next;
            } else if (node1.val > node2.val) {
                node2 = node2.next;
            } else {
                System.out.print(" " + node1.val);
                node1 = node1.next;
                node2 = node2.next;
            }
        }
    }


}
