package leetcode.hot100;

import leetcode.skill.list.ListNode;

/**
 * @BelongsPackage: leetcode.hot100
 * @ClassName: ReverseList
 * @Author: 丛虹羽
 * @Date: 2025/3/7 23:16
 * @Description: 反转链表 - chystart
 *
 * leetcode: https://leetcode.cn/problems/reverse-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class ReverseList {

    /**
     * 单链表的反转
     *      使用两个节点类型变量记住 后面 和 前面 的节点信息，然后逐步后移
     *
     * @param head 头节点信息
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 打印链表信息
     *
     * @param head 链表头节点
     */
    public static void printList(ListNode head) {
        while(head != null) {
            if (head.next != null) {
                System.out.print(head.val + " -> ");
            } else{
                System.out.println(head.val);
            }
            head = head.next;
        }
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

        System.out.print("原始链表信息：");
        printList(node1);
        // 原始链表信息：1 -> 2 -> 3 -> 4 -> 5

        System.out.print("反转后的链表信息：");
        printList(reverseList(node1));
        // 反转后的链表信息：5 -> 4 -> 3 -> 2 -> 1
    }
}
