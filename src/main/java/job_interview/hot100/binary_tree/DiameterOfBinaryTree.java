package job_interview.hot100.binary_tree;

/**
 * @BelongsPackage: job_interview.hot100.binary_tree
 * @ClassName: DiameterOfBinaryTree
 * @Author: 丛虹羽
 * @Date: 2025/7/16 11:01
 * @Description: 二叉树的直径
 * https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class DiameterOfBinaryTree {

    /**
     * 二叉树结点
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    private static int ans = 0;

    /**
     * 二叉树的直径
     *
     * @param root 二叉树的根节点
     * @return 直径大小
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    /**
     * 以 root 为根节点返回左树和右树中边数中最大的边数
     *
     * @param root 二叉树的根节点
     * @return 左树 或 右树 高度的最大值
     */
    private static int dfs(TreeNode root) {
        if(root == null) {
            return -1;
        }
        int llen = dfs(root.left);
        int rlen = dfs(root.right);
        ans = Math.max(ans, llen + rlen + 2);
        return Math.max(llen, rlen) + 1;
    }

    /**
     * 测试
     *
     * @param args 参数
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
        System.out.println(diameterOfBinaryTree(node1));
        // 3
    }
}
