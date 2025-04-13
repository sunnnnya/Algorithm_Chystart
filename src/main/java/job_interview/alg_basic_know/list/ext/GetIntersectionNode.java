package job_interview.alg_basic_know.list.ext;

import java.util.HashSet;

/**
 * @BelongsPackage: job_interview.alg_basic_know.list.ext
 * @ClassName: GetIntersectionNode
 * @Author: 丛虹羽
 * @Date: 2025/4/13 22:49
 * @Description: 相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
 */
public class GetIntersectionNode {

    /**
     * 相交链表
     *  —— O(N) 空间复杂度
     *  —— stack
     *
     * @param headA 链表头节点A
     * @param headB 链表头节点A
     * @return
     */
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        while(headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while(headB != null) {
            if(set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 相交链表
     *  —— O(1) 空间复杂度
     *
     * @param headA 链表头节点A
     * @param headB 链表头节点A
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int lenA = len(headA);
        int lenB = len(headB);
        ListNode LHead = lenA > lenB ? headA : headB;
        ListNode SHead = LHead == headA ? headB : headA;
        int len = Math.abs(lenA - lenB);
        while(--len >= 0) {
            LHead = LHead.next;
        }
        while(SHead != null) {
            if(SHead == LHead) {
                return SHead;
            }
            SHead = SHead.next;
            LHead = LHead.next;
        }
        return null;
    }

    /**
     * 获取数组的长度
     *
     * @param head 链表的头节点
     * @return
     */
    private static int len(ListNode head) {
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node6 = new ListNode(3);
        node6.next = node4;
        ListNode ans = getIntersectionNode(node1, node6);
        System.out.println("相交节点信息：" + (ans == null ? "null" : ans.val));
    }
}
