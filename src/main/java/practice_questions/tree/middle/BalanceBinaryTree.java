package practice_questions.tree.middle;

import practice_questions.tree.base.TreeNode;

/**
 * @BelongsPackage: practice_questions.tree.middle
 * @ClassName: BalanceBinaryTree
 * @Author: 丛虹羽
 * @Date: 2024/7/28 下午2:05
 * @Description: 查看一个树是否是平衡二叉树
 * 平衡二叉树：左右子树的高度差绝对值  <= 1
 * leetcode：https://leetcode.cn/problems/balanced-binary-tree/
 */
public class BalanceBinaryTree {

    /**
     * 递归需要传递的信息，一定需要这个balance信息，需要传递的信息一定要存储在节点信息中
     */
    public static class Info {
        // 整个树是否平衡
        public boolean isBalanced;
        // 整个树的高度
        public int height;
        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    /**
     * 查看是否是平衡二叉树
     *
     * @param root 根节点信息
     * @return
     */
    public static Info process(TreeNode root) {
        // 空树的时候是平衡二叉树，高度为0
        if (root == null) {
            return new Info(true,0);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        // height：左树和右树最大的高度加上自己节点的高度 + 1
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        // 判断当前节点是否平衡
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced
                && Math.abs(leftInfo.height - rightInfo.height) < 2;
        return new Info(isBalanced, height);
    }

    /**
     * 查看树是否是二叉平衡树
     *
     * @param root
     * @return
     */
    public static boolean isBalancedTree(TreeNode root) {
        return process(root).isBalanced;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(4);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode1.left.right = treeNode4;
        treeNode1.left.right.right = treeNode5;
        System.out.println(isBalancedTree(treeNode1));
        // false
    }
}
