package leetcode.hot100;

import leetcode.skill.list.ListNode;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-10 15:20
 * @description: 合并两个有序链表
 *
 * leetcode: https://leetcode.cn/problems/merge-two-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked
 **/
public class MergeTwoLists {

    /**
     * 合并两个有序链表，注意用来连接的指针一定要移动，如果不移动，链表直接崩溃！！
     *
     * @param list1 链表头节点 1
     * @param list2 链表头节点 2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode head = list1.val <= list2.val ? list1 : list2;
        ListNode cur1 = head.next;
        ListNode cur2 = head == list1 ? list2 : list1;
        ListNode pre = head;
        while(cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

    /**
     * 打印链表
     *
     * @param head 链表头节点
     */
    public static void printListNode(ListNode head) {
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
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        printListNode(mergeTwoLists(node1, node4));
        // 1 -> 1 -> 2 -> 3 -> 4 -> 4
    }
}
