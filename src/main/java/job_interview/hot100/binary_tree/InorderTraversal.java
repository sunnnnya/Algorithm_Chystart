package job_interview.hot100.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: job_interview.hot100.binary_tree
 * @ClassName: InorderTraversal
 * @Author: 丛虹羽
 * @Date: 2025/7/15 16:47
 * @Description: 二叉树的中序遍历
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class InorderTraversal {

    /**
     * 二叉树结点信息
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
     * 二叉树中序遍历
     *
     * @param root 二叉树的根节点
     * @return List<Integer>
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        process(root, ans);
        return ans;
    }

    /**
     * 中序遍历模板
     *
     * @param root 二叉树的根节点信息
     * @param ans  答案结果
     */
    private static void process(TreeNode root, List<Integer> ans) {
        if(root == null) {
            return ;
        }
        process(root.left, ans);
        ans.add(root.val);
        process(root.right, ans);
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
        node1.right = node2;
        node2.left = node3;
        List<Integer> inorderTraversalList = inorderTraversal(node1);
        System.out.println("inorderTraversalList = " + inorderTraversalList);
        // inorderTraversalList = [1, 3, 2]
    }
}
