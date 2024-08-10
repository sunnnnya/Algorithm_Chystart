package practice_questions.list.medium;

import java.util.HashMap;

/**
 * @BelongsPackage: practice_questions.list.middle
 * @ClassName: CopyRandomList
 * @Author: 丛虹羽
 * @Date: 2024/8/10 下午8:40
 * @Description: 复杂链表的复制
 *
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * leetcode：https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 */
public class CopyRandomList {

    /**
     * 单链表随机节点
     */
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 拷贝随机节点
     *
     * @param head
     * @return
     */
    public static Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        // 哈希表存 原节点 和 原节点对应的 clone 节点
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            // cur 老节点
            // map.get(cur) 新节点
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 打印当前节点的信息，以及随机节点的信息
     *
     * @param head
     */
    public static void print(Node head) {
        while (head != null) {
            if (head.random == null) {
                System.out.print("{value: " + head.val + ", random: null} ");

            } else {
                System.out.print("{value: " + head.val + ", random: " + head.random.val + "} ");
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
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;
        System.out.print("原始节点数据信息：");
        print(node1);

        System.out.print("克隆之后的节点数据信息：");
        print(copyRandomList(node1));
    }
}
