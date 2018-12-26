package com.iwenchaos.mdualgor.link;

/**
 * Created by chaos
 * on 2018/12/26. 11:33
 * 文件描述：给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */
public class DelNodeFromKAlgo {

    public static void main(String[] args) {

    }

    private static ListNode removeNthFromEnd1(ListNode head, int n) {

//        int target = Math.abs(())
        ListNode node = head;
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }

        if ((len - n) == 0) {
            return head.next;
        }
        node = head;
        int i = 0;
        while (node != null) {
            i++;
            if (i == (len - n)) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }

        return head;

    }

    /**
     * 快慢指针法,只遍历一次即可
     *
     * @param head
     * @param n
     * @return
     */
    private static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        while (n != 0) {
            n--;
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
