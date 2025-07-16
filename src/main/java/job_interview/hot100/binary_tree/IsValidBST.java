package job_interview.hot100.binary_tree;

/**
 * @BelongsPackage: job_interview.hot100.binary_tree
 * @ClassName: IsValidBST
 * @Author: 丛虹羽
 * @Date: 2025/7/16 11:42
 * @Description: 验证二叉搜索树
 * https://leetcode.cn/problems/validate-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class IsValidBST {

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

    private static long pre = Long.MIN_VALUE;

    /**
     * 验证是否是二叉搜索树
     *
     * @param root 二叉树的根节点
     * @return true | false
     */
    public static boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(!isValidBST(root.left)) {
            return false;
        }
        if(root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;

        System.out.println(isValidBST(node2));
        // true
    }
}
