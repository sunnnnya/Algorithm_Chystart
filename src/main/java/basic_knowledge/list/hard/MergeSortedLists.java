package basic_knowledge.list.hard;

import java.util.PriorityQueue;

/**
 * @BelongsPackage: basic_knowledge.list.hard
 * @ClassName: MergeSortedLists
 * @Author: 丛虹羽
 * @Date: 2024/7/27 下午11:31
 * @Description: 合并三个排好序的链表，按照从小到大进行返回
 * leetcode: https://leetcode.cn/problems/merge-k-sorted-lists/
 */
public class MergeSortedLists {

    /**
     * 节点的结构
     */
    public static class ListNode  {
        int value;
        ListNode next;
        public ListNode(int value) {
            this.value = value;
        }
    }

    /**
     * 合并链表头部组成的数组，按照从小到大进行返回一个头部，从小到大进行排序
     *
     * @param listNodes 一个LiseNode组成的数组，里面存放的都是链表的头部的节点信息
     * @return
     */
    public static ListNode mergeKLists(ListNode[] listNodes) {
        if(listNodes == null || listNodes.length == 0) {
            return null;
        }
        // 定义小根堆，表示优先级队列中的元素是从小到大进行排列的
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        // init
        for (ListNode listNode : listNodes) {
            if (listNodes != null) {
                priorityQueue.add(listNode);
            }
        }
        if (priorityQueue.isEmpty()) {
            return null;
        }
        ListNode head = priorityQueue.poll();
        ListNode pre = head;
        if (pre.next != null) {
            priorityQueue.add(pre.next);
        }
        while (!priorityQueue.isEmpty()) {
            ListNode top = priorityQueue.poll();
            // 链表的拼接
            pre.next = top;
            // 链表的移动
            pre = top;
            // 长短链表不同，不加入null
            if (top.next != null ) {
                priorityQueue.add(top.next);
            }
        }
        return head;
    }

    /**
     * 打印链表信息
     *
     * @param head
     */
    public static void printListNode(ListNode head) {
        if (head == null) {
            return ;
        }
        while (head != null) {
            if (head.next == null) {
                System.out.print(head.value);
            } else {
                System.out.print(head.value + " -> ");
            }
            head = head.next;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(12);
        ListNode listNode2 = new ListNode(14);
        ListNode listNode3 = new ListNode(17);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(11);
        ListNode listNode6 = new ListNode(13);
        ListNode listNode7 = new ListNode(15);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        ListNode listNode8 = new ListNode(0);
        ListNode listNode9 = new ListNode(99);
        listNode8.next = listNode9;

        ListNode[] heads = {listNode, listNode4, listNode8};
        ListNode head = mergeKLists(heads);
        printListNode(head);
        // 0 -> 1 -> 2 -> 11 -> 12 -> 13 -> 14 -> 15 -> 17 -> 99
    }
}
