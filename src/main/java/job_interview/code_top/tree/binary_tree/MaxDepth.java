package job_interview.code_top.tree.binary_tree;

import job_interview.code_top.tree.TreeNode;

/**
 * @BelongsPackage: job_interview.code_top.tree.binary_tree
 * @ClassName: MaxDepth
 * @Author: 丛虹羽
 * @Date: 2025/5/17 12:53
 * @Description: 二叉树的最大深度
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 */
public class MaxDepth {

    /**
     * 返回二叉树的最大深度信息
     *
     * @param root 根节点
     * @return int
     */
    static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        System.out.println("MaxDepth: " + maxDepth(node3));
        //
    }
}
