package practice_questions.list.easy;

import practice_questions.list.common.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * @BelongsPackage: basic_knowledge.list.easy
 * @ClassName: ViewPalindromeStructure
 * @Author: 丛虹羽
 * @Date: 2024/8/10 上午9:32
 * @Description: 查看一个链表是不是回文结构
 *
 * 1 -> 2 -> 2 -> 1：是回文单链表
 * 1 -> 3 -> 3 -> 7 -> 3 -> 3 -> 1：是回文单链表
 *
 * 1 -> 5 -> 7：不是回文单链表
 */
public class IsPalindrome {

    /**
     * 查看链表是不是回文字串，牺牲空间使用stack结构存储，利用stack的特性进行处理；
     * 空间复杂度O（N）
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome1(ListNode head) {
        ListNode cur = head;
        Stack<Integer> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        while (head != null) {
            if (head.val == stack.peek()) {
                stack.pop();
            } else {
                break;
            }
            head = head.next;
        }
        return stack.isEmpty();
    }

    /**
     * 修改单链表中的指针，判断是不是回文
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode S = head;
        ListNode F = head;
        // 使用快慢指针找到中点的位置
        while (F.next != null && F.next.next != null) {
            S = S.next;
            F = F.next.next;
        }
        // 反转链表之前的头节点信息
        F = S.next;
        // 慢指针的next设置为null
        S.next = null;
        // 反转后半段的链表
        ListNode next = null;
        while (F != null) {
            next = F.next;
            F.next = S;
            S = F;
            F = next;
        }
        // S 表示后半部分反转之后的头节点
        next = S;
        // F 表示前半部分未反转的头节点
        F = head;
        boolean ans = true;
        // 两种情况都会退出一个是：奇数单链表时：S == null F = null 偶数单链表时：F == null S != null
        while (S != null && F != null) {
            if (S.val != F.val) {
                ans = false;
                break;
            } else {
                S = S.next;
                F = F.next;
            }
        }
        S = next.next;
        next.next = null;
        while (S != null) {
            F = S.next;
            S.next = next;
            next = S;
            S = F;
        }
        return ans;
    }

    /**
     * 反转单链表
     *
     * @param head
     * @return
     */
    public static ListNode reverseListNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode next = null;
        ListNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(isPalindrome(listNode1));
        // true


        ListNode listNode5 = new ListNode(1);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(7);
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        System.out.println(isPalindrome(listNode5));
        // false
    }
}
