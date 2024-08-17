package practice_questions.tree.medium;

import practice_questions.tree.base.TreeNode;

/**
 * @BelongsPackage: practice_questions.tree.medium
 * @ClassName: IsFullBinaryTree
 * @Author: 丛虹羽
 * @Date: 2024/8/17 下午5:37
 * @Description: 判断是否是满二叉树
 * 思路：使用二叉树的递归讨论进行求解
 *      树形 dp 的基础
 */
public class IsFullBinaryTree {

    /**
     * 信息体
     */
    public static class Info {
        public int height;
        public int nodes;
        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    /**
     * 返回节点信息
     *
     * @param root
     * @return
     */
    public static boolean isFullBinaryTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        // 完全二叉树的高度和节点的个数之间的关系公式：2 ^ height - 1 = nodes
        return Math.pow(2, process(root).height) - 1 == process(root).nodes;
    }

    /**
     * 递归体
     *
     * @param root
     * @return
     */
    public static Info process(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
        return new Info(height, nodes);
    }

    /**
     * 高度和节点的关系做 信息体
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode6;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        System.out.println(isFullBinaryTree(treeNode1));
        // false

        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode12 = new TreeNode(12);
        TreeNode treeNode13 = new TreeNode(13);
        treeNode7.left = treeNode8;
        treeNode7.right = treeNode9;
        treeNode8.left = treeNode10;
        treeNode8.right = treeNode11;
        treeNode9.left = treeNode12;
        treeNode9.right = treeNode13;
        System.out.println(isFullBinaryTree(treeNode7));
        // true
    }
}
