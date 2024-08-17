package practice_questions.list.easy;

import practice_questions.list.common.ListNode;

/**
 * @BelongsPackage: practice_questions.list.easy
 * @ClassName: MiddleNode
 * @Author: 丛虹羽
 * @Date: 2024/8/17 上午11:52
 * @Description: 链表的中间结点
 *
 * leetcode：https://leetcode.cn/problems/middle-of-the-linked-list
 *
 */
public class MiddleNode {

    /**
     * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
     *      奇数返回中间节点
     *      偶数返回第二个中间结点
     *
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode F = head.next;
        ListNode S = head.next;
        while (F != null && F.next != null && F.next.next != null) {
            F = F.next.next;
            S = S.next;
        }
        return S == null ? head : S;
    }

    /**
     * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
     *      奇数返回中间节点
     *      偶数返回第一个中间结点
     *
     * @param head
     * @return
     */
    public static ListNode middleNode1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode F = head;
        ListNode S = head;
        while (F.next != null && F.next.next != null) {
            F = F.next.next;
            S = S.next;
        }
        return S;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("=========测试链表中，奇数节点个数返回中间节点，偶数返回第二个中间节点=========");
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        // ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        // listNode5.next = listNode6;
        System.out.println(middleNode(listNode1).val);
        // 4

        ListNode listNode7 = new ListNode(100);
        ListNode listNode8 = new ListNode(101);
        ListNode listNode9 = new ListNode(109);
        ListNode listNode10 = new ListNode(110);
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;
        System.out.println(middleNode(listNode7).val);
        // 109

        System.out.println("=========测试链表中，奇数节点个数返回中间节点，偶数返回第一个中间节点=========");
        System.out.println(middleNode1(listNode1).val);

        System.out.println(middleNode1(listNode7).val);

        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(3);
        listNode11.next = listNode12;

        System.out.println(middleNode1(listNode11).val);
        System.out.println(middleNode(listNode11).val);
    }
}
