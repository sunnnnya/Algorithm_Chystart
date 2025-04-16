package job_interview.alg_basic_know.list.ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.list.ext
 * @ClassName: SwapPairs
 * @Author: 丛虹羽
 * @Date: 2025/4/16 21:51
 * @Description:  两两交换链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class SwapPairs {

    /**
     * 反转链表
     *
     * @param head 链表头节点
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        int len = getListLength(head);
        for(int i = 0; i < len / 2; i++) {
            ListNode p0 = cur.next;
            ListNode[] res = reverse(p0, 2);
            cur.next.next = res[1];
            cur.next = res[0];
            cur = p0;
        }
        return dummy.next;
    }

    /**
     * 反转链表
     *
     * @param head 链表头节点
     * @param k    指定步长
     * @return
     */
    private static ListNode[] reverse(ListNode head, int k) {
        ListNode pre = null;
        ListNode next = null;
        for(int i = 0; i < k; i++) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return new ListNode[]{pre, head};
    }

    /**
     * 获取数组的长度
     *
     * @param head 链表头节点
     * @return
     */
    private static int getListLength(ListNode head) {
        int len = 0;
        for(; head != null; head = head.next) {
            len++;
        }
        return len;
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
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode res = swapPairs(node1);
        printListNode(res);
        // 2 -> 1 -> 4 -> 3
    }
}
