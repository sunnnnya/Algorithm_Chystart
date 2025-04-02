package job_interview.alg_basic_know.list.ext;

import java.util.HashSet;

/**
 * @BelongsPackage: job_interview.alg_basic_know.list.ext
 * @ClassName: DetectCycle
 * @Author: 丛虹羽
 * @Date: 2025/4/2 16:08
 * @Description: 环形链表 II
 * https://leetcode.cn/problems/c32eOV/description/?envType=problem-list-v2&envId=G25w0aD1
 */
public class DetectCycle {

    /**
     * 哈希表:
     *  空间复杂度O(n)
     *
     * @param head 链表头节点
     * @return 返回第一个入环节点
     */
    public static ListNode detectCycle1(ListNode head) {
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
     * 快慢指针的使用
     *  空间复杂度：O(1)
     *
     * @param head 链表头节点
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode faster = head;
        ListNode slower = head;
        while(faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;
            if(faster == slower) {
                faster = head;
                while(faster != slower) {
                    faster = faster.next;
                    slower = slower.next;
                }
                return slower;
            }
        }
        return null;
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

        ListNode node5 = new ListNode(1);
        System.out.println(detectCycle(node5) == null ? detectCycle(node5) : detectCycle(node5).val);
        // null
    }
}
