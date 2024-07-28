package practice_questions.tree.easy;

import practice_questions.tree.base.TreeNode;

/**
 * @BelongsPackage: practice_questions.tree
 * @ClassName: IsMirrotTree
 * @Author: 丛虹羽
 * @Date: 2024/7/28 上午12:51
 * @Description:
 * 是否是镜面树， 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * leetcode：https://leetcode.cn/problems/symmetric-tree/description/
 */
public class IsMirrorTree {

    /**
     * 判断一个树是否是镜面树
     *
     * @param root
     * @return
     */
    private static boolean isMirrorTree(TreeNode root) {
        return isMirror(root, root);
    }

    /**
     * 判断一个树是否是镜面树
     *
     * @param root
     * @return
     */
    private static boolean isMirror(TreeNode root, TreeNode root1) {
        // 一个空、一个不空肯定不是镜像树
        if(root == null ^ root1 == null) {
            return false;
        }
        if (root == null && root1 == null) {
            return true;
        }
        return (root.value == root1.value) && isMirror(root.left, root1.right) && isMirror(root.right, root1.left);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        System.out.println(isMirrorTree(treeNode1)); // true

        TreeNode treeNode4 = new TreeNode(1);
        treeNode4.left = new TreeNode(2);
        System.out.println(isMirrorTree(treeNode4)); // false
    }
}
