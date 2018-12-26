package com.iwenchaos.mdualgor.link;

/**
 * Created by chaos
 * on 2018/12/26. 14:42
 * 文件描述：反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseListAlgo {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reverseList(head);
    }


    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {//循环到单链表的最后一个节点，返回该节点
            return head;
        } else {
            ListNode node = reverseList(head.next);//递归当前链表，直到链表尾节点
            head.next.next = head;//链表尾节点的前一个节点为head，将head指向head的next.next；然后断开head.next之后的链接
            head.next = null;
            return node;
        }

    }


}
