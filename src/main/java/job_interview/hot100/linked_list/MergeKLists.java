package job_interview.hot100.linked_list;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @BelongsPackage: job_interview.hot100.linked_list
 * @ClassName: MergeKLists
 * @Author: 丛虹羽
 * @Date: 2025/7/15 15:50
 * @Description: 合并 K 个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class MergeKLists {

    /**
     * 链表结点信息
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
     * 使用 优先队列 完成合并链表的操作
     *
     * @param lists 多个链表的头结点集合
     * @return 合并之后的链表头结点
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((list1, list2) -> {
            return list1.val - list2.val;
        });
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for(ListNode headNode : lists) {
            if(headNode != null) {
                queue.offer(headNode);
            }
        }
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            if(node.next != null) {
                queue.offer(node.next);
            }
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 打印链表信息
     *
     * @param head 链表头结点信息
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
        ListNode node11 = new ListNode(1);
        ListNode node14 = new ListNode(4);
        ListNode node15 = new ListNode(5);
        node11.next = node14;
        node14.next = node15;

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);
        node21.next = node22;
        node22.next = node23;

        ListNode node31 = new ListNode(2);
        ListNode node32 = new ListNode(6);
        node31.next = node32;

        ListNode[] lists = new ListNode[]{node11, node21, node31};
        ListNode mergeKListNode = mergeKLists(lists);

        printListNode(mergeKListNode);
        // 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
    }
}
