package basic_knowledge.list.hard;

/**
 * @BelongsPackage: basic_knowledge.list.easy
 * @ClassName: LinkedListAddition
 * @Author: 丛虹羽
 * @Date: 2024/7/27 下午2:30
 * @Description: 链表的相加
 */
public class LinkedListAddition {

    /**
     * 单链表的结构信息
     */
    public static class ListNode  {
        int value;
        ListNode next;
        public ListNode(int value) {
            this.value = value;
        }
    }

    /**
     * 求链表的长度
     *
     * @param head
     * @return
     */
    public static int listLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public static ListNode addTwoNumber(ListNode head1, ListNode head2) {
        int len1 = listLength(head1);
        int len2 = listLength(head2);
        // 长链表的头部
        ListNode lHead = len1 >= len2 ? head1 : head2;
        // 短链表的头部
        ListNode sHead = (lHead == head1) ? head2 : head1;
        // 暂存起来
        ListNode curL = lHead;
        ListNode curS = sHead;
        int carry = 0; // 进位信息
        int curSum = 0; // 两位数 + 进位信息
        ListNode last = curL;
        // 长短链表同时遍历
        while(curL != null && curS != null) {
            curSum = (curL.value + curS.value) + carry;
            curL.value = curSum % 10;
            carry = curSum / 10;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        // 短链表遍历完了
        while(curL != null) {
            curSum = curL.value + carry;
            curL.value = curSum % 10;
            carry = curSum / 10;
            last = curL;
            curL = curL.next;
        }
        // 长链表遍历完了
        if (carry != 0) {
            ListNode tail = new ListNode(carry);
            last.next = tail;
        }
        return lHead;
    }

    /**
     * 打印链表
     *
     * @param newHead
     */
    private static void printListNode(ListNode newHead) {
        while (newHead != null) {
            if (newHead.next == null) {
                System.out.print(newHead.value);
            } else {
                System.out.print(newHead.value + " -> ");
            }
            newHead = newHead.next;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 长链表
        ListNode listNode0 = new ListNode(8);
        ListNode listNode1 = new ListNode(7);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(9);
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        // 短链表
        ListNode listNode4 = new ListNode(8);
        ListNode listNode5 = new ListNode(7);
        ListNode listNode6 = new ListNode(5);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode newHead = addTwoNumber(listNode0, listNode4);
        printListNode(newHead);
        // 6 -> 5 -> 1 -> 3
    }
}
