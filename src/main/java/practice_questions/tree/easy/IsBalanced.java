package practice_questions.tree.easy;

import practice_questions.tree.base.TreeNode;

/**
 * @BelongsPackage: practice_questions.tree.easy
 * @ClassName: IsBalanced
 * @Author: 丛虹羽
 * @Date: 2024/8/6 下午8:33
 * @Description: 检查平衡性
 *
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 */
public class IsBalanced {

    /**
     * 直接判断左右子树的高度差
     *
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(process(root.left) - process(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(process(root.left), process(root.right)) + 1;
    }

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
