package practice_questions.binary_tree.medium;

import practice_questions.binary_tree.base.TreeNode;
import java.util.ArrayList;
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
        List<List<Integer>> ans = new ArrayList<>();
        if(root != null) {
            List<Integer> path = new ArrayList<>();
            process(root, targetSum, 0, path, ans);
        }
        return ans;
    }

    /**
     * 递归函数
     *
     * @param node      节点
     * @param targetSum 目标值
     * @param sum       当前路径的总和信息
     * @param path      List<Integer> 路径
     * @param ans       最终的答案
     */
    private static void process(TreeNode node, int targetSum, int sum, List<Integer> path, List<List<Integer>> ans) {
        // 说明根节点，并且相加的总和 == targetSum
        if(node.left == null && node.right == null) {
            if(node.val + sum == targetSum) {
                path.add(node.val);
                copy(path, ans);
                path.remove(path.size() - 1);
            }
        } else {
            path.add(node.val);
            if(node.left != null) {
                process(node.left, targetSum, sum + node.val, path, ans);
            }
            if(node.right != null) {
                process(node.right, targetSum, sum + node.val, path, ans);
            }
            path.remove(path.size() - 1);
        }
    }

    /**
     * 进行数组的复制
     *
     * @param path 某一个符合条件的路径
     * @param ans  最终答案
     */
    private static void copy(List<Integer> path, List<List<Integer>> ans) {
        List<Integer> copy = new ArrayList<>(path);
        ans.add(copy);
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