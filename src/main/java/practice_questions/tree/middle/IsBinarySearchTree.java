package practice_questions.tree.middle;

import practice_questions.tree.base.TreeNode;

/**
 * @BelongsPackage: practice_questions.tree.middle
 * @ClassName: SearchBinaryTree
 * @Author: 丛虹羽
 * @Date: 2024/7/28 下午2:55
 * @Description: 是否是搜素二叉树：任意一个节点的值，左子树均小于当前节点，右子树均大于当前节点
 *
 * 如何判断一个树是搜素二叉树：二叉树的中序遍历，是严格递增的就是搜素二叉树
 */
public class IsBinarySearchTree {

    public static class Info {
        // 是否是二叉搜索树
        public boolean isBST;
        // 最大值
        public int max;
        // 整棵树的最小值
        public int min;
        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    public static Info process(TreeNode root) {
        if (root == null) {
           return null;
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int max = root.value;
        int min = root.value;
        if (leftInfo != null) {
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.min, min);
        }
        if (rightInfo != null) {
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
        }
        boolean isBST = true;
        if (leftInfo != null && !leftInfo.isBST) {
            isBST = false;
        }
        if (rightInfo != null && !rightInfo.isBST) {
            isBST = false;
        }
        // left Max < x    right min > x
        boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.max < root.value);
        boolean rightMinMoreX = rightInfo == null ? true : (rightInfo.min > root.value);
        if(!leftMaxLessX || !rightMinMoreX) {
            isBST = false;
        }
        return new Info(isBST, max, min);
    }

    /**
     * 判断是否是二叉排序树
     *
     * @param root
     * @return
     */
    private static boolean isSearchBinaryTree(TreeNode root) {
        return process(root).isBST;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(5);
        TreeNode treeNode7 = new TreeNode(0);
        treeNode1.left = treeNode2;
        treeNode1.left.left = treeNode4;
        treeNode1.left.right = treeNode5;
        treeNode1.right = treeNode3;
        treeNode1.right.left = treeNode6;
        treeNode1.right.right = treeNode7;
        System.out.println(isSearchBinaryTree(treeNode1));
    }
}
