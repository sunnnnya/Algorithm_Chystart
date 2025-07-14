package job_interview.hot100.linked_list;

/**
 * @BelongsPackage: job_interview.hot100.linked_list
 * @ClassName: IsPalindrome
 * @Author: 丛虹羽
 * @Date: 2025/7/14 19:23
 * @Description: 回文链表
 * https://leetcode.cn/problems/palindrome-linked-list/?envType=study-plan-v2&envId=top-100-liked
 */
public class IsPalindrome {

    /**
     * 链表结点信息
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
     * 获取链表的判断
     *
     * @param head 头结点
     * @return true | false
     */
    public static boolean isPalindrome(ListNode head) {
        ListNode midNode = getMidNode(head);
        ListNode reverseNode = reverse(midNode);
        while(reverseNode != null) {
            if(reverseNode.val != head.val) {
                return false;
            }
            reverseNode = reverseNode.next;
            head = head.next;
        }
        return true;
    }

    /**
     * 进行链表的反转
     *
     * @param head 头结点
     * @return ListNode
     */
    public static ListNode reverse(ListNode head) {
        ListNode next = null;
        ListNode pre = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 获取链表中点位置
     *
     * @param head 头结点
     * @return ListNode
     */
    private static ListNode getMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(isPalindrome(node1));
        // true
    }
}
