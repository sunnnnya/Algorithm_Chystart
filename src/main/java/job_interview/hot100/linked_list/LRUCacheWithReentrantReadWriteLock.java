package job_interview.hot100.linked_list;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @BelongsPackage: job_interview.hot100.linked_list
 * @ClassName: LRUCacheWithReentrantReadWriteLock
 * @Author: 丛虹羽
 * @Date: 2025/7/27 22:20
 * @Description: LRU 缓存
 * https://leetcode.cn/problems/lru-cache/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class LRUCacheWithReentrantReadWriteLock {

    class Node {
        int key, value;
        Node pre, next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node dummy = new Node(0, 0);

    private Map<Integer, Node> mp = new HashMap<>();

    private int capacity;

    private ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private Lock writeLock = rwLock.writeLock();
    private Lock readLock = rwLock.readLock();

    public LRUCacheWithReentrantReadWriteLock(int capacity) {
        this.capacity = capacity;
        dummy.next = dummy;
        dummy.pre = dummy;
    }

    public int get(int key) {
        writeLock.lock();
        try {
            Node node = getNode(key);
            return node == null ? -1 : node.value;
        } finally {
            writeLock.unlock();
        }
    }

    public void put(int key, int value) {
        writeLock.lock();
        try {
            Node node = getNode(key);
            if(node != null) {
                node.value = value;
                return;
            }
            node = new Node(key, value);
            pushToTheTop(node);
            mp.put(key, node);
            if(mp.size() > capacity) {
                Node lastNode = dummy.pre;
                mp.remove(lastNode.key);
                removeNode(lastNode);
            }
        } finally {
            writeLock.unlock();
        }
    }

    private Node getNode(int key) {
        if(!mp.containsKey(key)) {
            return null;
        }
        Node node = mp.get(key);
        removeNode(node);
        pushToTheTop(node);
        return node;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void pushToTheTop(Node node) {
        node.pre = dummy;
        node.next = dummy.next;
        node.pre.next = node;
        node.next.pre = node;
    }
}
