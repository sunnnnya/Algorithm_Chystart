package practice_questions.list.common;

/**
 * @BelongsPackage: practice_questions.list.common
 * @ClassName: ListNode
 * @Author: 丛虹羽
 * @Date: 2024/8/9 下午4:47
 * @Description: 链表中的基本结构信息
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
