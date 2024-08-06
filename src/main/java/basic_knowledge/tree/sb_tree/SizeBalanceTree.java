package basic_knowledge.tree.sb_tree;

/**
 * @BelongsPackage: basic_knowledge.tree.sb_tree
 * @ClassName: SizeBalanceTree
 * @Author: 丛虹羽
 * @Date: 2024/8/6 下午2:19
 * @Description: SB树是 自平衡二叉搜索树的一种  平衡因子：叔叔节点的个数不能小于侄子节点的个数 size
 *
 * SB树（Size Balanced Tree）是一种平衡二叉搜索树，其平衡条件不同于其他平衡树（如AVL树或红黑树）。SB树的平衡条件主要基于节点子树的大小。
 *                   ..
 *                /     \
 *              A        B             以A节点为根的子树节点个数 >= 以C或D节点为根的子树节点个数，满足平衡性
 *             / \      / \            以B节点为根的子树节点个数 >= 以E或F节点为根的子树节点个数，满足平衡性
 *            E   F    C   D
 *
 * SB树同样也是对应四种破坏平衡性类型：
 *             LL(E节点为根的子树节点个数 > C)      LR(F节点为根的子树节点个数 > C)
 *             A                                         A
 *           /  \                                      /  \
 *         B     C                                   B     C
 *       /                                            \
 *      E                                              F
 *
 *             RR(H节点为根的子树节点个数 > B)      RL(Q节点为根的子树节点个数 > B)
 *             A                                         A
 *           /  \                                      /  \
 *         B     C                                   B     C
 *                \                                       /
 *                 H                                    Q
 *
 * SB树针对四种情况的平衡性调整：针对LL、LR、RR、RL四种违规的旋转方式和AVL树一样，只不过是需要对子节点变化的节点继续进行递归调整
 *
 *                                   LL(D为头的子树节点个数 > C为头的子树节点个数)
 *                            A                       B
 *                          /  \                    /   \
 *                        B     C     A节点右旋     D     A      查看哪个节点的孩子发生过变化(A、B)    然后递归调用A节点和B节点重复检查是否违规
 *                      /  \   /         ->      / \    / \                 ->                                      ->
 *                     D    E H                 Q   S  E   C
 *                   /  \                                 /
 *                  Q    S                               H
 *
 *                                   RR(D为头的子树节点个数 > C为头的子树节点个数)
 *                            A                       B
 *                          /  \                    /   \
 *                        B     C     A节点左旋     D     A      查看哪个节点的孩子发生过变化(A、B)    然后递归调用A节点和B节点重复检查是否违规
 *                      /  \   / \        ->      / \    / \                 ->                                      ->
 *                     D    E H   Y              Q   S  E   C
 *                              /  \                                 /
 *                             Q    S                               H
 */
public class SizeBalanceTree {

    public class SBTNode<K extends Comparable<K>, V> {
        public K key;
        public V value;
        public SBTNode<K, V> l;
        public SBTNode<K, V> r;
        int size; // 不同 key 的数量

        public SBTNode(K key, V value) {
            this.key = key;
            this.value = value;
            size = 1;
        }
    }

    public class SBTTreeMap<K extends Comparable<K>, V> {

        private SBTNode<K, V> root;

        /**
         * 左旋
         *
         * @param cur 当前待旋转的头节点信息
         * @return    返回值是旋转之后的新的头节点信息
         */
        public SBTNode<K, V> leftRotate(SBTNode<K, V> cur) {
            SBTNode<K, V> rightNode = cur.r;
            cur.r = rightNode.l;
            rightNode.l = cur;
            // 总节点个数没有删除，只是换了头节点的信息，故个数不变直接复制
            rightNode.size = cur.size;
            cur.size = (cur.l != null ? cur.l.size : 0) + (cur.r != null ? cur.r.size : 0) + 1;
            return rightNode;
        }

        /**
         * 右旋
         *
         * @param cur 当前待旋转的头节点信息
         * @return    返回值是旋转之后的新的头节点信息
         */
        public SBTNode<K, V> rightRotate(SBTNode<K, V> cur) {
            SBTNode<K, V> leftNode = cur.l;
            cur.l = leftNode.r;
            leftNode.r = cur;
            // 总节点个数没有删除，只是换了头节点的信息，故个数不变直接复制
            leftNode.size = cur.size;
            cur.size = (cur.l != null ? cur.l.size : 0) + (cur.r != null ? cur.r.size : 0) + 1;
            return leftNode;
        }

        /**
         * SBTree的调整策略
         *
         * @param cur
         * @return
         */
        private SBTNode<K, V> maintain(SBTNode<K, V> cur) {
            if (cur == null) {
                return null;
            }
            int leftSize = cur.l != null ? cur.l.size : 0;
            int leftLeftSize = cur.l != null && cur.l.l != null ? cur.l.l.size : 0;
            int leftRightSize = cur.l != null && cur.l.r != null ? cur.l.r.size : 0;
            int rightSize = cur.r != null ? cur.r.size : 0;
            int rightLeftSize = cur.r != null && cur.r.l != null ? cur.r.l.size : 0;
            int rightRightSize = cur.r != null && cur.r.r != null ? cur.r.r.size : 0;
            if (leftLeftSize > rightSize) { // LL
                cur = rightRotate(cur);
                cur.r = maintain(cur.r);
                cur = maintain(cur);
            } else if (leftRightSize > rightSize) { // LR
                cur.l = leftRotate(cur.l);
                cur = rightRotate(cur);
                cur.l = maintain(cur.l);
                cur.r = maintain(cur.r);
                cur = maintain(cur);
            } else if (rightRightSize > leftSize) {
                cur = leftRotate(cur);
                cur.l = maintain(cur.l);
                cur = maintain(cur);
            } else if (rightLeftSize > leftRightSize){
                cur.r = rightRotate(cur.r);
                cur = leftRotate(cur);
                cur.l = maintain(cur.l);
                cur.r = maintain(cur.r);
                cur = maintain(cur);
            }
            return cur;
        }

        /**
         * 向SizeBalanceTree中添加节点
         *
         * @param cur   要添加的节点的信息
         * @param key   添加节点的key
         * @param value 添加节点的value
         * @return      添加节点后调整之后的头节点信息
         */
        private SBTNode<K, V> add(SBTNode<K,V> cur, K key,V value) {
            if (cur == null) {
                return new SBTNode<K, V>(key, value);
            } else {
                cur.size++;
                if (key.compareTo(cur.key) < 0) {
                    cur.l = add(cur.l, key, value);
                } else {
                    cur.r = add(cur.r, key, value);
                }
                return maintain(cur);
            }
        }

        /**
         * 在以 cur 为头节点的树上，删除 key 对应的值，然后重新返回节点的信息
         *
         * @param cur
         * @param key
         * @return
         */
        private SBTNode<K, V> delete(SBTNode<K, V> cur, K key) {
            cur.size--;
            if (key.compareTo(cur.key) > 0) {        // 如果要删除的值，大于节点的值，在右子树删除
                cur.r = delete(cur.r, key);
            } else if (key.compareTo(cur.key) < 0) { // 如果要删除的值，小于节点的值，在左子树删除
                cur.l = delete(cur.l, key);
            } else {
                if (cur.l == null && cur.r == null) { // 直接删除
                    cur = null;
                } else if (cur.l != null && cur.r == null) { // 直接当前节点等于左子树的值
                    cur = cur.l;
                } else if (cur.r != null && cur.l == null) { // 直接当前节点等于右子树的值
                    cur = cur.r;
                } else {
                    SBTNode<K, V> pre = null;
                    SBTNode<K, V>des = cur.r;
                    des.size--;
                    while (des.l != null) {
                        pre = des;
                        des = des.l;
                        des.size--;
                    }
                    if (pre != null) {
                        pre.l = des.r;
                        des.r = cur.r;
                    }
                    des.l = cur.l;
                    des.size = des.l.size + (des.r == null ? 0 : des.r.size) + 1;
                    cur = des;
                }
            }
            return cur;
        }
    }
}
