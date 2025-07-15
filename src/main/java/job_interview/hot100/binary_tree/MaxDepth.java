package job_interview.hot100.binary_tree;

/**
 * @BelongsPackage: job_interview.hot100.binary_tree
 * @ClassName: MaxDepth
 * @Author: 丛虹羽
 * @Date: 2025/7/15 20:58
 * @Description: 二叉树的最大深度
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class MaxDepth {

    /**
     * 二叉树的节点
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

    /**
     * 使用递归的方式获取树的最大深度
     *
     * @param root 根节点
     * @return 树的深度
     */
    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : (Math.max(maxDepth(root.left), maxDepth(root.right)) + 1);
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node1.left = node9;
        node1.right = node20;
        node20.left = node15;
        node20.right = node7;

        System.out.println(maxDepth(node1));
        // 3
    }
}
