package practice_questions.binary_tree.easy;

import practice_questions.binary_tree.base.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: practice_questions.binary_tree.easy
 * @ClassName: LeafSimilar
 * @Author: 丛虹羽
 * @Date: 2024/12/22 下午11:11
 * @Description: 叶子相似的树
 *
 * leetcode: https://leetcode.cn/problems/leaf-similar-trees
 */
public class LeafSimilar {

    /**
     * 经典 dfs 找到树中的节点进行返回
     *
     * @param root1 根节点 1
     * @param root2 根节点 2
     * @return
     */
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        dfs(root1, l1);
        List<Integer> l2 = new ArrayList<>();
        dfs(root2, l2);
        return l1.equals(l2);
    }

    /**
     * 当扫描到叶子节点时才加入到集合中，反之就进行递归
     *
     * @param node
     * @param l
     */
    private static void dfs(TreeNode node, List<Integer> l) {
        if(node.left == null && node.right == null) {
            l.add(node.val);
        } else {
            if(node.left != null) {
                dfs(node.left, l);
            }
            if(node.right != null) {
                dfs(node.right, l);
            }
        }
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
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(3);
        treeNode4.left = treeNode6;
        treeNode4.right = treeNode5;
        System.out.println(leafSimilar(treeNode1, treeNode4));
        // false

        TreeNode treeNode7 = new TreeNode(1);
        TreeNode treeNode8 = new TreeNode(2);
        TreeNode treeNode9 = new TreeNode(3);
        treeNode7.left = treeNode8;
        treeNode7.right = treeNode9;

        TreeNode treeNode10 = new TreeNode(1);
        TreeNode treeNode11 = new TreeNode(2);
        TreeNode treeNode12 = new TreeNode(3);
        treeNode10.left = treeNode11;
        treeNode10.right = treeNode12;
        System.out.println(leafSimilar(treeNode7, treeNode10));
        // true
    }
}