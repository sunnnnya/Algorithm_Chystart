package job_interview.code_top.single_list;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @BelongsPackage: job_interview.code_top.single_list
 * @ClassName: MergeKLists
 * @Author: 丛虹羽
 * @Date: 2025/5/16 12:44
 * @Description: 合并 K 个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 */
public class MergeKLists {

    /**
     * 优先级队列的使用
     *
     * @param lists 头指针数组
     * @return ListNode
     */
    static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode head : lists) {
            if(head != null) {
                pq.offer(head);
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            if(node.next != null) {
                pq.offer(node.next);
            }
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
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
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node4;
        node4.next = node5;

        ListNode node11 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node44 = new ListNode(4);
        node11.next = node3;
        node3.next = node44;

        ListNode node2 = new ListNode(2);
        ListNode node6 = new ListNode(6);
        node2.next = node6;

        ListNode[] nums = Arrays.asList(node1, node11, node2).stream()
                .toArray(ListNode[]::new);
        ListNode head = mergeKLists(nums);
        print(head);
        // 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
    }
}
