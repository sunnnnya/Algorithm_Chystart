package job_interview.hot100.linked_list;

import java.util.HashMap;

/**
 * @BelongsPackage: job_interview.hot100.linked_list
 * @ClassName: LRUCache
 * @Author: 丛虹羽
 * @Date: 2025/7/15 14:26
 * @Description: LRU 缓存
 * https://leetcode.cn/problems/lru-cache/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class LRUCache {

    /**
     * 初始化结点信息
     */
    public static class Node {
        int key, value;
        Node pre, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 初始化容量
    private int capacity;

    // HashMap 集合 <key, node>
    private HashMap<Integer, Node> mp = new HashMap<>();

    // 哨兵结点
    private Node dummy = new Node(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.pre = dummy;
        dummy.next = dummy;
    }

    /**
     * 获取当前节点信息
     *
     * @param key key
     * @return int
     */
    public int get(int key) {
        Node node = getNode(key);
        return node != null ? node.value : -1;
    }

    /**
     * 修改值的情况
     *
     * @param key key
     * @param value value
     */
    public void put(int key, int value) {
        Node node = getNode(key);
        if(node != null) {
            node.value = value;
            return ;
        }
        node = new Node(key, value);
        pushToTop(node);
        mp.put(key, node);
        if(mp.size() > capacity) {
            Node lastNode = dummy.pre;
            mp.remove(lastNode.key);
            removeNode(lastNode);
        }
    }

    /**
     * 获取结点信息
     *
     * @param key key
     * @return Node
     */
    private Node getNode(int key) {
        if(!mp.containsKey(key)) {
            return null;
        }
        Node node = mp.get(key);
        removeNode(node);
        pushToTop(node);
        return node;
    }

    /**
     * 移除结点
     *
     * @param node 节点信息
     */
    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * 把当前节点放在 最上面
     *
     * @param node 节点信息
     */
    private void pushToTop(Node node) {
        node.pre = dummy;
        node.next = dummy.next;
        node.pre.next = node;
        node.next.pre = node;
    }
}
