package job_interview.hot100.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: job_interview.hot100.binary_tree
 * @ClassName: RightSideView
 * @Author: 丛虹羽
 * @Date: 2025/7/16 19:52
 * @Description: 二叉树的右视图
 * https://leetcode.cn/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class RightSideView {

    /**
     * 二叉树结点
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    /**
     * 获取数组右视图信息
     *
     * @param root 二叉树的各节点
     * @return List<Integer>
     */
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans, 0);
        return ans;
    }

    /**
     * 通过层级和树中结点的个数进行答案的统计
     *
     * @param root 二叉树的根节点
     * @param ans 答案列表
     * @param level 层级关系
     */
    private static void dfs(TreeNode root, List<Integer> ans, int level) {
        if(root == null) {
            return;
        }
        if(level == ans.size()) {
            ans.add(root.val);
        }
        // 如果需要尝试获取左视图的话，需要反转下面的顺序，就可以了
        dfs(root.right, ans, level + 1);
        dfs(root.left, ans, level + 1);
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node3.right = node4;
        node2.right = node5;

        List<Integer> list = rightSideView(node1);
        System.out.println("list = " + list);
        // list = [1, 3, 4]
    }
}
