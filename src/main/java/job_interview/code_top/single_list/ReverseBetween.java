package job_interview.code_top.single_list;

import job_interview.alg_basic_know.list.ext.ListNode;

/**
 * @BelongsPackage: job_interview.code_top.single_list
 * @ClassName: ReverseBetween
 * @Author: 丛虹羽
 * @Date: 2025/4/15 23:48
 * @Description: 反转链表 II
 * https://leetcode.cn/problems/reverse-linked-list-ii/description/
 */
public class ReverseBetween {

    /**
     * 指定索引位置反转
     *
     * @param head  头节点
     * @param left  left index
     * @param right right index
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        for(int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }
        ListNode pre = null;
        ListNode cur = p0.next;
        for(int i = 0; i < right - left + 1; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }

    /**
     * 打印链表信息
     *
     * @param head 链表头节点
     */
    private static void print(ListNode head) {
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
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        print(node1);
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode res = reverseBetween(node1, 2, 4);
        print(res);
        // 1 -> 4 -> 3 -> 2 -> 5
    }
}
