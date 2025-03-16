package leetcode.hot100;

import leetcode.skill.list.ListNode;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-11 09:48
 * @description: 删除链表的倒数第 N 个结点
 *
 * leetcode: https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-100-liked
 **/
public class RemoveNthFromEnd {

    /**
     * 链表常规写法
     *
     * @param head 头节点
     * @param n 倒数第 n 个节点元素
     * @return 返回头节点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = dummy;
        while(n-- > 0) {
            right = right.next;
        }
        while(right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }

    /**
     * 获取数组的长度
     *
     * @param head 链表的头节点
     * @return 长度
     */
    public static int getLength(ListNode head) {
        int len = 0;
        for(;head != null; head = head.next) {
            len++;
        }
        return len;
    }

    /**
     * 打印节点信息
     *
     * @param head 头节点
     */
    public static void printList(ListNode head) {
        while(head != null) {
            if (head.next == null) {
                System.out.print(head.val);
            } else {
                System.out.print(head.val + " -> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode newHead = removeNthFromEnd(node1, 2);
        printList(newHead);
    }
}
