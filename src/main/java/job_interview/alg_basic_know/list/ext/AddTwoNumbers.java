package job_interview.alg_basic_know.list.ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.list.ext
 * @ClassName: AddTwoNumbers
 * @Author: 丛虹羽
 * @Date: 2025/4/2 14:56
 * @Description: 两数相加 II
 * https://leetcode.cn/problems/lMSNwu/description/?envType=problem-list-v2&envId=G25w0aD1
 */
public class AddTwoNumbers {

    /**
     * 链表基础题
     *
     * @param l1 链表的头节点
     * @param l2 链表的头节点
     * @return   相加之后的头节点
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int lenA = getListLength(l1);
        int lenB = getListLength(l2);
        int total = 0, carry = 0;
        ListNode LHead = lenA > lenB ? l1 : l2;
        ListNode SHead = LHead == l1 ? l2 : l1;
        ListNode pre = null;
        LHead = reverse(LHead);
        SHead = reverse(SHead);
        ListNode newHead = LHead;
        while(SHead != null) {
            total = (SHead.val + LHead.val + carry);
            carry = total / 10;
            LHead.val = total % 10;
            SHead = SHead.next;
            pre = LHead;
            LHead = LHead.next;
        }
        while(LHead != null) {
            total = (LHead.val + carry);
            carry = total / 10;
            LHead.val = total % 10;
            pre = LHead;
            LHead = LHead.next;
        }
        if(carry != 0) {
            ListNode node = new ListNode(carry);
            pre.next = node;
        }
        return reverse(newHead);
    }

    /**
     * 获取链表的长度信息
     *
     * @param head 链表的头节点信息
     * @return 返回链表的长度信息
     */
    private static int getListLength(ListNode head) {
        int len = 0;
        for(;head != null; head = head.next) {
            len++;
        }
        return len;
    }

    /**
     * 反转链表
     *
     * @param head 头节点信息
     * @return 返回反转之后的头节点信息
     */
    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 打印链表信息
     *
     * @param head 头节点
     */
    private static void print(ListNode head) {
        while(head != null) {
            if(head.next == null) {
                System.out.println(head.val);
            } else {
                System.out.print(head.val + " -> ");
            }
            head = head.next;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node1_1 = new ListNode(7);
        ListNode node1_2 = new ListNode(2);
        ListNode node1_3 = new ListNode(4);
        ListNode node1_4 = new ListNode(3);
        node1_1.next = node1_2;
        node1_2.next = node1_3;
        node1_3.next = node1_4;

        ListNode node2_1 = new ListNode(5);
        ListNode node2_2 = new ListNode(6);
        ListNode node2_3 = new ListNode(4);
        node2_1.next = node2_2;
        node2_2.next = node2_3;
        ListNode ans = addTwoNumbers(node1_1, node2_1);
        print(ans);
        // 7 -> 8 -> 0 -> 7
    }
}
