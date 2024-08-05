package basic_knowledge.tree.avl_tree;

/**
 * @BelongsPackage: basic_knowledge.tree.avl_tree
 * @ClassName: AVL
 * @Author: 丛虹羽
 * @Date: 2024/8/5 下午9:13
 * @Description: 自平衡二叉搜索树  AVL树平衡因子：|左树高度 - 右树高度| <= 1
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
    }

}
