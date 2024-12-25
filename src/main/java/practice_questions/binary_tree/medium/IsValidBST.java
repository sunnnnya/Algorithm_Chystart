package practice_questions.binary_tree.medium;

import practice_questions.binary_tree.base.TreeNode;

/**
 * @BelongsPackage: practice_questions.binary_tree.medium
 * @ClassName: IsValidBST
 * @Author: 丛虹羽
 * @Date: 2024/12/25 下午5:41
 * @Description: 验证二叉搜索树
 *
 * leetcode: https://leetcode.cn/problems/validate-binary-search-tree
 */
public class IsValidBST {

    public static long min, max;

    /**
     * 递归的使用，要充分的理解递归的使用，实在不行的时候直接画递归序列
     *
     * @param root 二叉树的根节点
     * @return
     */
    public static boolean isValidBST1(TreeNode root) {
        return isValidBST1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 递归函数的使用
     *
     * @param cur   当前节点的值
     * @param left  左边届
     * @param right 右边界
     * @return
     */
    private static boolean isValidBST1(TreeNode cur, long left, long right) {
        // base case
        if(cur == null) {
            return true;
        }
        long x = cur.val;
        return left < x && x < right &&
                isValidBST1(cur.left, left, x) &&
                isValidBST1(cur.right, x, right);
    }

    /**
     * 递归的使用，要充分的理解递归的使用，实在不行的时候直接画递归序列
     *
     * @param root 二叉树的根节点
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        if(root == null) {
            min = Long.MAX_VALUE;
            max = Long.MIN_VALUE;
            return true;
        }
        boolean lok = isValidBST(root.left);
        long lmin = min;
        long lmax = max;
        boolean rok = isValidBST(root.right);
        long rmin = min;
        long rmax = max;
        min = Math.min(Math.min(lmin, rmin), root.val);
        max = Math.max(Math.max(lmax, rmax), root.val);
        return lok && rok && root.val > lmax && root.val < rmin;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        node5.left = node1;
        node5.right = node4;
        node4.left = node3;
        node4.right = node6;
        System.out.println(isValidBST(node5));
        // false
    }
}
