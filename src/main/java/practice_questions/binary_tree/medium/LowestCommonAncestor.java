package practice_questions.binary_tree.medium;

import practice_questions.binary_tree.base.TreeNode;

/**
 * @BelongsPackage: practice_questions.binary_tree.medium
 * @ClassName: LowestCommonAncestor
 * @Author: 丛虹羽
 * @Date: 2024/12/24 下午12:51
 * @Description: 二叉搜索树的最低公共祖先
 *
 * leetcode: https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/?envType=problem-list-v2&envId=nbQFMpWe
 */
public class LowestCommonAncestor {

    /**
     * 利用二叉搜索树的性质最低公共祖先，每次完全能确定一部分节点是没用的，直接舍去
     *
     * @param root 二叉树的根节点
     * @param p    p 节点
     * @param q    q 节点
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // root 从上到下
        // 如果先遇到了 p，说明 p 是答案
        // 如果先遇到了 q，说明 q 是答案
        // 如果 root 在 p ~ q 值之间，不管 p 和 q 谁大谁小， 只要 root 在中间，此时的 root 就是答案
        // 如果 root 在 p ~ q 值的左侧，那么 root 往右移动
        // 如果 root 在 p ~ q 值的右侧，那么 root 往左移动
        while(root.val != p.val && root.val != q.val) {
            if(Math.min(p.val, q.val) < root.val && root.val < Math.max(p.val, q.val)) {
                break;
            }
            root = root.val < Math.min(p.val, q.val) ? root.right : root.left;
        }
        return root;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode8;
        treeNode2.left = treeNode0;
        treeNode2.right = treeNode4;
        treeNode4.left = treeNode3;
        treeNode4.right = treeNode5;
        treeNode8.left = treeNode7;
        treeNode8.right = treeNode9;
        System.out.println(lowestCommonAncestor(treeNode1, treeNode2, treeNode8).val);
        // 6

        System.out.println(lowestCommonAncestor(treeNode1, treeNode2, treeNode4).val);
        // 2
    }
}