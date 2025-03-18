package leetcode.hot100;

import leetcode.skill.tree.TreeNode;

/**
 * @BelongsPackage: leetcode.hot100
 * @ClassName: IsSymmetric
 * @Author: 丛虹羽
 * @Date: 2025/3/18 22:16
 * @Description: 对称二叉树
 *
 * leetcode: https://leetcode.cn/problems/symmetric-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class IsSymmetric {

    /**
     * 递归函数的含义
     *
     * @param root 树的根节点
     * @return true | false
     */
    public static boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    /**
     * 判断以 node1 和 node2 为根的两棵子树是否镜像对称。
     *
     * @param node1 树的根节点一
     * @param node2 树的根节点二
     * @return true | false
     */
    public static boolean dfs(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == node2;
        }
        return node1.val == node2.val && // 节点的值相等是前提
                dfs(node1.left, node2.right) && // 左树根节点的左树 和 右树根节点的右树镜像
                dfs(node1.right, node2.left); // 左树根节点的左树 和 右树根节点的右树镜像
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println("Result: " + isSymmetric(node1));
        // Result: true
    }
}
