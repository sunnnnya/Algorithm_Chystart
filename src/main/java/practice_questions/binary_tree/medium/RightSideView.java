package practice_questions.binary_tree.medium;

import practice_questions.binary_tree.base.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: practice_questions.binary_tree.medium
 * @ClassName: RightSideView
 * @Author: 丛虹羽
 * @Date: 2024/12/25 下午1:47
 * @Description: 二叉树的右视图
 *
 * leetcode: https://leetcode.cn/problems/binary-tree-right-side-view/
 */
public class RightSideView {

    /**
     * 递归：要合理的设计递归的参数！！！
     *      要理解整个递归函数想要表达的意思
     *
     * @param root 根节点
     * @return
     */
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }

    /**
     * 递归的使用，定义好参数 和 函数的意义
     *
     * @param node  当前节点
     * @param list  用来记录答案的集合
     * @param depth 表示当前遍历到的深度信息，用来决定是否进入集合中
     */
    private static void dfs(TreeNode node, List<Integer> list, int depth) {
        if(node == null) {
            return ;
        }
        if(depth == list.size()) {
            list.add(node.val);
        }
        dfs(node.right, list, depth + 1);
        dfs(node.left, list, depth + 1);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        node3.right = node4;
        node5.right = node6;
        System.out.println(rightSideView(node1));
        // [1, 3, 4, 6]
    }
}
