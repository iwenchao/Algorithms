package com.iwenchaos.mdualgor.link;

import java.util.Stack;

/**
 * Created by chaos
 * on 2019/1/18. 14:25
 * 文件描述：将两个整型链表相加 得到新的链表结果
 * 9-3-7  + 6-3 = 1-0-0-0
 */
public class CalcuTwoListAlgo {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        ListNode node = calcu(head, head2);
        node = ReverseListAlgo.reverseList(node);
        print(node);
    }

    private static void print(ListNode node){
        ListNode cur = node;
        while (cur != null){
            System.out.print(cur.val+"-->");
            cur = cur.next;
        }
    }


    /**
     * 利用栈结构
     */
    private static ListNode calcu(ListNode link0, ListNode link1) {
        Stack<ListNode> stack0 = genStack(link0);
        Stack<ListNode> stack1 = genStack(link1);

        ListNode result = new ListNode(-1);
        ListNode cur = result;
        boolean flag = false;
        while (!stack0.isEmpty() || !stack1.isEmpty()) {
            int node0Val = stack0.isEmpty() ? 0 : stack0.pop().val;
            int node1Val = stack1.isEmpty() ? 0 : stack1.pop().val;
            int value = (node0Val + node1Val);
            value = flag ? value + 1 : value;
            if (value >= 10) {
                flag = true;
                cur.next = new ListNode((value - 10));
            } else {
                flag = false;
                cur.next = new ListNode(value);
            }
            cur = cur.next;

        }


        if (flag) {
            cur.next = new ListNode(1);
        }
        return result.next;


    }


    private static Stack<ListNode> genStack(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        return stack;
    }
}
