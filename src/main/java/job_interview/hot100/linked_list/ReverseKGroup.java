package job_interview.hot100.linked_list;

/**
 * @BelongsPackage: job_interview.hot100.linked_list
 * @ClassName: ReverseKGroup
 * @Author: 丛虹羽
 * @Date: 2025/7/15 13:33
 * @Description: K 个一组翻转链表
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class ReverseKGroup {

    /**
     * 链表结点
     */
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    /**
     * k 维一组翻转链表
     *
     * @param head 头结点
     * @return ListNode
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        int len = len(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        for(int i = 0; i < len / k; i++) {
            ListNode[] p = reverseListNode(cur.next, k);
            ListNode tail = cur.next;
            tail.next = p[1];
            cur.next = p[0];
            cur = tail;
        }
        return dummy.next;
    }

    /**
     * 使用 for 循环进行链表的反转
     *
     * @param head 链表的头结点
     * @return ListNode[pre, next]
     */
    private static ListNode[] reverseListNode(ListNode head, int k) {
        ListNode next = null;
        ListNode pre = null;
        for(int i = 0; i < k; i++) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return new ListNode[]{pre, head};
    }

    /**
     * 获取链表的长度信息
     *
     * @param head 链表的头结点
     * @return int
     */
    private static int len(ListNode head) {
        int len = 0;
        for(; head != null; head = head.next, len++);
        return len;
    }

    /**
     * 打印链表信息
     *
     * @param head 头结点
     */
    public static void printListNode(ListNode head) {
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
     * @param args 参数
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

        printListNode(node1);
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode reverseListNode = reverseKGroup(node1, 2);
        printListNode(reverseListNode);
        // 2 -> 1 -> 4 -> 3 -> 5
    }
}
