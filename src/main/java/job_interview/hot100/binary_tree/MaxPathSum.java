package job_interview.hot100.binary_tree;

/**
 * @BelongsPackage: job_interview.hot100.binary_tree
 * @ClassName: MaxPathSum
 * @Author: 丛虹羽
 * @Date: 2025/8/6 23:10
 * @Description: 二叉树中的最大路径和
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class MaxPathSum {

    // 二叉树的节点信息
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static int ans = Integer.MIN_VALUE;

    /**
     * 获取数中最大的路径长度信息
     *
     * @param root 根节点
     * @return int
     */
    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    /**
     * 向上拼接的最大路径
     *
     * @param node 节点
     * @return int
     */
    private static int dfs(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftValue = dfs(node.left);
        int rightValue = dfs(node.right);
        ans = Math.max(ans, leftValue + rightValue + node.val);
        // 截断直接不选
        return Math.max(Math.max(leftValue, rightValue) + node.val, 0);
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
        node1.left = node2;
        node1.right = node3;
        System.out.println(maxPathSum(node1));
        // 3
    }
}
