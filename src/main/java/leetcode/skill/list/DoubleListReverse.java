package leetcode.skill.list;

/**
 * @package: leetcode.skill.list
 * @author: chystart
 * @create: 2025-03-09 22:16
 * @description: 双链表的反转
 **/
public class DoubleListReverse {

    /**
     * 双链表的节点
     */
    public static class DoubleListNode {
        public int value;

        public DoubleListNode last;
        public DoubleListNode next;

        public DoubleListNode(int v) {
            value = v;
        }
    }

    /**
     * 反转双链表
     *
     * @param head 链表的头节点
     * @return
     */
    public static DoubleListNode reverseDoubleList(DoubleListNode head) {
        DoubleListNode next = null;
        DoubleListNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 打印双链表信息
     *
     * @param head 链表头节点
     */
    public static void printDoubleList(DoubleListNode head) {
        while(head != null) {
            if(head.next == null) {
                System.out.println(head.value);
            } else {
                System.out.print(head.value + " -> ");
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
        // 链表信息
        DoubleListNode node1 = new DoubleListNode(1);
        DoubleListNode node2 = new DoubleListNode(10);
        DoubleListNode node3 = new DoubleListNode(5);
        DoubleListNode node4 = new DoubleListNode(2);
        DoubleListNode node5 = new DoubleListNode(7);
        node1.last = null;
        node1.next = node2;
        node2.last = node1;
        node2.next = node3;
        node3.last = node2;
        node3.next = node4;
        node4.last = node3;
        node4.next = node5;
        node5.last = node4;
        node5.next = null;
        // 反转链表
        DoubleListNode newDoubleListHead = reverseDoubleList(node1);
        // 打印链表
        printDoubleList(newDoubleListHead);
    }
}
