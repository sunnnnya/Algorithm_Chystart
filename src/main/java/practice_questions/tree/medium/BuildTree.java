package practice_questions.tree.medium;

import practice_questions.tree.base.TreeNode;

/**
 * @BelongsPackage: practice_questions.tree.middle
 * @ClassName: BuildTree
 * @Author: 丛虹羽
 * @Date: 2024/7/28 上午9:05
 * @Description: 根据先序和中序顺序，构建一棵树
 * leetcode:https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class BuildTree {

    /**
     * 构建二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return f(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 有一棵树，先序遍历结果是：pre[l1,...,r1]，中序遍历结果是：in[l2,...,r2]
     *
     * @param pre 先序遍历的数组
     * @param l1 左侧下标
     * @param r1 右侧下标
     * @param in 中序遍历的数组
     * @param l2 左侧下标
     * @param r2 右侧下标
     * @return
     */
    public static TreeNode f(int[] pre, int l1, int r1, int[] in, int l2, int r2) {
        if (r1 < l1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[l1]);
        if (l1 == r1) {
            return head;
        }
        int find = l2;
        while (in[find] != pre[l1]) {
            find++;
        }
        head.left = f(pre, l1 + 1, l1 + find - l2, in, l2, find - 1);
        head.right = f(pre, l1 + find - l2 + 1, r1, in, find + 1, r2);
        return head;
    }

    public static void main(String[] args) {

    }
}
