package job_interview.code_top.single_list;

/**
 * @BelongsPackage: job_interview.code_top.single_list
 * @ClassName: ReorderList
 * @Author: 丛虹羽
 * @Date: 2025/5/16 12:20
 * @Description: 重排链表
 * https://leetcode.cn/problems/reorder-list/description/
 */
public class ReorderList {

    /**
     * 快慢指针 + 反转链表
     *
     * @param head 头结点
     */
    static void reorderList(ListNode head) {
        ListNode mid = getMid(head);
        ListNode head2 = reverse(mid);
        while(head2.next != null) {
            ListNode nxt = head.next;
            ListNode next = head2.next;
            head.next = head2;
            head2.next = nxt;
            head = nxt;
            head2 = next;
        }
    }

    /**
     * 链表的反转
     *
     * @param head 头结点信息
     * @return ListNode
     */
    static ListNode reverse(ListNode head) {
        ListNode next = null;
        ListNode pre = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 获取链表的中间节点
     *
     * @param head 头结点
     * @return ListNode
     */
    static ListNode getMid(ListNode head) {
        ListNode faster = head;
        ListNode slow = head;
        while(faster != null && faster.next != null) {
            faster = faster.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 打印链表
     *
     * @param head 头结点
     */
    static void print(ListNode head) {
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
        print(node1);
        // 1 -> 2 -> 3 -> 4 -> 5
        reorderList(node1);
        print(node1);
        // 1 -> 5 -> 2 -> 4 -> 3
    }
}
