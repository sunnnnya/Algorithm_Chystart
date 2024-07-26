package basic_knowledge.list.easy;

/**
 * @BelongsPackage: basic_knowledge.list
 * @ClassName: MergeTwoLists
 * @Author: 丛虹羽
 * @Date: 2024/7/22 下午3:40
 * @Description:    两个有序链表的合并
 *      leetcode: https://leetcode.cn/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
    /**
     * 单链表中的节点信息
     */
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 合并两个有序链表
     *
     * @return
     */
    public static ListNode mergeTwoOrderedList(ListNode head1, ListNode head2) {
        // 出现一个链表head直接为null，则直接返回另一个链表的头部
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        // 找到值最小的头节点
        ListNode head = head1.val <= head2.val ? head1 : head2;
        ListNode cur1 = head.next;
        ListNode cur2 = head == head1 ? head2 : head1;
        ListNode pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        // 出现遍历完一个链表直接拼接
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }

    /**
     * 打印单链表的信息
     * @param head
     */
    public static void printList(ListNode head) {
        while(head != null) {
            if(head.next == null) {
                System.out.print(head.val);
            } else {
                System.out.print(head.val + " -> ");
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode listNodeFive = new ListNode(10, null);
        ListNode listNodeFour = new ListNode(8, listNodeFive);
        ListNode listNodeThree = new ListNode(6, listNodeFour);
        ListNode listNodeTwo= new ListNode(3, listNodeThree);
        ListNode head = new ListNode(2, listNodeTwo);

        ListNode listNode1Five = new ListNode(81, null);
        ListNode listNode1Four = new ListNode(80, listNode1Five);
        ListNode listNode1Three = new ListNode(75, listNode1Four);
        ListNode listNode1Two= new ListNode(7, listNode1Three);
        ListNode head1 = new ListNode(2, listNode1Two);

        ListNode listNode = mergeTwoOrderedList(head, head1);

        printList(listNode);
        // 2 -> 2 -> 3 -> 6 -> 7 -> 8 -> 10 -> 75 -> 80 -> 81
    }
}
