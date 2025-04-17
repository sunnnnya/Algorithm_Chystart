package job_interview.alg_basic_know.list.ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.list.ext
 * @ClassName: SwapNodes
 * @Author: 丛虹羽
 * @Date: 2025/4/17 21:05
 * @Description: 交换链表中的节点
 * https://leetcode.cn/problems/swapping-nodes-in-a-linked-list/description/
 */
public class SwapNodes {

    /**
     * 链表转换成数组进行交换，再转换成链表
     *
     * @param head 链表的头节点
     * @param k    第 k 位
     * @return
     */
    public static ListNode swapNodes1(ListNode head, int k) {
        int len = getLength(head);
        int[] nums = new int[len];
        process(nums, head);
        swap(nums, k - 1, len - k);
        return makeArrayUseList(nums);
    }

    /**
     * 使用数组制作链表进行返回
     *
     * @param nums 原始数组
     * @return
     */
    private static ListNode makeArrayUseList(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for(int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }

    /**
     * 链表转换成数组
     *
     * @param nums 原始数组
     * @param head 链表的头节点
     */
    private static void process(int[] nums, ListNode head) {
        int idx = 0;
        while(head != null) {
            nums[idx++] = head.val;
            head = head.next;
        }
    }

    /**
     * 交换数组中指定 index 位置的元素
     *
     * @param nums 原始数组
     * @param i    i index
     * @param j    j index
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 获取数组的长度
     *
     * @param head 链表的头节点
     * @return
     */
    private static int getLength(ListNode head) {
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
     * 使用链表进行处理
     *
     * @param head 头节点
     * @param k    k 位数值
     * @return
     */
    public static ListNode swapNodes(ListNode head, int k) {
        int len = getLength(head);
        if(len == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode leftAheadListNode = getKthListNode(dummy, k - 1); // 1
        ListNode rightAheadListNode = getKthListNode(dummy, len - k); // 3
        ListNode leftRightListNode = leftAheadListNode.next.next; // 3
        ListNode rightRightLisTNode = rightAheadListNode.next.next; // 5
        leftAheadListNode.next = rightAheadListNode.next;
        leftAheadListNode.next.next = leftRightListNode;
        rightAheadListNode.next = leftAheadListNode.next;
        rightAheadListNode.next.next = rightRightLisTNode;
        return dummy.next;
    }

    /**
     * 获取 K 位对应的节点信息
     *
     * @param head 头节点信息
     * @param k    k 位
     * @return     kth ListNode
     */
    private static ListNode getKthListNode(ListNode head, int k) {
        for(int i = 0; i < k; i++) {
            head = head.next;
        }
        return head;
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
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        printListNode(node1);
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode res = swapNodes(node1, 2);
        printListNode(res);
        // 1 -> 4 -> 3 -> 2 -> 5
    }
}
