package basic_knowledge.list.easy;

import practice_questions.list.common.ListNode;

/**
 * @BelongsPackage: basic_knowledge.list.easy
 * @ClassName: FastSlowPointer
 * @Author: 丛虹羽
 * @Date: 2024/8/16 下午4:26
 * @Description: 快慢指针的使用
 *
 * 快指针一次走两个，满指针一次走一个
 *
 * 如果是奇数的话，返回重点的位置。偶数的话返回，上中点位置。
 */
public class FastSlowPointer {

    /**
     * 获取重点的节点值，快慢指针的使用
     *
     * @param head
     * @return
     */
    public static int getMidListNodeValue(ListNode head) {
        if (head == null) {
            return -1;
        }
        ListNode F = head;
        ListNode S = head;
        while (F.next != null && F.next.next != null) {
            S = S.next;
            F = F.next.next;
        }
        return S.val;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("=====================奇数个数单链表中点=======================");
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println(getMidListNodeValue(listNode1));
        // 3

        System.out.println("=====================偶数个数单链表中点=======================");
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode9 = new ListNode(9);
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        System.out.println(getMidListNodeValue(listNode6));
        // 7
    }
}
