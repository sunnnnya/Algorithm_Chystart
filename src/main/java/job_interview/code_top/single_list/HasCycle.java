package job_interview.code_top.single_list;

/**
 * @BelongsPackage: job_interview.code_top.single_list
 * @ClassName: HasCycle
 * @Author: 丛虹羽
 * @Date: 2025/5/15 10:56
 * @Description: 环形链表
 * https://leetcode.cn/problems/linked-list-cycle/description/
 */
public class HasCycle {

    /**
     * 快慢指针的使用
     *
     * @param head 头结点
     * @return boolean
     */
    static boolean hasCycle(ListNode head) {
        ListNode faster = head;
        ListNode slow = head;
        while(faster != null && faster.next != null) {
            faster = faster.next.next;
            slow = slow.next;
            if(faster == slow) {
                return true;
            }
        }
        return false;
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
        System.out.println(hasCycle(node3));
        // true
    }
}
