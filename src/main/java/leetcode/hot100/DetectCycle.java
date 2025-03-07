package leetcode.hot100;

import leetcode.skill.list.ListNode;

import java.util.HashSet;

/**
 * @BelongsPackage: leetcode.hot100
 * @ClassName: DetectCycle
 * @Author: 丛虹羽
 * @Date: 2025/3/8 00:23
 * @Description: 环形链表 II - chystart
 *
 * leetcode: https://leetcode.cn/problems/linked-list-cycle-ii/?envType=study-plan-v2&envId=top-100-liked
 */
public class DetectCycle {

    /**
     * 哈希表进行判断
     *      哈希表中出现重复的点就为第一个入环节点
     *
     * @param head 链表头节点
     * @return
     */
    public static ListNode detectCycle1(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        while(head != null) {
            if(set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * 快慢指针
     *
     * @param head 链表头结点
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode S = head.next;
        ListNode F = head.next.next;
        while(F != S) {
            if(F.next == null || F.next.next == null) {
                return null;
            }
            S = S.next;
            F = F.next.next;
        }
        F = head;
        while(S != F) {
            S = S.next;
            F = F.next;
        }
        return S;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(detectCycle(node1).val);
        // 2
    }
}
