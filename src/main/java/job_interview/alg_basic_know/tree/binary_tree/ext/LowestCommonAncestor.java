package job_interview.alg_basic_know.tree.binary_tree.ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.tree.binary_tree.ext
 * @ClassName: LowestCommonAncestor
 * @Author: 丛虹羽
 * @Date: 2025/5/1 11:17
 * @Description: 二叉树的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
public class LowestCommonAncestor {

    /**
     * 获取最近的公共祖先
     *
     * @param root 根节点
     * @param p    p 节点
     * @param q    q 节点
     * @return TreeNode
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if(l != null && r != null) {
            return root;
        }
        return l != null ? l : r;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;
        node5.left = node6;
        node5.right = node2;
        root.left = node5;
        root.right = node1;
        System.out.println(lowestCommonAncestor(root, node6, node4).val);
        // 5
    }
}
