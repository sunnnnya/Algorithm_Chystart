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
    public static boolean hasCycle1(ListNode head) {
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
     * 使用快慢指针：
     *      首先，快指针F一次走两步，慢指针S一次走一步；当两个节点相遇之后，已经证明是有环了。
     *      ，快指针从节点重新出发，一次走一步，随后再遇到的节点就是第一个入环的节点；
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        // 0个节点、1个节点、2个节点都不可能出现环
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode S = head.next;
        ListNode F = head.next.next;
        while(F != S) {
            if (F.next == null || F.next.next == null) {
                return false;
            }
            // 说明 F != null 且 F.next != null 且 F.next.next != null
            F = F.next.next;
            S = S.next;
        }
        return true;
    }

    /**
     * 使用快慢指针：
     *      首先，快指针F一次走两步，慢指针S一次走一步；当两个节点相遇之后，已经证明是有环了。
     *      随后，快指针从头节点重新出发，一次走一步，慢指针也一次走一部，随后再遇到的节点就是第一个入环的节点；
     * 技巧：记住就可以；
     *
     * @param head
     * @return
     */
    public static ListNode getFirstPointOfRing(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode S = head.next;
        ListNode F = head.next.next;
        while(F != S) {
            if (F.next == null || F.next.next == null) {
                return null;
            }
            F = F.next.next;
            S = S.next;
        }
        F = head;
        while (F != S) {
            F = F.next;
            S = S.next;
        }
        return S;
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
        // 判断有无环
        System.out.println(hasCycle(listNode1));
        // true

        // 有环的话，获取第一个入环节点；
        System.out.println(getFirstPointOfRing(listNode1).val);
        // 3

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

        System.out.println(getFirstPointOfRing(listNode7));
        // null
    }
}
