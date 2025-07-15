package job_interview.hot100.linked_list;

/**
 * @BelongsPackage: job_interview.hot100.linked_list
 * @ClassName: SortList
 * @Author: 丛虹羽
 * @Date: 2025/7/15 15:19
 * @Description: 排序链表
 * https://leetcode.cn/problems/sort-list/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class SortList {

    /**
     * 链表中的节点
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
     * 进行链表的排序过程
     *
     * @param head 头结点信息
     * @return ListNode
     */
    public static ListNode sortList(ListNode head) {
        // base case
        if(head == null || head.next == null) {
            return head;
        }
        // 获取中间节点
        ListNode midListNode = getMiddleListNode(head);
        // 左右两边分别进行排序操作
        ListNode sortListNodeHead1 = sortList(head);
        ListNode sortListNodeHead2 = sortList(midListNode);
        // 两个有序链表的合并问题
        return mergeListNode(sortListNodeHead1, sortListNodeHead2);
    }

    /**
     * 两个链表的合并过程
     *
     * @param head1 头结点信息
     * @param head2 头结点信息
     * @return 合并之后的头结点信息
     */
    private static ListNode mergeListNode(ListNode head1, ListNode head2) {
        ListNode cur = head1.val <= head2.val ? head1 : head2;
        ListNode head = cur;
        ListNode cur1 = cur.next;
        ListNode cur2 = cur == head1 ? head2 : head1;
        while(cur1 != null && cur2 != null) {
            if(cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        cur.next = cur1 != null ? cur1 : cur2;
        return head;
    }

    /**
     * 返回链表的中间节点，同时把中间节点的 上一个结点.next = null
     *
     * @param head 头结点信息
     * @return ListNode
     */
    private static ListNode getMiddleListNode(ListNode head) {
        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return slow;
    }

    /**
     * 打印链表结点信息
     *
     * @param head 头结点信息
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
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node5.next = node4;
        node4.next = node3;
        node3.next = node1;
        node1.next = node2;

        printListNode(node5);
        // 5 -> 4 -> 3 -> 1 -> 2
        ListNode sortedListNodeHead = sortList(node5);
        printListNode(sortedListNodeHead);
        // 1 -> 2 -> 3 -> 4 -> 5
    }
}
