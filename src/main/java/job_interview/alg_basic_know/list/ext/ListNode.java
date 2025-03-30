package job_interview.alg_basic_know.list.ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.list.ext
 * @ClassName: ListNode
 * @Author: 丛虹羽
 * @Date: 2025/3/30 23:47
 * @Description: 单链表的结构
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}
