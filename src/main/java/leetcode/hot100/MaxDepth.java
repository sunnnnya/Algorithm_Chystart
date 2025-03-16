package leetcode.hot100;

import leetcode.skill.tree.TreeNode;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-16 21:49
 * @description: 二叉树的最大深度
 *
 * leetcode：https://leetcode.cn/problems/maximum-depth-of-binary-tree/?envType=study-plan-v2&envId=top-100-liked
 **/
public class MaxDepth {

    /**
     * 递归函数的涵义
     *
     * @param root 树的根节点信息
     * @return 树的最大深度
     */
    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return dfs(root);
    }

    /**
     * 递归函数
     *
     * @param root 根节点信息
     * @return 最大的深度
     */
    public static int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println("maxLength: " + maxDepth(node1));
        // maxLength: 3
    }
}
