package practice_questions.list.easy;

import practice_questions.list.common.ListNode;

/**
 * @BelongsPackage: practice_questions.list.easy
 * @ClassName: GetIntersectionNode
 * @Author: 丛虹羽
 * @Date: 2024/8/10 下午10:00
 * @Description: 相交链表
 *
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * leetcode：https://leetcode.cn/problems/intersection-of-two-linked-lists
 */
public class GetIntersectionNode {

    /**
     * 返回以headA和headB为头节点的链表是否相交于某一节点，首先检测出当前的单链表是否有环：
     *      (1)如果 不相交 且 没有环 说明，就是两根单链表；  -> 返回 null
     *                  |   |
     *                  |   |
     *                  |   |
     *      (2)如果  相交  且 无环 说明，两根单链表最后的部分一定是公共部分；-> 长链表走长度差值步，然后两个链表一起走，相交的点就是答案；
     *                \
     *                 \   /
     *                  \/
     *                  |
     *                  |
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        ListNode LHead = lenA > lenB ? headA : headB;
        ListNode SHead = LHead == headA ? headB : headA;
        for (int i = 0; i < Math.abs(lenA - lenB); i++) {
            LHead = LHead.next;
        }
        while (LHead != SHead) {
            LHead = LHead.next;
            SHead = SHead.next;
        }
        return LHead;
    }

    /**
     * 获取链表的长度
     *
     * @param head
     * @return
     */
    public static int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            ++len;
            head = head.next;
        }
        return len;
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
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(0);
        ListNode listNode8 = new ListNode(1);
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode3;
        System.out.println(getIntersectionNode(listNode1, listNode6).val);
        // 8
    }
}
