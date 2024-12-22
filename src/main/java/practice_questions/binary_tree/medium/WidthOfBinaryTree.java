package practice_questions.binary_tree.medium;

import practice_questions.binary_tree.base.TreeNode;

/**
 * @BelongsPackage: practice_questions.binary_tree.medium
 * @ClassName: WidthOfBinaryTree
 * @Author: 丛虹羽
 * @Date: 2024/12/22 下午6:03
 * @Description: 二叉树最大宽度
 *
 * leetcode： https://leetcode.cn/problems/maximum-width-of-binary-tree
 */
public class WidthOfBinaryTree {

    public static final int MAXN = 3001;

    public static TreeNode[] nq = new TreeNode[MAXN];

    public static int[] iq = new int[MAXN];

    public static int l, r;


    /**
     * 多使用了一个技巧，就是对每个节点进行了编号，然后使用编号的插值进行计算
     *
     * @param root 根节点
     * @return
     */
    public static int widthOfBinaryTree(TreeNode root) {
        int ans = 1;
        l = r = 0;
        nq[r] = root;
        iq[r++] = 1;
        while(l < r) {
            // 这个 size 表示的是一个层级中的节点的个数
            int size = r - l;
            ans = Math.max(ans, iq[r - 1] - iq[l] + 1);
            for(int i = 0; i < size; i++) {
                TreeNode cur = nq[l];
                int id = iq[l++];
                if(cur.left != null) {
                    nq[r] = cur.left;
                    iq[r++] = id * 2;
                }
                if(cur.right != null) {
                    nq[r] = cur.right;
                    iq[r++] = id * 2 + 1;
                }
            }
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(9);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode4.left = treeNode6;
        treeNode3.right = treeNode5;
        treeNode5.left = treeNode7;
        System.out.println(widthOfBinaryTree(treeNode1));
        //
    }
}
