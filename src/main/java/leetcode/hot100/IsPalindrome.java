package leetcode.hot100;

import leetcode.skill.list.ListNode;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-08 17:58
 * @description: 回文链表
 *
 * leetcode: https://leetcode.cn/problems/palindrome-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
 **/
public class IsPalindrome {

    /**
     * 原始链表操作
     *
     * @param head 原始链表头节点
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode midListNode = getMiddleListNode(head);
        ListNode reverseNode = reverseList(midListNode);
        while(reverseNode != null) {
            if(head.val != reverseNode.val) {
                return false;
            }
            head = head.next;
            reverseNode = reverseNode.next;
        }
        return true;
    }

    /**
     * 获取链表中点
     *
     * @param head 原始链表头节点
     * @return
     */
    public static ListNode getMiddleListNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 链表的反转
     *
     * @param head 原始链表头节点
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while(head != null) {
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
     * @param head 原始链表头节点
     */
    public static void printList(ListNode head) {
        while(head != null) {
            if(head.next == null) {
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
        ListNode nodeA = new ListNode(1);
        ListNode nodeB = new ListNode(2);
        ListNode nodeC = new ListNode(2);
        ListNode nodeD = new ListNode(1);
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        System.out.println(isPalindrome(nodeA));
        // true
    }
}
