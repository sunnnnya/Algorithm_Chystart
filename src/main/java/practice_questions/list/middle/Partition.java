package practice_questions.list.middle;

import practice_questions.list.common.ListNode;

/**
 * @BelongsPackage: practice_questions.list
 * @ClassName: Partition
 * @Author: 丛虹羽
 * @Date: 2024/8/10 下午4:53
 * @Description: 分隔链表
 *
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * leetcode：https://leetcode.cn/problems/partition-list/description/
 */
public class Partition {

    /**
     * 对数组中的节点信息进行分区
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        if(head == null) {
            return null;
        }
        ListNode lessHead = null;
        ListNode lessTail = null;
        ListNode moreEqualHead = null;
        ListNode moreEqualTail = null;
        while (head != null) {
            if (head.val < x) {
                if (lessHead == null && lessTail == null) {
                    lessHead = head;
                    lessTail = head;
                } else {
                    lessTail.next = head;
                    lessTail = lessTail.next;
                }
            } else {
                if (moreEqualHead == null && moreEqualTail == null) {
                    moreEqualHead = head;
                    moreEqualTail = head;
                } else {
                    moreEqualTail.next = head;
                    moreEqualTail = moreEqualTail.next;
                }
            }
            head = head.next;
        }
        // >= 的尾巴处理完成
        if (moreEqualTail != null) {
            moreEqualTail.next = null;
        }
        // 并没有出现 < 的情况
        if (lessTail == null) {
            return moreEqualHead;
        }
        lessTail.next = moreEqualHead;
        return lessHead;
    }

    /**
     * 打印链表
     *
     * @param head
     */
    public static void print(ListNode head) {
        while (head != null) {
            if (head.next == null) {
                System.out.print(head.val);
            } else {
                System.out.print(head.val + " -> ");
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
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        System.out.print("原始链表信息：");
        print(listNode1);

        System.out.print("划分之后的链表信息：");
        print(partition(listNode1, 3));
    }
}
