package job_interview.code_top.single_list;

import java.util.HashMap;

/**
 * @BelongsPackage: job_interview.code_top
 * @ClassName: LRUCache
 * @Author: 丛虹羽
 * @Date: 2025/3/25 21:53
 * @Description: LRU 缓存
 * https://leetcode.cn/problems/lru-cache/description/
 */
public class LRUCache {

    private static class Node {
        int key, value;
        Node pre, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;

    private final HashMap<Integer, Node> keyToMap = new HashMap<>();

    private final Node dummy;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy = new Node(0, 0);
        dummy.pre = dummy;
        dummy.next = dummy;
    }

    /**
     * 获取 key 对应的 value
     *
     * @param key int key
     * @return
     */
    public int get(int key) {
        Node node = getNode(key);
        return node == null ? -1 : node.value;
    }

    /**
     * 修改 | 新增对应的 key
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        Node node = getNode(key);
        if(node != null) {
            node.value = value;
            return;
        }
        node = new Node(key, value);
        keyToMap.put(key, node);
        // 新增加的节点放在烧饼节点的后面
        pushToTop(node);
        if(keyToMap.size() > capacity) {
            Node lastNode = dummy.pre;
            keyToMap.remove(lastNode.key);
            remove(lastNode);
        }
    }

    /**
     * 获取节点的值
     *
     * @param key key值
     * @return
     */
    private Node getNode(int key) {
        if(!keyToMap.containsKey(key)) {
            return null;
        }
        Node node = keyToMap.get(key);
        remove(node);
        pushToTop(node);
        return node;
    }

    /**
     * 移除指定节点
     *
     * @param node 待移除的节点
     */
    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * 把节点放在哨兵节点的后面，因为节点被使用过了
     *
     * @param node 待添加的节点
     */
    private void pushToTop(Node node) {
        node.pre = dummy;
        node.next = dummy.next;
        node.pre.next = node;
        node.next.pre = node;
    }
}
