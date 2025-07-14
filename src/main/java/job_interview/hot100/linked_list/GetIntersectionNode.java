package job_interview.hot100.linked_list;

/**
 * @BelongsPackage: job_interview.hot100.linked_list
 * @ClassName: GetIntersectionNode
 * @Author: 丛虹羽
 * @Date: 2025/7/14 17:22
 * @Description: 相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/?envType=study-plan-v2&envId=top-100-liked
 */
public class GetIntersectionNode {

    /**
     * 自定义链表结点
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
     * 求出来相交的节点信息
     *
     * @param headA 链表头结点 A
     * @param headB 链表头结点 B
     * @return 相交的链表的节点
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = len(headA);
        int lenB = len(headB);
        ListNode headL = lenA >= lenB ? headA : headB;
        ListNode headS = headL == headA ? headB : headA;
        for(int i = 0; i < Math.abs(lenA - lenB); i++) {
            headL = headL.next;
        }
        while(headL != headS) {
            headL = headL.next;
            headS = headS.next;
        }
        return headL;
    }

    /**
     * 获取链表的长度信息
     *
     * @param head 链表的头结点
     * @return 获取链表的长度信息
     */
    private static int len(ListNode head) {
        int len = 0;
        for(; head != null; head = head.next, len++);
        return len;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        // 构造数据
        ListNode node4 = new ListNode(4);
        ListNode node1 = new ListNode(1);
        ListNode node8 = new ListNode(8);
        ListNode node44 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node4.next = node1;
        node1.next = node8;
        node8.next = node44;
        node44.next = node5;

        ListNode node55 = new ListNode(5);
        ListNode node6 = new ListNode(5);
        ListNode node11 = new ListNode(5);

        node55.next = node6;
        node6.next = node11;
        node11.next = node8;

        System.out.println(getIntersectionNode(node4, node55).val);
        // 8
    }
}
