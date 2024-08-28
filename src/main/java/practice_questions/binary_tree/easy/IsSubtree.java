package practice_questions.binary_tree.easy;

import practice_questions.binary_tree.base.TreeNode;

/**
 * @BelongsPackage: practice_questions.tree
 * @ClassName: IsSubtree
 * @Author: 丛虹羽
 * @Date: 2024/8/28 上午11:36
 * @Description: 另一棵树的子树
 *
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 *
 * leetcode: https://leetcode.cn/problems/subtree-of-another-tree
 */
public class IsSubtree {

    /**
     * 递归的使用
     *
     * @param root
     * @param subRoot
     * @return
     */
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root != null && subRoot != null) {
            return same(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
        // 三种情况：
        // root != null subRoot == null true
        // root == null subRoot != null false
        // root == null subRoot == null true
        return subRoot == null;
    }

    /**
     * 判断两棵树是否相同
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean same(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a != null && b != null) {
            return a.val == b.val && same(a.left, b.left) && same(a.right, b.right);
        }
        return false;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(1);
        TreeNode treeNode8 = new TreeNode(2);
        treeNode6.left = treeNode7;
        treeNode6.right = treeNode8;

        System.out.println(isSubtree(treeNode1, treeNode6));
        // true
    }
}