package job_interview.hot100.linked_list;

/**
 * @BelongsPackage: job_interview.hot100.linked_list
 * @ClassName: DetectCycle
 * @Author: 丛虹羽
 * @Date: 2025/7/14 19:39
 * @Description: 环形链表 II
 * https://leetcode.cn/problems/linked-list-cycle-ii/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class DetectCycle {

    /**
     * 链表结构
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
     * 查找第一个入环的节点
     *
     * @param head 链表头结点
     * @return ListNode
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                fast = head;
                while(fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * 测试
     *
     * @param args 参数
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
