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
     * @param l1  链表的头节点信息
     * @param l2  链表的头节点信息
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getListLength(l1);
        int len2 = getListLength(l2);
        ListNode sHead = len1 < len2 ? l1 : l2;
        ListNode lHead = sHead == l1 ? l2 : l1;
        ListNode cur = lHead;
        ListNode last = lHead;
        int carry = 0;
        while(sHead != null) {
            int number = sHead.val + lHead.val + carry;
            lHead.val = number % 10;
            carry = number / 10;
            sHead = sHead.next;
            last = lHead;
            lHead = lHead.next;
        }
        while (lHead != null) {
            int number = lHead.val + carry;
            lHead.val = number % 10;
            carry = number / 10;
            last = lHead;
            lHead = lHead.next;
        }
        if (carry != 0) {
            last.next = new ListNode(carry);
        }
        return cur;
    }

    /**
     * 获取链表的长度
     *
     * @param head  链表的头节点
     * @return      返回链表的长度信息
     */
    private static int getListLength(ListNode head) {
        int count = 0;
        for(; head != null; count++) {
            head = head.next;
        }
        return count;
    }

    /**
     * 打印链表
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
     * 打印列表对应的数值信息
     *
     * @param head
     * @return
     */
    public static long getListNumber(ListNode head) {
        int num = getListLength(head);
        long result = 0L;
        for(int i = 0; i < num; i++, head = head.next) {
            result += (long) (head.val * Math.pow(10, i));
        }
        return result;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("===============链表1的基本信息===============");
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        print(listNode1);

        System.out.println("===============链表2的基本信息===============");
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        print(listNode4);

        System.out.println("===========链表相加之后的基本信息============");
        ListNode res1 = addTwoNumbers(listNode1, listNode4);
        print(res1);
        System.out.println("两个链表相加返回的结果是：" + getListNumber(res1));
        System.out.println();

        System.out.println("===============链表的基本信息===============");
        ListNode listNode7 = new ListNode(0);
        print(listNode7);

        System.out.println("===============链表的基本信息===============");
        ListNode listNode8 = new ListNode(0);
        print(listNode8);

        System.out.println("===========链表相加之后的基本信息============");
        ListNode res2 = addTwoNumbers(listNode7, listNode8);
        print(res2);
        System.out.println("两个链表相加返回的结果是：" + getListNumber(res2));
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
        ListNode res3 = addTwoNumbers(listNode9, listNode16);
        print(res3);
        System.out.println("两个链表相加返回的结果是：" + getListNumber(res3));
        System.out.println();
    }
}