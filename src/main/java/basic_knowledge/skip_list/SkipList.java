package basic_knowledge.skip_list;

import java.util.ArrayList;

/**
 * @BelongsPackage: basic_knowledge.skip_list
 * @ClassName: SkipList
 * @Author: 丛虹羽
 * @Date: 2024/8/7 上午9:50
 * @Description: 跳表
 *
 * Level 3:  1------------------>7------------------>12------------------->21
 *
 * Level 2:  1-------->3-------->7-------->8-------->12------->19--------->21
 *
 * Level 1:  1-------->3-------->7-------->8-------->9-------->12--------->19-------->21-------->25-------->26
 *
 * Level 0:  1-------->3-------->7-------->8-------->9-------->12--------->19-------->21-------->25-------->26
 */
public class SkipList {

    /**
     * 跳表中的节点信息
     *
     * @param <K>
     * @param <V>
     */
    public static class SkipListNode<K extends Comparable<K>, V> {
        public K key;
        public V value;
        public ArrayList<SkipListNode<K, V>> nextNodes;

        public SkipListNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.nextNodes = new ArrayList<SkipListNode<K, V>>();
        }

        public boolean isKeyLess(K otherKey) {
            return otherKey != null && (key == null || key.compareTo(otherKey) < 0);
        }

        public boolean isKeyEqual(K otherKey) {
            return (key == null && otherKey == null)
            || (key != null && otherKey != null && key.compareTo(otherKey) == 0);
        }
    }

    /**
     * 跳表结构
     *
     * @param <K>
     * @param <V>
     */
    public static class SkipListMap<K extends Comparable<K>, V> {
        private static final double PROBABILITY = 0.5;
        private SkipListNode<K, V> head;
        private int size;
        private int maxLevel;

        public SkipListMap() {
            head = new SkipListNode<>(null, null);
            head.nextNodes.add(null);
            size = 0;
            maxLevel = 0;
        }

        /**
         * 从最高层开始，向下找，<= node的最右节点
         * 最后一定会找到第 0 层 <key 的最右位置
         *
         * @param key
         * @return
         */
        private SkipListNode<K, V> mostRightLessNodeInTree(K key) {
            if (key == null) {
                return null;
            }
            int level = maxLevel;
            SkipListNode<K, V> cur = head;
            while (maxLevel >= 0) {
                cur = mostRightLessNodeInLevel(key, cur, level--);
            }
            return cur;
        }

        /**
         * 在一层中查找到 <= node 的最右位置
         *
         * @param key
         * @param cur
         * @param level
         * @return
         */
        private SkipListNode<K, V> mostRightLessNodeInLevel(K key, SkipListNode<K, V> cur, int level) {
            SkipListNode<K, V> next = cur.nextNodes.get(level);
            while (next != null && next.isKeyLess(key)) {
                cur = next;
                next = cur.nextNodes.get(level);
            }
            return cur;
        }

        /**
         * 查看是否包含key
         *
         * @param key
         * @return
         */
        public boolean containKey(K key) {
            if (key == null) {
                return false;
            }
            SkipListNode<K, V> less = mostRightLessNodeInTree(key);
            SkipListNode<K, V> next = less.nextNodes.get(0);
            return next != null && next.isKeyEqual(key);
        }

        /**
         * 获取到key对应的value
         *
         * @param key
         * @return
         */
        public V get(K key) {
            if (key == null) {
                return null;
            }
            SkipListNode<K, V> less = mostRightLessNodeInTree(key);
            SkipListNode<K, V> next = less.nextNodes.get(0);
            return next != null && next.isKeyEqual(key) ? next.value : null;
        }

        /**
         * 添加节点
         *
         * @param key
         * @param value
         */
        public void put(K key, V value) {
            if(key == null) {
                return;
            }
            // 找到当前树中第0层 < node 的最右位置
            SkipListNode<K, V> less = mostRightLessNodeInTree(key);
            SkipListNode<K, V> find = less.nextNodes.get(0);
            if (find != null && find.isKeyEqual(key)) { // key已经加过了，直接改value就可以
                find.value = value;
            } else {                                    // 新增节点到跳表中
                size++;                                 // 节点个数 + 1
                int newNodeLevel = 0;
                while (Math.random() < PROBABILITY) {
                    newNodeLevel++;                     // 当前要插入的数值的随机产生的高度
                }
                while (newNodeLevel > maxLevel) {
                    head.nextNodes.add(null);
                    maxLevel++;
                }
                SkipListNode<K, V> newNode = new SkipListNode<>(key, value);
                for (int i = 0; i < newNodeLevel; i++) {
                    newNode.nextNodes.add(null);
                }
                int level = maxLevel;
                SkipListNode<K, V> pre = head;
                while (level >= 0) {
                    // level层中，找到 < key 的节点
                    pre = mostRightLessNodeInLevel(key, pre, level);
                    if(level <= newNodeLevel) {
                        newNode.nextNodes.set(level, pre.nextNodes.get(level));
                        pre.nextNodes.set(level, newNode);
                    }
                    level--;
                }
            }
        }

        /**
         * 删除节点
         *
         * @param key
         */
        public void remove(K key) {
            if (containKey(key)) {
                size--;
                int level = maxLevel;
                SkipListNode<K, V> pre = head;
                while (level >= 0) {
                    pre = mostRightLessNodeInLevel(key, pre, level);
                    SkipListNode<K, V> next = pre.nextNodes.get(level);
                    // 在这一层中，pre下一个就是key
                    // 在这一层中，pre的下一个key是>要删除key
                    if (next != null && next.isKeyEqual(key)) {
                        pre.nextNodes.set(level, next.nextNodes.get(level));
                    }
                    // 在level层只有一个节点了，就是默认节点head
                    if (level != 0 && pre == head && pre.nextNodes.get(level) == null) {
                        head.nextNodes.remove(level);
                        maxLevel--;
                    }
                }
                level--;
            }
        }

        public K firstKey() {
            return head.nextNodes.get(0) != null ? head.nextNodes.get(0).key : null;
        }

        public K lastKey() {
            int level = maxLevel;
            SkipListNode<K, V> cur = head;
            while (level >= 0) {
                SkipListNode<K, V> next = cur.nextNodes.get(level);
                while (next != null) {
                    cur = next;
                    next = next.nextNodes.get(level);
                }
                level--;
            }
            return cur.key;
        }

        public int getSize() {
            return size;
        }
    }
}

