package leetcode.skill.tree.binary_tree;

import leetcode.skill.tree.TreeNode;

/**
 * @package: leetcode.skill.tree.binary_tree
 * @author: chystart
 * @create: 2025-03-11 10:59
 * @description: 二叉树的三种递归遍历
 **/
public class BinaryTreeRecursiveTraversal {

    /**
     * 先序遍历
     *
     * @param root 二叉树的根节点
     */
    public static void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     *
     * @param root 二叉树的根节点
     */
    public static void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    /**
     * 后序遍历
     *
     * @param root 二叉树的根节点
     */
    public static void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        // 先序遍历
        System.out.print("先序遍历：");
        preOrder(node1);
        System.out.println();

        // 中序遍历
        System.out.print("中序遍历：");
        inOrder(node1);
        System.out.println();

        // 后序遍历
        System.out.print("后序遍历：");
        postOrder(node1);
        System.out.println();
    }
}
