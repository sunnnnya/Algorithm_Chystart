package basic_knowledge.list.easy;

import basic_knowledge.list.common.Node;

/**
 * @BelongsPackage: basic_knowledge.list.easy
 * @ClassName: RemoveValue
 * @Author: 丛虹羽
 * @Date: 2024/8/1 下午3:54
 * @Description: 移除链表中指定的值
 *
 */
public class RemoveValue {

    /**
     * 删除链表中指定值的节点信息
     *
     * @param head
     * @param num
     * @return
     */
    public static Node removeValue(Node head, int num) {
        while (head != null) {
            if (head.val != num) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.val == num){
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 打印链表信息
     *
     * @param head
     */
    public static void print(Node head) {
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
        Node node1 = new Node(2);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(1);
        Node node6 = new Node(13);
        Node node7 = new Node(4);
        Node node8 = new Node(6);
        Node node9 = new Node(2);
        Node node10 = new Node(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        System.out.print("原始链表：");
        print(node1);
        // 原始链表：2 -> 2 -> 3 -> 2 -> 1 -> 13 -> 4 -> 6 -> 2 -> 2

        System.out.println();

        System.out.print("移除之后的链表是：");
        print(removeValue(node1, 2));
        // 移除之后的链表是：3 -> 1 -> 13 -> 4 -> 6
    }
}