package job_interview.hot100.linked_list;

/**
 * @BelongsPackage: job_interview.hot100.linked_list
 * @ClassName: SwapPairs
 * @Author: 丛虹羽
 * @Date: 2025/7/15 13:13
 * @Description: 两两交换链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class SwapPairs {

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
     * K 维数组反转
     *
     * @param head 链表头结点
     * @return ListNode
     */
    public static ListNode swapPairs(ListNode head) {
        int k = 2;
        int len = len(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        for(int i = 0; i < len / k; i++) {
            ListNode[] p = reverse(cur.next, k);
            ListNode tail = cur.next;
            cur.next = p[0];
            tail.next = p[1];
            cur = tail;
        }
        return dummy.next;
    }

    /**
     * 指定 k 个一组进行翻转
     *
     * @param head 链表头结点
     * @param k k 个一组
     * @return ListNode[]
     */
    private static ListNode[] reverse(ListNode head, int k) {
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
     * 获取当前链表的长度信息
     *
     * @param head 头结点
     * @return 链表长度
     */
    private static int len(ListNode head) {
        int len = 0;
        for(; head != null; head = head.next, len++);
        return len;
    }

    /**
     * 打印链表信息
     *
     * @param head 链表头信息
     */
    private static void printLinkedList(ListNode head) {
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

        printLinkedList(node1);
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode listNode = swapPairs(node1);
        printLinkedList(listNode);
        // 2 -> 1 -> 4 -> 3 -> 5
    }
}
