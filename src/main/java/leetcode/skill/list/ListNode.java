package leetcode.skill.list;

/**
 * @BelongsPackage: leetcode.list
 * @ClassName: Common
 * @Author: 丛虹羽
 * @Date: 2025/3/3 21:51
 * @Description: 单链表中的节点信息
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}
