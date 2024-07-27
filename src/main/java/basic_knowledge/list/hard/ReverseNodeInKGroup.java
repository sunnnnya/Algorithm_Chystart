package basic_knowledge.list.hard;

/**
 * @BelongsPackage: basic_knowledge.list.hard
 * @ClassName: ReverseNodeInKGroup
 * @Author: 丛虹羽
 * @Date: 2024/7/27 上午11:46
 * @Description: 链表的k组反转 未完成
 */
public class ReverseNodeInKGroup {

    public static class ListNode  {
        int value;
        ListNode next;
        public ListNode(int value) {
            this.value = value;
        }
    }

    /**
     * 返回k组中的最后一个节点个数
     *
     * @param start
     * @param k
     * @return
     */
    public static ListNode getKGroupEnd(ListNode start, int k) {
        // 使用k进行限制是，节点充足时候，隔k个返回
        // 使用start进行限制是，当节点数小于k时，使用start进行停止
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    /**
     * 反转链表
     *
     * @param start
     * @param end
     */
    public static void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    /**
     * 对链表中k个一组进行反转返回
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKGroupEnd(head, k);
        if (end == null) {
            // 直接返回
            return head;
        }
        // 返回反转之后的新的头部
        head = end;
        reverse(start, end);
        // 上一组的结尾节点
        ListNode lastEnd = start;
        while(lastEnd.next != null) {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    /**
     * 进行测试
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}
