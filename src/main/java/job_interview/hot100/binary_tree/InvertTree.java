package job_interview.hot100.binary_tree;

/**
 * @BelongsPackage: job_interview.hot100.binary_tree
 * @ClassName: InvertTree
 * @Author: 丛虹羽
 * @Date: 2025/7/15 21:24
 * @Description: 翻转二叉树
 * https://leetcode.cn/problems/invert-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class InvertTree {

    /**
     * 树中的节点
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
     * 反转树
     *
     * @param root 树的根节点
     * @return TreeNode
     */
    public static TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        TreeNode tmpNode = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmpNode);
        return root;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        // TODO: 暂时不模拟了
    }
}
