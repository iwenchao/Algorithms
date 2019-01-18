package com.iwenchaos.mdualgor.link;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chaos
 * on 2019/1/18. 14:14
 * 文件描述：复制链表
 */
public class CopyListWithRandAlgo {


    public static void main(String[] args) {

    }


    private ListNode copyListWithRand(ListNode head) {
        //首先遍历原链表，将每个节点存储在map中
        ListNode cur = head;
        Map<ListNode, ListNode> dupMap = new HashMap<>();
        while (cur != null) {
            dupMap.put(cur, new ListNode(cur.val));
            cur = cur.next;
        }
        //再次遍历原链表，将每个节点的next，在dupMap中查找对应的新node
        cur = head;
        while (cur != null) {
            ListNode targetNext = dupMap.get(cur.next);
//            ListNode targetRand = dupMap.get(cur.rand);
            dupMap.get(cur).next = targetNext;
//            dupMap.get(cur).rand = targetRand;
            cur = cur.next;
        }
        return dupMap.get(head);
    }

}
