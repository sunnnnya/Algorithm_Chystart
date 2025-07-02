package leetcode.hot100;

import leetcode.skill.list.ListNode;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-10 16:10
 * @description: 两数相加
 *
 * leetcode: https://leetcode.cn/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-100-liked
 **/
public class AddTwoNumbers {

    /**
     * 两数相加，注意数值溢出的问题
     *
     * @param l1 链表 l1 的头节点
     * @param l2 链表 l2 的头节点
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode LHead = getListLength(l1) >= getListLength(l2) ? l1 : l2;
        ListNode SHead = LHead == l1 ? l2 : l1;
        ListNode head = LHead;
        ListNode pre = head;
        int carry = 0;
        while(SHead != null) {
            int total = LHead.val + SHead.val + carry;
            carry = total / 10;
            LHead.val = total % 10;
            SHead = SHead.next;
            pre = LHead;
            LHead = LHead.next;
        }
        while(LHead != null) {
            int total = LHead.val + carry;
            carry = total / 10;
            LHead.val = total % 10;
            pre = LHead;
            LHead = LHead.next;
        }
        if(carry != 0) {
            pre.next = new ListNode(carry);
        }
        return head;
    }

    /**
     * 返回链表的长度信息
     *
     * @param head 链表头节点
     * @return
     */
    public static int getListLength(ListNode head) {
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    /**
     * 打印链表信息
     *
     * @param head 链表头节点
     */
    public static void printSingleList(ListNode head) {
        while(head != null) {
            if (head.next == null) {
                System.out.println(head.val);
            } else {
                System.out.print(head.val + " -> ");
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
        ListNode nodeA = new ListNode(9);
        ListNode nodeB = new ListNode(9);
        ListNode nodeC = new ListNode(9);
        ListNode nodeD = new ListNode(9);
        ListNode nodeE = new ListNode(9);
        ListNode nodeF = new ListNode(9);
        ListNode nodeG = new ListNode(9);
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;
        nodeE.next = nodeF;
        nodeF.next = nodeG;
        printSingleList(nodeA);

        ListNode nodeAA = new ListNode(9);
        ListNode nodeBB = new ListNode(9);
        ListNode nodeCC = new ListNode(9);
        ListNode nodeDD = new ListNode(9);
        nodeAA.next = nodeBB;
        nodeBB.next = nodeCC;
        nodeCC.next = nodeDD;
        printSingleList(nodeAA);

        ListNode afterAddNewListNode = addTwoNumbers(nodeAA, nodeA);
        printSingleList(afterAddNewListNode);
    }
}
