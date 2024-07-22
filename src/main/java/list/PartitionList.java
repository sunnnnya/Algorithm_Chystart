package list;

/**
 * @BelongsPackage: list
 * @ClassName: PartitionList
 * @Author: 丛虹羽
 * @Date: 2024/7/22 下午4:47
 * @Description: 分区链表
 * leetcode: https://leetcode.cn/problems/partition-list
 */
public class PartitionList {

    public static class ListNode {
        private Integer val;
        private ListNode next;
        public ListNode(Integer val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 对链表中的数进行分区
     *
     * @param head
     * @return
     */
    public static ListNode partitionList(ListNode head, int num) {
        // lessNumHead和moreNumHead只是记录的作用，具体的拼接使用的是tail
        ListNode lessNumHead = null, lessNumTail = null, moreNumHead = null, moreNumTail = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < num) {
                if (lessNumHead == null) {
                    lessNumHead = head;
                } else {
                    lessNumTail.next = head;
                }
                lessNumTail = head;
            } else {
                if (moreNumHead == null) {
                    moreNumHead = head;
                } else {
                    moreNumTail.next = head;
                }
                moreNumTail = head;
            }
            head = next;
        }
        if (lessNumHead == null) {
            return moreNumHead;
        }
        lessNumTail.next = moreNumHead;
        return lessNumHead;
    }

    /**
     * 打印链表
     *
     * @param head
     */
    public static void printList(ListNode head) {
        while(head != null) {
            if (head.next == null) {
                System.out.print(head.val);
            } else {
                System.out.print(head.val + " -> ");
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode listNodeEight = new ListNode(7, null);
        ListNode listNodeSeven = new ListNode(1, listNodeEight);
        ListNode listNodeSix = new ListNode(1, listNodeSeven);
        ListNode listNodeFive = new ListNode(2, listNodeSix);
        ListNode listNodeFour = new ListNode(4, listNodeFive);
        ListNode listNodeThree = new ListNode(3, listNodeFour);
        ListNode listNodeTwo = new ListNode(5, listNodeThree);
        ListNode head = new ListNode(6, listNodeTwo);
        ListNode newListNode = partitionList(head, 4);
        printList(newListNode);
        // 3 -> 2 -> 1 -> 1 -> 6 -> 5 -> 4 -> 7
    }
}
