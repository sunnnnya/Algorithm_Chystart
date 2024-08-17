package basic_knowledge.tree.binary_tree.easy;

/**
 * @BelongsPackage: basic_knowledge.tree.binary_tree.easy
 * @ClassName: LCS
 * @Author: 丛虹羽
 * @Date: 2024/8/17 上午10:43
 * @Description: 二叉树的公共祖先知识点
 *                       a
 *                     /  \
 *                    b    c
 *                   / \  / \
 *                  d  e x   g
 *                   /  / \
 *                 t   k   s
 * 上面的树进行先序遍历：[a b d e t c] x k s g
 * 上面的树进行后序遍历：d t e b k s x [g c a]
 * 先序中 x 的左侧集合 和 后序中 x 的右侧集合 的交集 就是 x 的所有祖先节点
 */
public class LCS {
}
