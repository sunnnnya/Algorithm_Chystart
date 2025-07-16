package job_interview.hot100.binary_tree;

/**
 * @BelongsPackage: job_interview.hot100.binary_tree
 * @ClassName: KthSmallest
 * @Author: 丛虹羽
 * @Date: 2025/7/16 19:46
 * @Description: 二叉搜索树中第 K 小的元素
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class KthSmallest {

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

    private int k ;
    private int ans;

    /**
     * 中序遍历找寻结点
     *
     * @param root 二叉树的根节点
     * @param k k 个数值
     * @return int
     */
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }

    /**
     * 获取指定二叉树中的 k 个节点信息
     *
     * @param root 节点
     */
    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        if(k == 0) {
            return ;
        }
        if(--k == 0) {
            ans = root.val;
        }
        dfs(root.right);
    }
}
