package practice_questions.list.easy;

import practice_questions.list.common.ListNode;
import java.util.HashSet;

/**
 * @BelongsPackage: basic_knowledge.list.easy
 * @ClassName: ExistsCircle
 * @Author: 丛虹羽
 * @Date: 2024/8/10 下午10:04
 * @Description: 判断链表中是否存在环， 如果存在环，则返回第一个入环的节点；
 *
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * leetcode：https://leetcode.cn/problems/linked-list-cycle/
 */
public class HasCycle {

    /**
     * 使用哈希表判断是否存在环
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        //   1
        //    \
        //      2
        //       \
        //        3 ———— 6
        //          \     \
        //           4 ——  5
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode3;
        System.out.println(hasCycle(listNode1));
        // true

        //   7
        //    \
        //      8
        //       \
        //        9
        //          \
        //           10
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode9 = new ListNode(9);
        ListNode listNode10 = new ListNode(10);
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;
        System.out.println(hasCycle(listNode7));
        // false
    }
}
