package job_interview.hot100.binary_tree;

/**
 * @BelongsPackage: job_interview.hot100.binary_tree
 * @ClassName: IsSymmetric
 * @Author: 丛虹羽
 * @Date: 2025/7/15 22:00
 * @Description: 对称二叉树
 * https://leetcode.cn/problems/symmetric-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class IsSymmetric {

    /**
     *树的节点
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
     * 对称二叉树
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
     * 判断两个根节点的树是否相同
     *
     * @return
     */
    private static boolean dfs(TreeNode node1, TreeNode node2) {
        if(node1 == null || node2 == null) {
            return node1 == node2;
        }
        return node1.val == node2.val && dfs(node1.left, node2.right) && dfs(node1.right, node2.left);
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node44 = new TreeNode(4);
        TreeNode node33 = new TreeNode(3);

        node1.left = node2;
        node1.right = node22;
        node2.left = node3;
        node2.right = node4;
        node22.left = node44;
        node22.right = node33;

        System.out.println(isSymmetric(node1));
        // true
    }
}
