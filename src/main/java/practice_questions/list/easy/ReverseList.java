package practice_questions.list.easy;

import practice_questions.list.common.ListNode;

/**
 * @BelongsPackage: practice_questions.list.easy
 * @ClassName: ReverseList
 * @Author: 丛虹羽
 * @Date: 2024/8/9 下午4:46
 * @Description: 反转链表
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * leetcode: https://leetcode.cn/problems/reverse-linked-list/description/
 */
public class ReverseList {

    /**
     * 反转链表 的 模板代码
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode next = null;
        ListNode pre = null;
        while (head != null) {
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
     * @param head
     */
    public static void print(ListNode head) {
        while (head != null) {
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
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.print("原链表：");
        print(listNode1);
        System.out.print("翻转之后链表：");
        print(reverseList(listNode1));
        // 原链表：1 -> 2 -> 3 -> 4 -> 5
        // 翻转之后链表：5 -> 4 -> 3 -> 2 -> 1

        ListNode listNode6 = new ListNode(2);
        ListNode listNode7 = new ListNode(1);
        listNode7.next = listNode6;
        System.out.print("原链表：");
        print(listNode7);
        System.out.print("翻转之后链表：");
        print(reverseList(listNode7));
        // 原链表：1 -> 2
        // 翻转之后链表：2 -> 1
    }
}