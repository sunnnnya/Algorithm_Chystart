package practice_questions.binary_tree.easy;

import practice_questions.binary_tree.base.TreeNode;

/**
 * @BelongsPackage: practice_questions.tree
 * @ClassName: MaximumDepthOfBinaryTree
 * @Author: 丛虹羽
 * @Date: 2024/7/28 上午1:07
 * @Description: 二叉树的最大深度
 *
 * leetcode：https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 */
public class MaxDepthOfBinaryTree {

    /**
     * 返回一个树的最大深度
     *
     * @param root
     * @return
     */
    private static int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode1.right = treeNode3;
        System.out.println(maxDepth(treeNode1));
        // 3
    }
}