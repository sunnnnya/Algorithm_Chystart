package practice_questions.tree.easy;

import practice_questions.tree.base.TreeNode;

/**
 * @BelongsPackage: practice_questions.tree
 * @ClassName: SameTree
 * @Author: 丛虹羽
 * @Date: 2024/7/28 上午12:37
 * @Description:
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * leetcode: https://leetcode.cn/problems/same-tree
 */
public class SameTree {


    public static boolean sameTree(TreeNode head1, TreeNode head2) {
        // 1 0、0 1 -> 1
        if (head1 == null ^ head2 == null) {
            return false;
        }
        if (head1 == null && head2 == null) {
            return true;
        }
        // 节点信息相等，左树相等，右树相等 成功
        return head1.value == head2.value && sameTree(head1.left, head2.left) && sameTree(head1.right, head2.right);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.left = treeNode2;

        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(2);
        treeNode3.right = treeNode4;

        System.out.println(sameTree(treeNode1, treeNode3)); // false

        TreeNode treeNode5 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(3);
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode7;

        TreeNode treeNode8 = new TreeNode(1);
        TreeNode treeNode9 = new TreeNode(2);
        TreeNode treeNode10 = new TreeNode(3);
        treeNode8.left = treeNode9;
        treeNode8.right = treeNode10;
        System.out.println(sameTree(treeNode8, treeNode5)); // true
    }
}
