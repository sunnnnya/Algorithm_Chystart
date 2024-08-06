package practice_questions.tree.easy;

import practice_questions.tree.base.TreeNode;

/**
 * @BelongsPackage: practice_questions.tree.easy
 * @ClassName: CheckSymmetricTree
 * @Author: 丛虹羽
 * @Date: 2024/8/6 下午8:53
 * @Description: 判断对称二叉树
 *
 * 请设计一个函数判断一棵二叉树是否 轴对称 。
 *
 * leetcode：https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/description/
 */
public class CheckSymmetricTree {

    /**
     * 判断以root为根节点的树是不是镜像树
     *
     * @param root
     * @return
     */
    public static boolean checkSymmetricTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 拆分成两个节点进行判断
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode root, TreeNode root1) {
        if ((root == null) ^ (root1 == null)) {
            return false;
        }
        if (root == null && root1 == null) {
            return true;
        }
        return root.val == root1.val && isMirror(root.left, root1.right) && isMirror(root.right, root1.left);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(8);
        TreeNode treeNode5 = new TreeNode(9);
        TreeNode treeNode6 = new TreeNode(9);
        TreeNode treeNode7 = new TreeNode(8);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        System.out.println(checkSymmetricTree(treeNode1));
        // true

        TreeNode treeNode8 = new TreeNode(1);
        TreeNode treeNode9 = new TreeNode(2);
        TreeNode treeNode10 = new TreeNode(2);
        TreeNode treeNode11 = new TreeNode(3);
        TreeNode treeNode12 = new TreeNode(3);
        treeNode8.left = treeNode9;
        treeNode8.right = treeNode10;
        treeNode10.right = treeNode12;
        treeNode9.right = treeNode11;
        System.out.println(checkSymmetricTree(treeNode8));
        // false
    }
}
