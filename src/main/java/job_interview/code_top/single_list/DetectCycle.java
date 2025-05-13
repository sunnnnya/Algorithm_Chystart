package job_interview.code_top.single_list;

/**
 * @BelongsPackage: job_interview.code_top.single_list
 * @ClassName: DetectCycle
 * @Author: 丛虹羽
 * @Date: 2025/5/13 22:04
 * @Description: 环形链表 II
 * https://leetcode.cn/problems/linked-list-cycle-ii/description/
 */
public class DetectCycle {

    /**
     * 快慢指针
     *
     * @param head 头结点
     * @return ListNode
     */
    static ListNode detectCycle(ListNode head) {
        ListNode faster = head;
        ListNode slow = head;
        while(faster != null && faster.next != null) {
            faster = faster.next.next;
            slow = slow.next;
            if(faster == slow) {
                faster = head;
                while(faster != slow) {
                    faster = faster.next;
                    slow = slow.next;
                }
                return faster;
            }
        }
        return null;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node3.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2;
        System.out.println(detectCycle(node3).val);
        // 2
    }
}
