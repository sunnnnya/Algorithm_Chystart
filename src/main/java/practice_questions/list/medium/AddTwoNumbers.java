package practice_questions.list.medium;

import practice_questions.list.common.ListNode;

/**
 * @BelongsPackage: practice_questions.list.medium
 * @ClassName: AddTwoNumbers
 * @Author: 丛虹羽
 * @Date: 2024/8/15 下午2:15
 * @Description: 两数相加
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * leetcode: https://leetcode.cn/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    /**
     * 链表相加
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getListLength(l1);
        int len2 = getListLength(l2);
        ListNode longHead = len1 > len2 ? l1 : l2;
        ListNode shortHead = longHead == l1 ? l2 : l1;
        ListNode head = longHead;
        int carry = 0;
        ListNode pre = head;
        while (shortHead != null) {
            int total = longHead.val + shortHead.val + carry;
            longHead.val = total % 10;
            carry = total / 10;
            pre = longHead;
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        while (longHead != null) {
            int total = longHead.val + carry;
            longHead.val = total % 10;
            carry = total / 10;
            pre = longHead;
            longHead = longHead.next;
        }
        if (carry != 0) {
            pre.next = new ListNode(carry);
        }
        return head;
    }

    /**
     * 获取链表的长度
     *
     * @param head
     * @return
     */
    private static int getListLength(ListNode head) {
        int sum = 0;
        while (head != null){
            ++sum;
            head = head.next;
        }
        return sum;
    }

    /**
     * 打印链表
     *
     * @param head
     */
    public static void print(ListNode head) {
        if (head == null) {
            return ;
        }
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
        System.out.println("===============链表的基本信息===============");
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        print(listNode1);

        System.out.println("===============链表的基本信息===============");
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        print(listNode4);

        System.out.println("===========链表相加之后的基本信息============");
        print(addTwoNumbers(listNode1, listNode4));
        System.out.println();

        System.out.println("===============链表的基本信息===============");
        ListNode listNode7 = new ListNode(0);
        print(listNode7);

        System.out.println("===============链表的基本信息===============");
        ListNode listNode8 = new ListNode(0);
        print(listNode8);

        System.out.println("===========链表相加之后的基本信息============");
        print(addTwoNumbers(listNode7, listNode8));
        System.out.println();

        System.out.println("===============链表的基本信息===============");
        ListNode listNode9 = new ListNode(9);
        ListNode listNode10 = new ListNode(9);
        ListNode listNode11 = new ListNode(9);
        ListNode listNode12 = new ListNode(9);
        ListNode listNode13 = new ListNode(9);
        ListNode listNode14 = new ListNode(9);
        ListNode listNode15 = new ListNode(9);
        listNode9.next = listNode10;
        listNode10.next = listNode11;
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        listNode14.next = listNode15;
        listNode15.next = null;
        print(listNode9);

        System.out.println("===============链表的基本信息===============");
        ListNode listNode16 = new ListNode(9);
        ListNode listNode17 = new ListNode(9);
        ListNode listNode18 = new ListNode(9);
        ListNode listNode19 = new ListNode(9);
        listNode16.next = listNode17;
        listNode17.next = listNode18;
        listNode18.next = listNode19;
        listNode19.next = null;
        print(listNode16);

        System.out.println("===========链表相加之后的基本信息============");
        print(addTwoNumbers(listNode9, listNode16));
    }
}
