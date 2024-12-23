package basic_knowledge.tree.binary_tree;

import practice_questions.binary_tree.base.TreeNode;

/**
 * @BelongsPackage: basic_knowledge.tree.binary_tree
 * @ClassName: LCA
 * @Author: 丛虹羽
 * @Date: 2024/12/23 下午9:44
 * @Description: 普通二叉树的最低公共祖先 - node p - node q
 * (1) p 和 q 在一颗树上             (2) p 和 q 在两颗树上
 *           a                               a
 *         /  \                           /    \
 *        b    c                         b      c
 *       / \                           /  \    / \
 *      d   p*                        d    q* w    g
 *     /   / \                       /    / \
 *    e   r   w                    p*    l   m
 *       /
 *      q*
 */
public class LCA {

    /**
     * LCA 问题，针对递归的高级使用，要抽象的理解好递归序，针对不同的条件进行返回，让计算机进行尝试
     *
     * @param root 二叉树根节点
     * @param p    节点 p
     * @param q    节点 q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        // 去左树上搜索 p 或者 q 节点
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        // 去右树上搜索 p 或者 q 节点
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        // 左树汇聚到了 p 右树 汇聚到了 q，放回当前 root 节点
        if(l != null && r != null) {
            return root;
        }
        // 如果左边和右边都没有值直接返回null
        if(l == null && r == null) {
            return null;
        }
        // 哪个不空返回哪个
        return l != null ? l : r;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;
        System.out.println(lowestCommonAncestor(node3, node2, node8).val);
        // 3
    }
}