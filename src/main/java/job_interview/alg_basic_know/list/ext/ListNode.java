package job_interview.alg_basic_know.list.ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.list.ext
 * @ClassName: ListNode
 * @Author: 丛虹羽
 * @Date: 2025/3/30 23:47
 * @Description: 单链表的结构
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {

    }
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}
