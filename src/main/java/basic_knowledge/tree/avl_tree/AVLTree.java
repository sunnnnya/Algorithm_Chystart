package basic_knowledge.tree.avl_tree;

/**
 * @BelongsPackage: basic_knowledge.tree.avl_tree
 * @ClassName: AVL
 * @Author: 丛虹羽
 * @Date: 2024/8/5 下午9:13
 * @Description: 自平衡二叉搜索树  AVL树平衡因子：|左树高度 - 右树高度| <= 1
 * 搜索二叉树中不存储重复的key
 *        原始二叉搜索树               旋转之后的平衡二叉搜索树
 *           A                                B
 *         /   \                            /  \
 *        T     B          以A节点左旋      A    C
 *            /  \             ->        /  \  / \
 *           K    C                     T   K S   F
 *               / \
 *              S   F
 *
 *        原始二叉搜索树               旋转之后的平衡二叉搜索树
 *           A                               B
 *         /  \                            /   \
 *        B    T        以A节点左旋        C     A
 *      /  \               ->           /  \   / \
 *     C    K                          S    F K   T
 *   /  \
 *  S    F
 *
 *  AVL树的添加删除节点和二叉搜索树一样，只是多了平衡性的校验 和 左右旋转
 *  AVL树添加节点：本着原则：左子树都比当前节点小，右子树都比当前节点大，当不平衡时进行左旋或者右旋
 *  AVL树删除节点：
 *      （1）【删除节点7】当前要删除节点无左孩子，无右孩子 -> 直接删除当前节点
 *              5                     5
 *             / \                   /
 *            3   7       --->      3
 *           / \                   / \
 *          2   4                 2   4
 *      （2）【删除节点6】当前要删除节点有左孩子，无右孩子 -> 左孩子直接替换当前节点的环境
 *               5                       5
 *             /   \                   /  \
 *            3     7     --->        3    6
 *           / \   /                / \   / \
 *          2   4 6                2   4 ..  ..
 *               / \
 *              .. ..
 *      （3）【删除节点7】当前要删除节点无左孩子，有右孩子 -> 右孩子直接替换当前节点的环境
 *               5                        5
 *             /   \                    /   \
 *            3     7     --->         3     8
 *           / \     \                / \   / \
 *          2   4     8             2   4 ..  ..
 *                   / \
 *                  .. ..
 *      （4）【删除节点9】当前要删除节点既有左孩子，又有右孩子 -> 找到当前节点左树的最右孩子，或者，右树的最左孩子替换该节点
 *               5                        5
 *             /   \                    /   \
 *            3     9     --->         3     8
 *           / \   / \                / \   / \
 *          2   4 7   10             2   4 7  10
 *               / \                      /
 *              6   8                    6
 *  破坏AVL树平衡性的四种情况：LR和RL型的总结就是让孙子节点上去
 *       LL(3做一次右旋)   LR(1左旋3右旋)     RR(3做一次左旋)     RL(1右旋3左旋)
 *       3                  3                 3                  3
 *      |                  /                   \                  \
 *      1                 1                     1                  1
 *     |                  \                      \                /
 *    2                    2                      2              2
 *  如果删除某一个节点之后变成了LL和LR型，默认当LL型处理就可以解决不平衡问题！！！
 *  -------------------------------------------------------------------------------
 *  如何判断当前树不满足平衡性：
 *          对插入的叶子节点依次向上查询，看看节点平不平衡。
 *
 *
 */
public class AVLTree {

    /**
     * AVL树的节点结构
     *
     * @param <K> 树平衡判断的银子
     * @param <V> 树上节点的值
     */
    public static class AVLNode<K extends Comparable<K>, V> {
        public K k;
        public V v;
        public AVLNode<K, V> l;
        public AVLNode<K, V> r;
        // 平衡因子：以当前节点为头部的高度信息
        public int h;
        public AVLNode(K key, V value) {
            this.k = key;
            this.v = value;
        }
    }

    public static class AVLTreeMap<K extends Comparable<K>, V> {
        // AVL树的根节点
        private AVLNode<K, V> root;
        // 一共加入了几个元素
        private int size;

        public AVLTreeMap() {
            root = null;
            size = 0;
        }

        /**
         * cur节点进行右旋
         *
         * @param cur
         * @return
         */
        private AVLNode<K, V> rightRotate(AVLNode<K, V> cur) {
            AVLNode<K, V> left = cur.l;
            // 当前右旋的节点的新的左孩子是左孩子的右节点
            cur.l = left.r;
            left.r = cur;
            // 一定先cur后left【因为cur变成了left的子节点了，先更新子节点的高度，再更新父节点的高度，这样一定是准确的】
            cur.h = Math.max((cur.l != null ? cur.l.h : 0), (cur.r != null ? cur.r.h : 0)) + 1;
            left.h = Math.max((left.l != null ? left.l.h : 0), (left.r != null ? left.r.h : 0)) + 1;
            // 返回新头节点
            return left;
        }

        /**
         * cur节点进行左旋
         *
         * @param cur
         * @return
         */
        private AVLNode<K, V> leftRotate(AVLNode<K, V> cur) {
            AVLNode<K, V> right = cur.r;
            cur.r = right.l;
            right.l = cur;
            cur.h = Math.max((cur.l != null ? cur.l.h : 0), (cur.r != null ? cur.r.h : 0));
            right.h = Math.max((right.l != null ? right.l.h : 0), (right.r != null ? right.r.h : 0));
            return right;
        }

        /**
         * 平衡搜索二叉树中增加节点
         *
         * @param cur   当前节点的值
         * @param key   进行有序排序的字段
         * @param value 存储的值
         * @return
         */
        private AVLNode<K, V> addAVLNode(AVLNode<K, V> cur, K key, V value) {
            if (cur == null) {
                return new AVLNode<K, V>(key, value);
            }
            if (key.compareTo(cur.k) < 0) {
                // 左树可能会出现换头的情况
                cur.l = addAVLNode(cur.l, key, value);
            } else {
                // 右树可能会出现换头的情况
                cur.r = addAVLNode(cur.r, key, value);
            }
            cur.h = Math.max((cur.l != null ? cur.l.h : 0), (cur.r != null ? cur.r.h : 0)) + 1;
            // 进行调整
            return maintain(cur);
        }

        /**
         * 删除平衡二叉树中的节点
         *
         * @param cur
         * @param key
         * @return
         */
        private AVLNode<K, V> delete(AVLNode<K, V> cur, K key) {
            if (key.compareTo(cur.k) > 0) {
                // 删除之后节点可能会改变
                cur.r = delete(cur.r, key);
            } else if (key.compareTo(cur.k) < 0) {
                cur.l = delete(cur.l, key);
            } else {
                if (cur.l == null && cur.r == null) {        // 叶子节点直接删除
                    cur = null;
                } else if (cur.l == null && cur.r != null) { // 左树为null，右树不为null，直接赋值右树
                    cur = cur.r;
                } else if (cur.l != null && cur.r == null) { // 左树不为null，右树为null，直接赋值左树
                    cur = cur .l;
                } else {
                    AVLNode<K, V> des = cur.r;
                    while (des.l != null) {
                        des = des.l;
                    }
                    // 需要断连删除节点,同时对子树的平衡性做调整
                    cur.r = delete(cur.r, des.k);
                    des.l = cur.l;
                    des.r = cur.r;
                    cur = des;
                }
            }
            if (cur != null) {
                cur.h = Math.max((cur.l != null ? cur.l.h : 0), (cur.r != null ? cur.r.h : 0));
            }
            return maintain(cur);
        }

        /**
         * 平衡性判断调整
         *
         * @param cur
         * @return
         */
        private AVLNode<K,V> maintain(AVLNode<K,V> cur) {
            if (cur == null) {
                return null;
            }
            int leftHeight = cur.l != null ? cur.l.h : 0;
            int rightHeight = cur.r != null ? cur.r.h : 0;
            // 破坏平衡性
            if (Math.abs(leftHeight - rightHeight) > 1) {
                if(leftHeight > rightHeight) {
                    int leftLeftHeight = cur.l != null && cur.l.l != null ? cur.l.l.h : 0;
                    int rightRightHeight = cur.r != null && cur.l.r != null ? cur.l.r.h : 0;
                    // LL >= LR 上面也当 LL 处理
                    if (leftLeftHeight >= rightRightHeight) {
                        rightRotate(cur);
                    } else {
                        leftRotate(cur.l);
                        rightRotate(cur);
                    }
                } else {
                    int rightRightHeight = cur.r != null && cur.r.r != null ? cur.r.r.h : 0;
                    int rightLeftHeight = cur.l != null && cur.r.l != null ? cur.r.l.h : 0;
                    if (rightRightHeight >= rightLeftHeight) {
                        leftRotate(cur);
                    } else {
                        rightRotate(cur.r);
                        leftRotate(cur);
                    }
                }
            }
            return cur;
        }
    }
}
