package practice_questions.list.easy;

import practice_questions.list.common.ListNode;

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
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
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
