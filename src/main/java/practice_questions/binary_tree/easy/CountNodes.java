package practice_questions.binary_tree.easy;

import practice_questions.binary_tree.base.TreeNode;

/**
 * @BelongsPackage: practice_questions.tree.easy
 * @ClassName: CountNodes
 * @Author: 丛虹羽
 * @Date: 2024/8/6 下午9:24
 * @Description: 完全二叉树的节点个数
 *
 * leetcode： https://leetcode.cn/problems/count-complete-tree-nodes
 */
public class CountNodes {

    /**
     * 求二叉树中的节点个数，使用传统的方式进行遍历，时间复杂度 O（n）
     *
     * @param root
     * @return
     */
    public static int countNodes1(TreeNode root) {
        return root == null ? 0 : countNodes1(root.right) + countNodes1(root.left) + 1;
    }

    /**
     * 使用性质进行处理，因为题目中已经明确是完全二叉树，索引拿到左侧最左的高度，然后右子树的高度
     *  （1）如果高度信息一样，则左子树使用 满二叉树性质，右侧使用递归
     *  （2）如果高度不一样，右子树使用满二叉树性质，左侧使用递归
     *
     * @param root
     * @return
     */
    public static int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return leftDepth == rightDepth ?
                (int)Math.pow(2, leftDepth) - 1 + getCount(root.right) + 1:
                (int)Math.pow(2, rightDepth) - 1 + getCount(root.left) + 1;
    }

    /**
     * 获取左树或者右树的高度信息
     *
     * @param node
     * @return
     */
    private static int getDepth(TreeNode node) {
        int count = 0;
        for(; node != null; node = node.left) {
            count++;
        }
        return count;
    }

    /**
     * 获取子树的节点的个数
     *
     * @param node
     * @return
     */
    private static int getCount(TreeNode node) {
        return node == null ? 0 : getCount(node.left) + getCount(node.right) + 1;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode6;
        System.out.println(countNodes(treeNode1));
        // 6

        System.out.println(countNodes(null));
        // 0

        System.out.println(countNodes(new TreeNode(1)));
        // 1
    }
}
