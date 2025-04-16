package job_interview.alg_basic_know.tree.binary_tree.ext;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: job_interview.alg_basic_know.tree.binary_tree.ext
 * @ClassName: RightSideView
 * @Author: 丛虹羽
 * @Date: 2025/4/16 18:00
 * @Description: 二叉树的右视图
 * https://leetcode.cn/problems/binary-tree-right-side-view/
 */
public class RightSideView {

    /**
     * 二叉树左视图
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
     * 函数含义：以当前root节点为根
     *      二叉树的右视图遍历
     *
     * @param root 根节点
     * @param list 列表
     */
    private static void dfs(TreeNode root, List<Integer> list, int level) {
        if(root == null) {
            return;
        }
        if(level == list.size()) {
            list.add(root.val);
        }
        dfs(root.right, list, level + 1);
        dfs(root.left, list, level + 1);
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
        node1.right = node3;
        node1.left = node2;
        node1.left.left = node4;
        node4.left = node5;
        System.out.println(rightSideView(node1));
        // [1, 3, 4, 5]
    }
}
