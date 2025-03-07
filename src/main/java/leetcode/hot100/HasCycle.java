package leetcode.hot100;

import leetcode.skill.list.ListNode;

import java.util.HashSet;

/**
 * @BelongsPackage: leetcode.hot100
 * @ClassName: HasCycle
 * @Author: 丛虹羽
 * @Date: 2025/3/7 23:54
 * @Description: 环形链表 - chystart
 *
 * leetcode: https://leetcode.cn/problems/linked-list-cycle/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class HasCycle {

    /**
     * 快慢指针：
     *      由于快指针走的快，所以 F != null 可以先判断一下是否快指针直接出界，然后再说交点的事
     *
     * @param head 头节点
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode S = head.next;
        ListNode F = head.next.next;
        while(F != null && F.next != null && S != F) {
            S = S.next;
            F = F.next.next;
        }
        return S == F;
    }
    /**
     * 哈希表，进行判断
     *
     * @param head 头节点
     * @return
     */
    public static boolean hasCycle1(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return false;
        }
        HashSet<ListNode> set = new HashSet<>();
        while(head != null) {
            if(set.contains(head)) {
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
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println("是否存在环：" + hasCycle(node1));
        // 是否存在环：true
    }
}
