package practice_questions.list.easy;

import practice_questions.list.common.ListNode;

/**
 * @BelongsPackage: practice_questions.list.easy
 * @ClassName: DeleteNode
 * @Author: 丛虹羽
 * @Date: 2024/8/12 下午8:50
 * @Description: 删除链表的节点
 *
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 *
 * leetcode：https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof
 */
public class DeleteNode {

    /**
     * 删除单链表中指定值的节点
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head != null && head.val == val) {
            head = head.next;
        }
        // 找到不等于 val 的重新节点
        ListNode cur = head;
        ListNode pre = head;
        while (cur != null) {
            if (cur.val == val){
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 打印链表
     *
     * @param head
     */
    public static void print(ListNode head) {
        if(head == null) {
            return;
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
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(9);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        System.out.print("原始链表：");
        print(listNode1);

        System.out.print("删除节点之后的链表：");
        print(deleteNode(listNode1, 5));

        ListNode listNode8 = new ListNode(1);
        ListNode listNode9 = new ListNode(1);
        listNode8.next = listNode9;
        print(deleteNode(listNode8, 1));
    }
}
