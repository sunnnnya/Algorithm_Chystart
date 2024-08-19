package basic_knowledge.union_find;

import java.util.*;

/**
 * @BelongsPackage: basic_knowledge.union_find
 * @ClassName: UnionFind
 * @Author: 丛虹羽
 * @Date: 2024/8/19 下午3:35
 * @Description: 并查集的使用 好理解版本
 */
public class UnionFind {

    /**
     * 对元素进行包装
     *
     * @param <V>
     */
    public static class Node<V> {
        public V value;

        public Node(V value) {
            this.value = value;
        }
    }

    /**
     * 并查集结构
     *
     * @param <V>
     */
    public static class UnionSet<V> {
        public HashMap<V, Node<V>> nodes;
        public HashMap<Node<V>, Node<V>> parents;
        public HashMap<Node<V>, Integer> sizeMap;

        public UnionSet(List<V>  values) {
            nodes = new HashMap<>();
            parents = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V v : values) {
                Node<V> node = new Node<>(v);
                nodes.put(v, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        /**
         * 找到当前节点的代表节点
         *
         * @param node
         * @return
         */
        public Node<V> findFather(Node<V> node) {
            LinkedList<Node<V>> queue = new LinkedList<>();
            while (parents.get(node) != node) {
                queue.add(node);
                node = parents.get(node);
            }
            // 并查集的扁平化
            while (!queue.isEmpty()) {
                parents.put(queue.poll(), node);
            }
            return node;
        }

        /**
         * 返回两个节点是不是一个代表节点
         *
         * @param a
         * @param b
         * @return
         */
        public boolean isSameSet(V a, V b) {
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        /**
         * 集合的合并
         *
         * @param a
         * @param b
         */
        public void union(V a, V b) {
            Node<V> aHead = findFather(nodes.get(a));
            Node<V> bHead = findFather(nodes.get(b));
            if (aHead != bHead) {
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                Node<V> big = aSetSize >= bSetSize ? aHead : bHead;
                Node<V> small = big == aHead ? bHead : aHead;
                parents.put(small, big);
                sizeMap.put(big, aSetSize + bSetSize);
                sizeMap.remove(small);
            }
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        UnionSet<Integer> unionSet = new UnionSet<>(Arrays.asList(1, 2, 3, 5, 6, 7));
        System.out.println(unionSet.isSameSet(2, 3)); // false
        unionSet.union(2, 3);
        System.out.println(unionSet.isSameSet(2, 3)); // true
        unionSet.union(3, 7);
        System.out.println(unionSet.isSameSet(2, 7)); // true
    }
}
