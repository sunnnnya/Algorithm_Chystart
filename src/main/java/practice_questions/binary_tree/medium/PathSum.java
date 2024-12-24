package practice_questions.binary_tree.medium;

import practice_questions.binary_tree.base.TreeNode;

import java.util.List;

/**
 * @BelongsPackage: practice_questions.binary_tree.medium
 * @ClassName: PathSum
 * @Author: 丛虹羽
 * @Date: 2024/12/24 下午1:10
 * @Description: 路径总和 II
 *
 * leetcode: https://leetcode.cn/problems/path-sum-ii
 */
public class PathSum {

    /**
     * 递归恢复现场技巧
     *
     * @param root      根节点
     * @param targetSum 目标值
     * @return
     */
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return null;
    }

    /**
     * 打印二维动态数组
     *
     * @param list
     */
    private static void print(List<List<Integer>> list) {
        for(List<Integer> l : list) {
            System.out.print(l);
        }
        System.out.println();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node13 = new TreeNode(13);
        TreeNode node4_2 = new TreeNode(4);
        TreeNode node5_2 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        node5.left = node4;
        node5.right = node8;
        node4.left = node11;
        node11.left = node7;
        node11.right = node2;
        node8.left = node13;
        node8.right = node4_2;
        node4_2.left = node5_2;
        node4_2.right = node1;
        print(pathSum(node5, 22));
        //
    }
}