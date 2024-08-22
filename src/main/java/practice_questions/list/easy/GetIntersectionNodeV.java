package practice_questions.list.easy;

import practice_questions.list.common.ListNode;
import sun.security.provider.SHA;

/**
 * @BelongsPackage: practice_questions.list.easy
 * @ClassName: GetIntersectionNodeV
 * @Author: 丛虹羽
 * @Date: 2024/8/22 下午10:30
 * @Description: 训练计划 V
 *
 * 某教练同时带教两位学员，分别以链表 l1、l2 记录了两套核心肌群训练计划，节点值为训练项目编号。两套计划仅有前半部分热身项目不同，后续正式训练项目相同。请设计一个程序找出并返回第一个正式训练项目编号。如果两个链表不存在相交节点，返回 null 。
 *
 * leetcode: https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 */
public class GetIntersectionNodeV {

    /**
     * 返回链表的信息
     */
    public static class Info {
        public int len;
        public ListNode tail;

        public Info(int len, ListNode tail) {
            this.len = len;
            this.tail = tail;
        }
    }

    /**
     * 获取链表的基本信息
     *
     * @param head
     * @return
     */
    public static Info getInfo(ListNode head) {
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode pre = head;
        while (head != null) {
            ++len;
            pre = head;
            head = head.next;
        }
        return new Info(len, pre);
    }

    /**
     * 没有环存在，使用最普通的方法
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Info infoA = getInfo(headA);
        Info infoB = getInfo(headB);
        if (infoA.tail != infoB.tail) {
            return null;
        }
        int len = Math.abs(infoA.len - infoB.len);
        ListNode LHead = infoA.len > infoB.len ? headA : headB;
        ListNode SHead = LHead == headA ? headB : headA;
        for (; len > 0; len--) {
            LHead = LHead.next;
        }
        while (LHead != SHead) {
            LHead = LHead.next;
            SHead = SHead.next;
        }
        return SHead;
    }


    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(8);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(0);
        ListNode listNode8 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode3;
        ListNode result = getIntersectionNode(listNode1, listNode6);
        System.out.println(result == null ? null : result.val);
        // 8

        ListNode listNode11 = new ListNode(2);
        ListNode listNode12 = new ListNode(6);
        ListNode listNode13 = new ListNode(4);
        listNode11.next = listNode12;
        listNode12.next = listNode13;

        ListNode listNode14 = new ListNode(1);
        ListNode listNode15 = new ListNode(5);
        listNode14.next = listNode15;
        ListNode result1 = getIntersectionNode(listNode14, listNode11);
        System.out.println(result1 == null ? null : result1.val);
        // null
    }
}
