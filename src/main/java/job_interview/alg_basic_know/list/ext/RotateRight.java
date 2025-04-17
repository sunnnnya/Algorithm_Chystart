package job_interview.alg_basic_know.list.ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.list.ext
 * @ClassName: RotateRight
 * @Author: 丛虹羽
 * @Date: 2025/4/17 11:55
 * @Description: 旋转链表
 * https://leetcode.cn/problems/rotate-list/description/
 */
public class RotateRight {

    /**
     * 旋转链表
     *  一定要特判
     *
     * @param head 链表头节点
     * @param k    k 对
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        int len = getLength(head);
        if(k % len == 0 || k == 0 || len == 1) {
            return head;
        }
        ListNode[] p = reverse(cur.next, len);
        cur.next.next = p[1];
        cur.next = p[0];
        printListNode(dummy.next);
        k %= len;
        ListNode[] p1 = reverse(cur.next, k);
        ListNode nx = cur.next;
        cur.next.next = p1[1];
        cur.next = p1[0];
        printListNode(dummy.next);
        cur = nx;
        ListNode[] p2 = reverse(cur.next, len - k);
        cur.next.next = p2[1];
        cur.next = p2[0];
        printListNode(dummy.next);
        return dummy.next;
    }

    /**
     * 获取链表长度信息
     *
     * @param head 链表头节点
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
     * 反转链表
     *
     * @param head 链表头节点
     * @param k    k 对
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
     * @param head 头节点信息
     */
    private static void printListNode(ListNode head) {
        while(head != null) {
            if(head.next == null) {
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
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        rotateRight(node1, 2);
    }
}
