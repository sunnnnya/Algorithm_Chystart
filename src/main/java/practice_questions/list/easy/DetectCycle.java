package practice_questions.list.easy;

import practice_questions.list.common.ListNode;

/**
 * @BelongsPackage: practice_questions.list.easy
 * @ClassName: DetectCycle
 * @Author: 丛虹羽
 * @Date: 2024/8/16 下午10:43
 * @Description: 环形链表 II
 *
 * 如果有环找到入环的节点，如果无环返回 null；
 */
public class DetectCycle {

    /**
     * 判断是有环还是无环节点，返回入环节点信息；
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        // 当两个节点出现环的时候，也好用，但是会出现 1 -> 2 -> null的情况
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode F = head.next.next;
        ListNode S = head.next;
        while (F != S) {
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
        return F;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;
        System.out.println(detectCycle(listNode1).val);
        // 2

        ListNode listNode5 = new ListNode(1);
        ListNode listNode6 = new ListNode(2);
        listNode5.next = listNode6;
        listNode6.next = listNode5;
        System.out.println(detectCycle(listNode5).val);
        // 1
    }
}
