package job_interview.hot100.linked_list;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsPackage: job_interview.hot100.linked_list
 * @ClassName: CopyRandomList
 * @Author: 丛虹羽
 * @Date: 2025/7/15 14:11
 * @Description: 随机链表的复制
 * https://leetcode.cn/problems/copy-list-with-random-pointer/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class CopyRandomList {

    /**
     * 随机复制链表结点
     */
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 数组随机链表的复制，通过 HashMap 进行存储关系<原结点, 复制之后的节点>
     *
     * @param head 链表头结点
     * @return 复制后的链表头结点
     */
    public static Node copyRandomList(Node head) {
        Map<Node, Node> mp = new HashMap<>();
        Node cur = head;
        while(cur != null) {
            mp.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            mp.get(cur).next = mp.get(cur.next);
            mp.get(cur).random = mp.get(cur.random);
            cur = cur.next;
        }
        return mp.get(head);
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        // TODO: 暂时不模拟了
    }
}
