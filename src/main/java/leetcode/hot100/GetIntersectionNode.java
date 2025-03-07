package leetcode.hot100;

import leetcode.skill.list.ListNode;

/**
 * @BelongsPackage: leetcode.hot100
 * @ClassName: GetIntersectionNode
 * @Author: 丛虹羽
 * @Date: 2025/3/7 22:58
 * @Description: 相交链表
 *
 * leetcode： https://leetcode.cn/problems/intersection-of-two-linked-lists/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class GetIntersectionNode {

    /**
     * 相交的链表：
     *      找到长链表和短链表的头节点信息
     *      然后长链表走提前走差值长度步数
     *      最后若找到相同节点，即为 终止 最终要么为 null，走到最后相同了，说明不相交，反之找到同一个点了
     *
     * @param headA 链表A的头结点
     * @param headB 链表B的头结点
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int headALength = getListLength(headA);
        int headBLength = getListLength(headB);
        ListNode LHead = headALength > headBLength ? headA : headB;
        ListNode SHead = LHead == headA ? headB : headA;
        int len = Math.abs(headALength - headBLength);
        while(len-- > 0) {
            LHead = LHead.next;
        }
        while(LHead != SHead) {
            LHead = LHead.next;
            SHead = SHead.next;
        }
        return LHead;
    }

    /**
     * 获取链表的长度信息
     *
     * @return 链表的长度
     */
    public static int getListLength(ListNode head) {
        int len = 0;
        for(;head != null; head = head.next) {
            len++;
        }
        return len;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode nodeA = new ListNode(4);
        ListNode nodeB = new ListNode(1);
        ListNode nodeC = new ListNode(8);
        ListNode nodeD = new ListNode(4);
        ListNode nodeE = new ListNode(5);
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;

        ListNode nodeAA = new ListNode(5);
        ListNode nodeBB = new ListNode(6);
        ListNode nodeCC = new ListNode(1);
        nodeAA.next = nodeBB;
        nodeBB.next = nodeCC;
        nodeCC.next = nodeC;

        System.out.println(getIntersectionNode(nodeA, nodeAA).val);
        // 8
    }
}
