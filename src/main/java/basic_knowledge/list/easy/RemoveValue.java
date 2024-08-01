package basic_knowledge.list.easy;

import basic_knowledge.list.common.SingleListNode;

/**
 * @BelongsPackage: basic_knowledge.list.easy
 * @ClassName: RemoveValue
 * @Author: 丛虹羽
 * @Date: 2024/8/1 下午3:54
 * @Description: 移除链表中指定的值
 *
 * 注意头节点的处理
 */
public class RemoveValue {

    /**
     * 删除链表中指定值的节点信息
     *
     * @param head
     * @param num
     * @return
     */
    public static SingleListNode removeValue(SingleListNode head, int num) {
        // base case
        if (head == null) {
            return null;
        }
        // 处理头节点未要删除的节点信息，找到第一个不等于num的节点
        while (head != null) {
            if (head.val != num) {
                break;
            }
            head = head.next;
        }
        SingleListNode pre = head;
        SingleListNode cur = head;
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
    public static void print(SingleListNode head) {
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
        SingleListNode node1 = new SingleListNode(2);
        SingleListNode node2 = new SingleListNode(2);
        SingleListNode node3 = new SingleListNode(3);
        SingleListNode node4 = new SingleListNode(2);
        SingleListNode node5 = new SingleListNode(1);
        SingleListNode node6 = new SingleListNode(13);
        SingleListNode node7 = new SingleListNode(4);
        SingleListNode node8 = new SingleListNode(6);
        SingleListNode node9 = new SingleListNode(2);
        SingleListNode node10 = new SingleListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        print(removeValue(node1, 2));
        // 3 -> 1 -> 13 -> 4 -> 6
    }
}
