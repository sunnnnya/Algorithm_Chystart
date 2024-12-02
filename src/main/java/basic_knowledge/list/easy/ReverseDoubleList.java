package basic_knowledge.list.easy;

import basic_knowledge.list.common.DoubleNode;

/**
 * @BelongsPackage: basic_knowledge.list.easy
 * @ClassName: ReverseDoubleList
 * @Author: 丛虹羽
 * @Date: 2024/7/26 下午6:08
 * @Description: 双端链表的逆序
 */
public class ReverseDoubleList {

    /**
     * 双链表的反转 - 和单链表的反转的区别只是多了一个 last 的指向
     *
     * @param head
     * @return
     */
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode next = null;
        DoubleNode pre = null;
        while(head != null) {
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
     * @param head
     */
    public static void printDoubleList(DoubleNode head) {
        while (head != null) {
            if (head.next == null) {
                System.out.print(head.data);
            } else {
                System.out.print(head.data + " -> ");
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
        DoubleNode doubleNode1 = new DoubleNode(12);
        DoubleNode doubleNode2 = new DoubleNode(2);
        DoubleNode doubleNode3 = new DoubleNode(1);
        DoubleNode doubleNode4 = new DoubleNode(4);
        DoubleNode doubleNode5 = new DoubleNode(8);
        doubleNode1.last = null;
        doubleNode1.next = doubleNode2;
        doubleNode2.last = doubleNode1;
        doubleNode2.next = doubleNode3;
        doubleNode3.last = doubleNode2;
        doubleNode3.next = doubleNode4;
        doubleNode4.last = doubleNode3;
        doubleNode4.next = doubleNode5;
        doubleNode5.last = doubleNode4;
        doubleNode5.next = null;
        System.out.print("原始链表：");
        printDoubleList(doubleNode1);

        System.out.println();

        System.out.print("反转后的链表：");
        printDoubleList(reverseDoubleList(doubleNode1));
    }
}