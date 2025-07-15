package job_interview.hot100.linked_list;

/**
 * @BelongsPackage: job_interview.hot100.linked_list
 * @ClassName: AddTwoNumbers
 * @Author: 丛虹羽
 * @Date: 2025/7/15 12:37
 * @Description: 两数相加
 * https://leetcode.cn/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    /**
     * 添加两数之和
     *
     * @param l1 链表头结点1
     * @param l2 链表头结点2
     * @return ListNode
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = len(l1);
        int len2 = len(l2);
        ListNode lhead = len1 > len2 ? l1 : l2;
        ListNode shead = lhead == l1 ? l2 : l1;
        ListNode pre = lhead;
        ListNode ans = lhead;
        int carry = 0;
        while(lhead != null && shead != null) {
            int total = lhead.val + shead.val + carry;
            lhead.val = total % 10;
            carry = total / 10;
            pre = lhead;
            lhead = lhead.next;
            shead = shead.next;
        }
        while(lhead != null) {
            int total = lhead.val + carry;
            lhead.val = total % 10;
            carry = total / 10;
            pre = lhead;
            lhead = lhead.next;
        }
        if(carry != 0) {
            pre.next = new ListNode(carry);
        }
        return ans;
    }

    /**
     * 获取链表的长度
     *
     * @param head 链表的头结点信息
     * @return int
     */
    private static int len(ListNode head) {
        int len = 0;
        for(; head != null; head = head.next, len++);
        return len;
    }

    /**
     * 打印链表
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
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node2.next = node4;
        node4.next = node3;

        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node44 = new ListNode(4);
        node5.next = node6;
        node6.next =  node44;

        printListNode(addTwoNumbers(node2, node5));
        // 7 -> 0 -> 8
    }
}
