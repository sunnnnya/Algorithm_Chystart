package job_interview.code_top.single_list;

import job_interview.alg_basic_know.list.ext.ListNode;

/**
 * @BelongsPackage: job_interview.code_top.single_list
 * @ClassName: DeleteDuplicates
 * @Author: 丛虹羽
 * @Date: 2025/5/12 14:09
 * @Description: 删除排序链表中的重复元素
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
 */
public class DeleteDuplicates {

    /**
     * 删除节点信息
     *
     * @param head 头结点
     * @return ListNode
     */
    static ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode cur = head;
        while(cur.next != null) {
            // 跳过一个节点
            if(cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                // 正常移动
                cur = cur.next;
            }
        }
        return head;
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
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        print(node1);
        deleteDuplicates(node1);
        print(node1);
    }
}
