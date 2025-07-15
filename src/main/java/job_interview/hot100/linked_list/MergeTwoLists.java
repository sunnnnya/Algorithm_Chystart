package job_interview.hot100.linked_list;

/**
 * @BelongsPackage: job_interview.hot100.linked_list
 * @ClassName: MergeTwoLists
 * @Author: 丛虹羽
 * @Date: 2025/7/15 12:13
 * @Description: 合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class MergeTwoLists {

    /**
     * 链表结点
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
     * 合并两个有序链表
     *
     * @param list1 链表头结点1
     * @param list2 链表头结点2
     * @return 合并之后的头结点信息
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur = list1.val <= list2.val ? list1 : list2;
        ListNode ans = cur;
        ListNode cur1 = cur.next;
        ListNode cur2 = cur == list1 ? list2 : list1;
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
        cur.next = cur1 == null ? cur2 : cur1;
        return ans;
    }

    /**
     * 打印链表信息
     *
     * @param head 链表头结点
     */
    public static void printListNode(ListNode head) {
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
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node4;

        ListNode node11 = new ListNode(1);
        ListNode node33 = new ListNode(3);
        ListNode node44 = new ListNode(4);
        node11.next = node33;
        node33.next = node44;

        ListNode mergeListNodeHead = mergeTwoLists(node1, node11);

        printListNode(mergeListNodeHead);
        // 1 -> 1 -> 2 -> 3 -> 4 -> 4
    }
}
