package leetcode.hot100;

import leetcode.skill.tree.TreeNode;

/**
 * @BelongsPackage: leetcode.hot100
 * @ClassName: DiameterOfBinaryTree
 * @Author: 丛虹羽
 * @Date: 2025/3/18 21:45
 * @Description: 二叉树的直径
 *
 * leetcode: https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class DiameterOfBinaryTree {

    public static int ans = 0;

    /**
     * 递归函数的定义：
     *  经过当前节点的最大深度
     *
     * @param root 树的根节点
     * @return 返回最大的长度信息
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    /**
     * 经过当前节点的最大的直径信息 = 左边链的长度 + 右边链的长度
     *
     * @param root
     * @return
     */
    public static int dfs(TreeNode root) {
        // 有的时候节点的值返回的值总是差固定数组的话，可以就考虑返回的basecase的数值。
        if(root == null) {
            return -1;
        }
        int lLen = dfs(root.left) + 1;
        int rLen = dfs(root.right) + 1;
        // 计算的是经过当前节点的最大直径
        ans = Math.max(ans, lLen + rLen);
        // 但实际计算的时候返回的是经过的左子树和右子树的最大步长
        return Math.max(lLen, rLen);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        System.out.println("Result: " + diameterOfBinaryTree(node1));
        // Result: 3

        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(2);
        node6.left = node7;
        System.out.println("Result: " + diameterOfBinaryTree(node6));
        // Result: 1
    }
}
