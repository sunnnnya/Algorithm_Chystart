package practice_questions.binary_tree.easy;

import practice_questions.binary_tree.base.TreeNode;

/**
 * @BelongsPackage: practice_questions.tree.easy
 * @ClassName: MinDepthOfBinaryTree
 * @Author: 丛虹羽
 * @Date: 2024/8/3 上午11:41
 * @Description: 求二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * leetcode:https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/
 */
public class MinDepthOfBinaryTree {

    /**
     * 获取二叉树的最小深度
     *
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return process(root);
    }

    /**
     * 递归函数，返回左右子树中的最小深度
     *
     * @param head
     * @return
     */
    public static int process(TreeNode head) {
        if (head.left == null && head.right == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (head.left != null) {
            minDepth = Math.min(process(head.left), minDepth);
        }
        if (head.right != null) {
            minDepth = Math.min(process(head.right), minDepth);
        }
        return minDepth + 1;
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
        treeNode1.right = treeNode3;
        treeNode1.right.left = treeNode4;
        treeNode1.right.right = treeNode5;
        System.out.println(minDepth(treeNode1));
    }
}
