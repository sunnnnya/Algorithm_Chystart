package job_interview.code_top.tree.binary_tree;

import job_interview.code_top.tree.TreeNode;

/**
 * @BelongsPackage: job_interview.code_top.tree.binary_tree
 * @ClassName: LowestCommonAncestor
 * @Author: 丛虹羽
 * @Date: 2025/5/10 11:32
 * @Description: 二叉树的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
public class LowestCommonAncestor {

    /**
     * 测试
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode lNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rNode = lowestCommonAncestor(root.right, p, q);
        if(lNode != null && rNode != null) {
            return root;
        }
        return lNode != null ? lNode : rNode;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;
        System.out.println(lowestCommonAncestor(node3, node5, node8).val);
        // 3
    }
}
