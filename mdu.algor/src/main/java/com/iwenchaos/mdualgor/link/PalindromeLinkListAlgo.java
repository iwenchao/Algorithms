package com.iwenchaos.mdualgor.link;

import java.util.Stack;

/**
 * Created by chaos
 * on 2018/12/27. 13:53
 * 文件描述：请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class PalindromeLinkListAlgo {


    public static void main(String[] args) {

    }


    /**
     * 利用栈结构，将链表压入栈内，这样链表和栈在值的对应上其实是一致的，如果是回文的话。
     */
    private static boolean isPalindrome(ListNode head) {
        //先利用stack 将链表压入栈内
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        //依次对比两者的值 是否一样。一旦不同，则说明不是回文
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }

        return true;
    }

}
