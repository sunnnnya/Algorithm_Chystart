package job_interview.code_top.single_list;

import job_interview.alg_basic_know.list.ext.ListNode;

/**
 * @BelongsPackage: job_interview.code_top.single_list
 * @ClassName: ReverseKGroup
 * @Author: 丛虹羽
 * @Date: 2025/4/16 00:07
 * @Description: K 个一组翻转链表
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
 */
public class ReverseKGroup {

    /**
     * 反转 K 组链表
     *
     * @param head 链表的头节点
     * @param k    k 组
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        int len = getLength(head);
        for(int i = 0; i < len / k; i++) {
            ListNode[] nodes = reverse(p0.next, k);
            ListNode tail = p0.next;
            p0.next.next = nodes[1];
            p0.next = nodes[0];
            p0 = tail;
        }
        return dummy.next;
    }

    /**
     * 计算链表的长度信息
     *
     * @param head 头节点
     * @return
     */
    private static int getLength(ListNode head) {
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    /**
     * 有效反转链表
     *
     * @param head 头节点
     * @param k    k 组
     * @return
     */
    private static ListNode[] reverse(ListNode head, int k) {
        ListNode pre = null;
        ListNode next = null;
        for(int i = 0; i < k; i++) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return new ListNode[]{pre, head};
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
     * 测试
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
        ListNode res = reverseKGroup(node1, 2);
        print(res);
        // 1 -> 4 -> 3 -> 2 -> 5

        System.out.println();

        ListNode node11 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        ListNode node33 = new ListNode(3);
        ListNode node44 = new ListNode(4);
        ListNode node55 = new ListNode(5);
        node11.next = node22;
        node22.next = node33;
        node33.next = node44;
        node44.next = node55;
        print(node11);
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode res1 = reverseKGroup(node1, 3);
        print(res1);
        // 1 -> 4 -> 3 -> 2 -> 5
    }
}
