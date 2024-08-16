package practice_questions.list.easy;

import practice_questions.list.common.ListNode;

/**
 * @BelongsPackage: practice_questions.list.easy
 * @ClassName: Partition
 * @Author: 丛虹羽
 * @Date: 2024/8/16 下午4:59
 * @Description: 给定一个链表，按照 <=  == >= 区域进行划分
 *
 */
public class Partition {

    /**
     * 进行分区，使用链表的方式，不使用容器
     *
     * @param head
     * @return
     */
    public static ListNode partition(ListNode head, int number) {
        if(head == null) {
            return null;
        }
        ListNode lessHead = null;
        ListNode lessTail = null;
        ListNode equalHead = null;
        ListNode equalTail = null;
        ListNode moreHead = null;
        ListNode moreTail = null;
        while (head != null) {
            if (head.val < number) {
                if (lessHead == null && lessTail == null) {
                    lessHead = head;
                    lessTail = head;
                } else {
                    lessTail.next = head;
                    lessTail = lessTail.next;
                }
            } else if (head.val > number) {
                if (moreHead == null && moreTail == null) {
                    moreTail = head;
                    moreHead = head;
                } else {
                    moreTail.next = head;
                    moreTail = moreTail.next;
                }
            } else {
                if (equalHead == null && equalTail == null) {
                    equalTail = head;
                    equalHead = head;
                } else {
                    equalTail.next = head;
                    equalTail = equalTail.next;
                }
            }
            head = head.next;
        }
        // >
        if (lessTail == null && equalTail == null && moreTail != null) {
            moreTail.next = null;
            return moreHead;
        }
        // <
        else if(lessTail != null && equalTail == null && moreTail == null) {
            lessTail.next = null;
            return lessHead;
        }
        // =
        else if(lessTail == null && equalTail != null && moreTail == null) {
            equalTail.next = null;
            return equalHead;
        }
        // = >
        else if (lessTail == null && equalTail != null && moreTail != null) {
            equalTail.next = moreHead;
            moreTail.next = null;
            return equalHead;
        }
        // < =
        else if (lessTail != null && equalTail != null && moreTail == null) {
            lessTail.next = equalHead;
            equalTail.next = null;
            return lessHead;
        }
        // < >
        else if (lessTail != null && equalTail == null && moreTail != null) {
            lessTail.next = moreHead;
            moreTail.next = null;
            return lessHead;
        }
        // < = >
        else if (lessTail != null && equalTail != null && moreTail != null) {
            lessTail.next = equalHead;
            equalTail.next = moreHead;
            moreTail.next = null;
            return lessHead;
        }
        // 到达不了
        return null;
    }

    /**
     * 打印链表信息
     *
     * @param head
     */
    public static void print(ListNode head) {
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
        System.out.println();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(6);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(1);
        ListNode listNode6 = new ListNode(3);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(9);
        ListNode listNode9 = new ListNode(10);
        ListNode listNode10 = new ListNode(5);
        ListNode listNode11 = new ListNode(8);
        ListNode listNode12 = new ListNode(8);
        ListNode listNode13 = new ListNode(8);
        ListNode listNode14 = new ListNode(8);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;
        listNode10.next = listNode11;
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        System.out.println("===================原始链表====================");
        print(listNode1);
        // 6 -> 3 -> 2 -> 6 -> 1 -> 3 -> 7 -> 9 -> 10 -> 5 -> 8 -> 8 -> 8 -> 8

        System.out.println("===================分区之后的链表====================");
        // < = >
        // print(partition(listNode1, 8));
        // 6 -> 3 -> 2 -> 6 -> 1 -> 3 -> 7 -> 5 -> 8 -> 8 -> 8 -> 8 -> 9 -> 10

        // >
        // print(partition(listNode1, 0));
        // 6 -> 3 -> 2 -> 6 -> 1 -> 3 -> 7 -> 9 -> 10 -> 5 -> 8 -> 8 -> 8 -> 8

        // <
        // print(partition(listNode1, 20));
        // 6 -> 3 -> 2 -> 6 -> 1 -> 3 -> 7 -> 9 -> 10 -> 5 -> 8 -> 8 -> 8 -> 8

        // > =
        // print(partition(listNode1, 1));
        // 1 -> 6 -> 3 -> 2 -> 6 -> 3 -> 7 -> 9 -> 10 -> 5 -> 8 -> 8 -> 8 -> 8

        // < =
        // print(partition(listNode1, 10));
        // 6 -> 3 -> 2 -> 6 -> 1 -> 3 -> 7 -> 9 -> 5 -> 8 -> 8 -> 8 -> 8 -> 10

        // < >
        print(partition(listNode1, 4));
        // 3 -> 2 -> 1 -> 3 -> 6 -> 6 -> 7 -> 9 -> 10 -> 5 -> 8 -> 8 -> 8 -> 8
    }
}
