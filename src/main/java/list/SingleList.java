package list;

/**
 * @BelongsPackage: list
 * @ClassName: SingleList
 * @Author: 丛虹羽
 * @Date: 2024/7/22 上午12:34
 * @Description: 单链表
 */
public class SingleList {

    /**
     * 单链表中的节点信息
     */
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 链表的反转
     *
     * @param head
     * @return
     */
    public static ListNode reverseSingleList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 打印单链表
     *
     * @param head
     */
    public static void printSingleListNode(ListNode head) {
        if (head == null) {
            return ;
        }
        while (head != null) {
            if(head.next == null) {
                System.out.print(head.val);
            } else {
                System.out.print(head.val + " -> ");
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode listNodeFive = new ListNode(10, null);
        ListNode listNodeFour = new ListNode(8, listNodeFive);
        ListNode listNodeThree = new ListNode(6, listNodeFour);
        ListNode listNodeTwo= new ListNode(3, listNodeThree);
        ListNode head = new ListNode(2, listNodeTwo);
        printSingleListNode(head);
        // 2 -> 3 -> 6 -> 8 -> 10

        ListNode afterReverseListNewHead = reverseSingleList(head);
        System.out.println();

        printSingleListNode(afterReverseListNewHead);
        // 10 -> 8 -> 6 -> 3 -> 2
    }
}
