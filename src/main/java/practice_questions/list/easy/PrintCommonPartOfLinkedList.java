package practice_questions.list.easy;

import practice_questions.list.common.ListNode;

/**
 * @BelongsPackage: practice_questions.list.easy
 * @ClassName: PrintCommonPartOfLinkedList
 * @Author: 丛虹羽
 * @Date: 2024/8/10 上午8:59
 * @Description: 打印两个顺序链表的公共部分
 */
public class PrintCommonPartOfLinkedList {

    /**
     * 返回两个链表公共部分的头节点
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode printCommonPartOfLinkedList(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode commonHead = null;
        ListNode commonTail = null;
        while (head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                head1 = head1.next;
            } else if (head1.val > head2.val) {
                head2 = head2.next;
            } else {
                if (commonHead == null) {
                    commonHead = new ListNode(head1.val);
                    commonTail = commonHead;
                } else {
                    commonTail.next = new ListNode(head1.val);
                    commonTail = commonTail.next;
                }
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        return commonHead;
    }

    /**
     * 打印链表信息
     *
     * @param head
     */
    public static void printList(ListNode head) {
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
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(7);
        ListNode listNode4 = new ListNode(8);
        ListNode listNode5 = new ListNode(10);
        ListNode listNode6 = new ListNode(12);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        System.out.print("链表1：");
        printList(listNode1);
        // 1 -> 5 -> 7 -> 8 -> 10 -> 12

        ListNode listNode7 = new ListNode(3);
        ListNode listNode8 = new ListNode(5);
        ListNode listNode9 = new ListNode(10);
        ListNode listNode10 = new ListNode(12);
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;
        System.out.print("链表2：");
        printList(listNode7);
        // 3 -> 5 -> 10 -> 12

        System.out.print("获取链表公共信息：");
        printList(printCommonPartOfLinkedList(listNode1, listNode7));
        // 1 -> 5 -> 7 -> 8 -> 10 -> 12
    }
}
