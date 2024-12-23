package practice_questions.binary_tree.medium;

import practice_questions.binary_tree.base.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * @BelongsPackage: practice_questions.binary_tree.medium
 * @ClassName: IsCompleteTree
 * @Author: 丛虹羽
 * @Date: 2024/12/23 下午5:06
 * @Description: 二叉树的完全性检验
 *
 * leetcode: https://leetcode.cn/problems/check-completeness-of-a-binary-tree/description/?envType=problem-list-v2&envId=nbQFMpWe
 */
public class IsCompleteTree {

    public static final int MAXN = 101;

    public static TreeNode[] queue = new TreeNode[MAXN];

    public static int l, r;

    /**
     * 完全二叉树的性质，有右无左 false, 有左无右之后节点全是叶节点
     *
     * @param root 根节点
     * @return
     */
    public static boolean isCompleteTree(TreeNode root) {
        l = r = 0;
        queue[r++] = root;
        boolean leaf = false;
        while(l < r) {
            TreeNode node = queue[l++];
            if((node.left == null && node.right != null) || (leaf && (node.left != null || node.right != null))) {
                return false;
            }
            if(node.left != null) {
                queue[r++] = node.left;
            }
            if(node.right != null) {
                queue[r++] = node.right;
            }
            // 说明遍历过叶节点
            if(node.left == null || node.right == null) {
                leaf = true;
            }
        }
        return true;
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
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        System.out.println(isCompleteTree(treeNode1));
        // true

        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode22 = new TreeNode(2);
        TreeNode treeNode33 = new TreeNode(3);
        TreeNode treeNode44 = new TreeNode(4);
        TreeNode treeNode55 = new TreeNode(5);
        TreeNode treeNode77 = new TreeNode(7);
        treeNode11.left = treeNode22;
        treeNode11.right = treeNode33;
        treeNode22.left = treeNode44;
        treeNode22.right = treeNode55;
        treeNode33.right = treeNode77;
        System.out.println(isCompleteTree(treeNode11));
        // fasle
    }
}
