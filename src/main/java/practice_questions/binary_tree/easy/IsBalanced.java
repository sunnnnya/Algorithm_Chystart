package practice_questions.binary_tree.easy;

import practice_questions.binary_tree.base.TreeNode;

/**
 * @BelongsPackage: practice_questions.tree.easy
 * @ClassName: IsBalanced
 * @Author: 丛虹羽
 * @Date: 2024/8/6 下午8:33
 * @Description: 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是平衡二叉树？
 *
 * leetcode: https://leetcode.cn/problems/balanced-binary-tree
 */
public class IsBalanced {

    /**
     * 消息体
     */
    public static class Info {
        public boolean isBalanced;
        public int height;
        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    /**
     * 递归程序体
     *
     * @param root
     * @return
     */
    public static Info process(TreeNode root) {
        if (root == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        return new Info(leftInfo.isBalanced &&
                rightInfo.isBalanced &&
                Math.abs(leftInfo.height - rightInfo.height) <= 1,
                Math.max(leftInfo.height, rightInfo.height) + 1);
    }

    /**
     * 主方法
     *
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root).isBalanced;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 测试1
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        System.out.println(isBalanced(treeNode1));
        // true

        // 测试2
        TreeNode treeNode6 = new TreeNode(1);
        TreeNode treeNode7 = new TreeNode(2);
        TreeNode treeNode8 = new TreeNode(2);
        TreeNode treeNode9 = new TreeNode(3);
        TreeNode treeNode10 = new TreeNode(3);
        TreeNode treeNode11 = new TreeNode(4);
        TreeNode treeNode12 = new TreeNode(4);
        treeNode6.right = treeNode7;
        treeNode6.left = treeNode8;
        treeNode8.left = treeNode9;
        treeNode8.right = treeNode10;
        treeNode9.left = treeNode11;
        treeNode9.right = treeNode12;
        System.out.println(isBalanced(treeNode6));
        // false
    }
}
