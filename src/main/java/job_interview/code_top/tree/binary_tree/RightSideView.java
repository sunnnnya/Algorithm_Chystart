package job_interview.code_top.tree.binary_tree;

import job_interview.code_top.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: job_interview.code_top.tree.binary_tree
 * @ClassName: RightSideView
 * @Author: 丛虹羽
 * @Date: 2025/5/11 11:03
 * @Description: 二叉树的右视图
 * https://leetcode.cn/problems/binary-tree-right-side-view/description/
 */
public class RightSideView {

    /**
     * 利用层高获取树的右视图
     *
     * @param root 根节点
     * @return List<Integer>
     */
    static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }

    /**
     * 深度优先搜索
     *
     * @param root 树的根节点
     * @param l    List
     * @param h    tree high
     */
    static void dfs(TreeNode root, List<Integer> l, int h) {
        if(root == null) {
            return ;
        }
        if(l.size() == h) {
            l.add(root.val);
        }
        dfs(root.right, l, h + 1);
        dfs(root.left, l, h + 1);
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
