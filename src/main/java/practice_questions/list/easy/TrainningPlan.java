package practice_questions.list.easy;

import practice_questions.list.common.ListNode;

/**
 * @BelongsPackage: practice_questions.list.easy
 * @ClassName: TrainningPlan
 * @Author: 丛虹羽
 * @Date: 2024/8/22 下午10:58
 * @Description: 训练计划 IV
 *
 * 给定两个以 有序链表 形式记录的训练计划 l1、l2，分别记录了两套核心肌群训练项目编号，请合并这两个训练计划，按训练项目编号 升序 记录于链表并返回。
 *
 * leetcode： https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 */
public class TrainningPlan {

    /**
     * 返回合并之后的节点信息
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode trainningPlan(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode smallNode = l1.val <= l2.val ? l1 : l2;
        ListNode cur1 = smallNode.next;
        ListNode cur2 = smallNode == l1 ? l2 : l1;
        ListNode pre = smallNode;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return smallNode;
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
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        print(trainningPlan(listNode1, listNode4));
    }
}
