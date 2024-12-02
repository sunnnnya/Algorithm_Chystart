package basic_knowledge.list.easy;

import basic_knowledge.list.common.Node;

/**
 * @BelongsPackage: basic_knowledge.list
 * @ClassName: ReverseSingleList
 * @Author: 丛虹羽
 * @Date: 2024/12/2 上午12:34
 * @Description: 单链表的反转
 */
public class ReverseSingleList {

    /**
     * 链表的反转
     *
     * @param head
     * @return
     */
    public static Node reverseSingleList(Node head) {
        Node next = null;
        Node pre = null;
        while(head != null) {
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
    public static void printSingleList(Node head) {
        while (head != null) {
            if (head.next == null) {
                System.out.print(head.val);
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
        Node node1 = new Node(1);
        Node node2 = new Node(6);
        Node node3 = new Node(7);
        Node node4 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.print("原链表：");
        printSingleList(node1);

        System.out.println();

        System.out.print("反转后的链表：");
        printSingleList(reverseSingleList(node1));
    }
}