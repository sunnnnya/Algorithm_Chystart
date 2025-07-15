package job_interview.hot100.linked_list;

/**
 * @BelongsPackage: job_interview.hot100.linked_list
 * @ClassName: RemoveNthFromEnd
 * @Author: 丛虹羽
 * @Date: 2025/7/15 12:57
 * @Description: 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class RemoveNthFromEnd {

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
     * 删除链表中倒数第 n 个结点
     *
     * @param head 头结点
     * @param n 倒数 n 位
     * @return ListNode
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        int len = len(head);
        for(int i = 0; i < len - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    /**
     * 获取链表的长度信息
     *
     * @param head 头结点
     * @return 长度信息
     */
    private static int len(ListNode head) {
        int len = 0;
        for(; head != null; head = head.next, len++);
        return len;
    }

    /**
     * 打印链表信息
     *
     * @param head 链表头结点
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

        ListNode listNode = removeNthFromEnd(node1, 2);
        printListNode(listNode);
        // 1 -> 2 -> 3 -> 5
    }
}
