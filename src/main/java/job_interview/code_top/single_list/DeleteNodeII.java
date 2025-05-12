package job_interview.code_top.single_list;


/**
 * @BelongsPackage: job_interview.code_top.single_list
 * @ClassName: DeleteNodeII
 * @Author: 丛虹羽
 * @Date: 2025/5/12 13:49
 * @Description: 删除链表中的节点
 * https://leetcode.cn/problems/delete-node-in-a-linked-list/description/
 */
public class DeleteNodeII {

    /**
     * 删除指定节点内容:题目保证给定的节点不是最后一个结点不会出现 NPE
     *  思想：首先先将当前要删除节点的值赋值为下一个结点的内容，然后删除下一个结点，这样就等于删除了当前节点
     *
     * @param node 节点内容
     */
    static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    static void printListNode(ListNode head) {
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
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(10);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        printListNode(node1);
        deleteNode(node3);
        printListNode(node1);
    }
}
