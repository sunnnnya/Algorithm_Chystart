package leetcode.skill.list;

/**
 * @package: leetcode.skill.list
 * @author: chystart
 * @create: 2025-03-10 17:55
 * @description: 分隔链表
 *
 * leetcode: https://leetcode.cn/problems/partition-list/description/
 **/
public class Partition {

    /**
     * 链表的分割
     *
     * @param head 链表的头节点
     * @param x    分割的值
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        if(head == null) {
            return null;
        }
        ListNode sHead = null;
        ListNode sTail = null;
        ListNode lHead = null;
        ListNode lTail = null;
        while(head != null) {
            if(head.val < x) {
                if(sHead == null && sTail == null) {
                    sHead = head;
                    sTail = head;
                } else {
                    sTail.next = head;
                    sTail = sTail.next;
                }
            } else {
                if(lHead == null && lTail == null) {
                    lHead = head;
                    lTail = head;
                } else {
                    lTail.next = head;
                    lTail = lTail.next;
                }
            }
            head = head.next;
        }
        // 说明存在 >= x 的数字，存在的话设置尾巴的指向为 null
        if(lTail != null) {
            lTail.next = null;
        }
        // 说明没有出现 < x 的数字，直接返回 >= x 的头部
        if(sTail == null) {
            return lHead;
        }
        // 都存在直接拼接
        sTail.next = lHead;
        return sHead;
    }

    /**
     * 打印链表
     *
     * @param head 链表头节点
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
        // 构建链表
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        // 分割链表信息
        printList(partition(node1, 3));
    }
}
