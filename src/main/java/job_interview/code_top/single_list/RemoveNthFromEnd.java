package job_interview.code_top.single_list;

import job_interview.alg_basic_know.list.ext.ListNode;

/**
 * @BelongsPackage: job_interview.code_top.single_list
 * @ClassName: RemoveNthFromEnd
 * @Author: 丛虹羽
 * @Date: 2025/4/15 00:30
 * @Description: 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd {

    /**
     * 使用哨兵节点减少条件判断
     *
     * @param head 链表的头节点
     * @param n    N 序号
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 注意：要和 head 进行连接，需要删除头结点的时候才需要 dummy
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        int l = len(head);
        for(int i = 0; i < l - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    /**
     * 获取数组长度
     *
     * @param head 链表头节点
     * @return
     */
    private static int len(ListNode head) {
        int len = 0;
        for(; head != null; head = head.next) {
            len++;
        }
        return len;
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
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode res = removeNthFromEnd(node1, 2);
        print(res);
        // 1 -> 2 -> 3 -> 5
    }
}
