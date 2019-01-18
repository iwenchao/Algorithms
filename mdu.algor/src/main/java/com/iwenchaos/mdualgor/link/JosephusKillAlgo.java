package com.iwenchaos.mdualgor.link;

/**
 * Created by chaos
 * on 2019/1/18. 13:21
 * 文件描述：环形单链表  约瑟夫问题
 *
 * n个节点成环形，从第一个人开始报数，报数到m的人出局；
 * 下一个人重新从1开始报数，依次循环
 * 直到最后一个人。
 */
public class JosephusKillAlgo {


    public static void main(String[] args){

    }

    /**
     * 该算法有个缺点：每次删除一个节点，都会遍历m次；时间复杂度为O（n*m）
     */
    private ListNode josephusKill(ListNode head,int m){
        if(head == null || head.next == head || m<1){
            return head;
        }
        //先要找到尾节点
        ListNode tail = head;
        while (tail.next != head){
            tail = head.next;
        }

        //然后：尾，首一起向下走，直到m位置，将首删除（首的next指向尾的next）
        int count = 0;
        while (tail != head){
            count++;
            if(count == m){
                tail.next = head.next;
                count = 0;
            }else {
                tail = tail.next;
            }
            head = tail.next;
        }

        return head;
    }

    /**
     * 如何通过计算 n、m之间的关系，直接得出最终的那个目标节点呢？
     *
     */
    private ListNode josephusKill2(ListNode head,int m){


        return head;
    }
}
