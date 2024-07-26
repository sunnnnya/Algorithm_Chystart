package basic_knowledge.list.easy;

/**
 * @BelongsPackage: basic_knowledge.list.easy
 * @ClassName: ReverseDoubleList
 * @Author: 丛虹羽
 * @Date: 2024/7/26 下午6:08
 * @Description: 双端链表的逆序
 */
public class ReverseDoubleList {

    /**
     * 双端链表的节点信息
     */
    public static class DoubleNode {
        public int value;
        // 前引用指针
        public DoubleNode last;
        // 后引用指针
        public DoubleNode next;
        public DoubleNode(int data) {
            this.value = data;
        }
    }

    /**
     * 反转双端链表
     *
     * @param head
     * @return
     */
    public static DoubleNode reverseDoubleNode(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            // 和单链表的区别在于last和next指针的调整
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 打印双端链表
     *
     * @param head
     */
    public static void printDoubleNode(DoubleNode head) {
        if (head == null) {
            return;
        }
        while (head != null) {
            if (head.next == null) {
                System.out.print(head.value);
            } else {
                System.out.print(head.value + " -> ");
            }
            head = head.next;
        }
    }


    /**
     * 测试函数
     *
     * @param args
     */
    public static void main(String[] args) {
        DoubleNode doubleNode = new DoubleNode(12);
        DoubleNode doubleNode1 = new DoubleNode(21);
        DoubleNode doubleNode2 = new DoubleNode(11);
        // 12 -> 21 -> 11
        doubleNode.next = doubleNode1;
        doubleNode.last = null;
        doubleNode1.next = doubleNode2;
        doubleNode1.last = doubleNode;
        doubleNode2.next = null;
        doubleNode2.last = doubleNode1;
        DoubleNode newHead = reverseDoubleNode(doubleNode);
        printDoubleNode(newHead);
    }
}
