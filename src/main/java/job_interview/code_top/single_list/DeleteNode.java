package job_interview.code_top.single_list;

import job_interview.alg_basic_know.list.ext.ListNode;

/**
 * @BelongsPackage: job_interview.code_top.single_list
 * @ClassName: DeleteNode
 * @Author: 丛虹羽
 * @Date: 2025/4/15 00:56
 * @Description: 删除链表的节点
 * https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/description/
 */
public class DeleteNode {

    /**
     * 哨兵节点
     *
     * @param head 链表头节点
     * @param val  要删除的值
     * @return
     */
    public static ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while(cur != null) {
            if(cur.next.val == val) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
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
                System.out.print(head.val);
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
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode res = deleteNode(node1, 5);
        print(res);
        // 4 -> 1 -> 9
    }
}
