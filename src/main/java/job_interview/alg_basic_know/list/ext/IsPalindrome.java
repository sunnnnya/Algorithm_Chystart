package job_interview.alg_basic_know.list.ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.list.ext
 * @ClassName: IsPalindrome
 * @Author: 丛虹羽
 * @Date: 2025/3/30 23:46
 * @Description: 回文链表
 * https://leetcode.cn/problems/palindrome-linked-list/description/
 */
public class IsPalindrome {

    private static final int MAXN = 100001;

    private static final ListNode[] stack = new ListNode[MAXN];

    private static int r;

    /**
     * 使用栈的方式进行判断
     *
     * @param head 链表的头结点
     * @return
     */
    public static boolean isPalindrome1(ListNode head) {
        r = 0;
        ListNode h = head;
        while(h != null) {
            stack[r++] = h;
            h = h.next;
        }
        while(r > 0) {
            if(stack[--r].val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 直接对链表进行操作
     *
     * @param head 链表的头结点
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        ListNode h = head;
        ListNode originHead = head;
        ListNode midListNode = getMiddleListNode(head);
        ListNode reverseNode = reverseListNode(midListNode);
        ListNode originalReverseNode = reverseNode;
        while(reverseNode != null) {
            if(originHead.val != reverseNode.val) {
                // fail: recover List
                reverseListNode(originalReverseNode);
                printListNode(h);
                return false;
            }
            originHead = originHead.next;
            reverseNode = reverseNode.next;
        }
        // success: recover List
        reverseListNode(originalReverseNode);
        printListNode(h);
        return true;
    }

    /**
     * 获取链表的中点:
     *  快慢指针
     *
     * @param head 链表的头结点
     * @return 链表中间节点
     */
    public static ListNode getMiddleListNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 反转链表
     *
     * @param head 链表的头结点
     * @return 反转后的头节点
     */
    public static ListNode reverseListNode(ListNode head) {
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
     * @param head 头节点信息
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
     * @param args
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(isPalindrome(node1));
        // false
    }
}
