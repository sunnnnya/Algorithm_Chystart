package job_interview.code_top.single_list;

/**
 * @BelongsPackage: job_interview.code_top.single_list
 * @ClassName: DeleteDuplicatesII
 * @Author: 丛虹羽
 * @Date: 2025/5/12 14:25
 * @Description: 删除排序链表中的重复元素 II
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/
 */
public class DeleteDuplicatesII {

    /**
     * 可能删除头结点，使用 dummyNode
     *
     * @param head 头结点
     * @return
     */
    static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null) {
            int val = cur.next.val;
            if(cur.next.next.val == val) {
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    /**
     * 打印链表信息
     *
     * @param head 链表头节点
     */
    static void print(ListNode head) {
        while(head != null) {
            if (head.next == null) {
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
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        print(node1);
        deleteDuplicates(node1);
        print(node1);
    }
}
