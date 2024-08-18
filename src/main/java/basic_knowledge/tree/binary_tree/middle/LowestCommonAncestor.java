package basic_knowledge.tree.binary_tree.middle;

import practice_questions.binary_tree.base.TreeNode;

/**
 * @BelongsPackage: basic_knowledge.tree.binary_tree.middle
 * @ClassName: LCA
 * @Author: 丛虹羽
 * @Date: 2024/8/18 上午11:19
 * @Description: 树上最低公共祖先问题
 *
 * 给定一棵二叉树的头节点 head，和另外两个节点 a 和 b，返回a和b的最低公共祖先。
 */
public class LowestCommonAncestor {

    /**
     * 信息体的抽象
     */
    public static class Info {
        // 树上发没发现 a 节点
        public boolean findA;
        // 树上发没发现 b 节点
        public boolean findB;
        // 树上发没发现 答案
        public TreeNode ans;

        public Info (boolean findA, boolean findB, TreeNode ans) {
            this.findA = findA;
            this.findB = findB;
            this.ans = ans;
        }
    }

    /**
     * 递归函数
     *
     * @param root
     * @param a
     * @param b
     * @return
     */
    public static Info process(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return new Info(false, false, null);
        }
        Info leftInfo = process(root.left, a, b);
        Info rightInfo = process(root.right, a, b);
        // 如果当前节点是A，或者左树找到了A，或者右树找到了A
        boolean findA = (root == a) || leftInfo.findA || rightInfo.findA;
        boolean findB = (root == b) || leftInfo.findB || rightInfo.findB;
        TreeNode ans = null;
        if (leftInfo.ans != null) {
            ans = leftInfo.ans;
        } else if (rightInfo.ans != null) {
            ans = rightInfo.ans;
        } else {
            if (findA && findB) {
                ans = root;
            }
        }
        return new Info(findA, findB, ans);
    }

    /**
     * 主函数
     *
     * @param root 根节点信息
     * @param a    a节点信息
     * @param b    b节点信息
     * @return     a和b节点在以head为根的树上的LCA
     */
    public static TreeNode lowestAncestor(TreeNode root, TreeNode a, TreeNode b) {
        return process(root, a, b).ans;
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
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode5.right = treeNode7;
        treeNode5.left = treeNode6;
        //                  1
        //                 / \
        //                2   3
        //               / \
        //              4   5
        //                 / \
        //                6   7
        System.out.println(lowestAncestor(treeNode1, treeNode6, treeNode7).val);
        // 5

        System.out.println(lowestAncestor(treeNode1, treeNode4, treeNode6).val);
        // 2

        System.out.println(lowestAncestor(treeNode1, treeNode3, treeNode7).val);
        // 1
    }
}
