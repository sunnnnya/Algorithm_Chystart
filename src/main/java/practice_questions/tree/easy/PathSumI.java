package practice_questions.tree.easy;

import practice_questions.tree.base.TreeNode;

/**
 * @BelongsPackage: practice_questions.tree.easy
 * @ClassName: PathSum
 * @Author: 丛虹羽
 * @Date: 2024/7/28 下午5:07
 * @Description:
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false
 *
 * leetcode：https://leetcode.cn/problems/path-sum/description/
 */
public class PathSumI {

    // 全局使用的变量
    public static boolean isSum = false;

    /**
     * 返回是右包含路径信息
     *
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        isSum = false;
        process(root, 0, sum);
        return isSum;
    }

    /**
     * 递归函数
     *
     * @param curNode 当前的节点
     * @param preSum  当前节点之前的节点的和信息
     * @param sum     指定路径的和
     */
    public static void process(TreeNode curNode, int preSum, int sum) {
        // 是叶子节点
        if (curNode.left == null && curNode.right == null) {
            // 找到了路径
            if (curNode.value + preSum == sum) {
                isSum = true;
            }
            return;
        }
        // 进行结果的相加
        preSum += curNode.value;
        // 左节点不空的时候斤西瓜累加， 回退的时候，preSum的值自动就是加了 curNode.value 之前的值
        if (curNode.left != null) {
            process(curNode.left, preSum, sum);
        }
        if (curNode.right != null) {
            process(curNode.right, preSum, sum);
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(11);
        TreeNode treeNode5 = new TreeNode(13);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(2);
        TreeNode treeNode9 = new TreeNode(1);
        treeNode1.left = treeNode2;
        treeNode1.left.left = treeNode4;
        treeNode1.left.left.left = treeNode7;
        treeNode1.left.left.right = treeNode8;
        treeNode1.right = treeNode3;
        treeNode1.right.left = treeNode5;
        treeNode1.right.right = treeNode6;
        treeNode1.right.right.right = treeNode9;
        System.out.println(hasPathSum(treeNode1, 22));
        // true
    }
}
