package job_interview.hot100.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: job_interview.hot100.binary_tree
 * @ClassName: LevelOrder
 * @Author: 丛虹羽
 * @Date: 2025/7/16 11:10
 * @Description: 二叉树的层序遍历
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class LevelOrder {

    /**
     * 二叉树的节点
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

    private static int MAXN = 2005;

    private static TreeNode[] queue = new TreeNode[MAXN];

    private static int l, r = 0;

    /**
     * 二叉树的层序遍历
     *
     * @param root 二叉树的根节点
     * @return List<List<Integer>>
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        r = 0;
        queue[r++] = root;
        while(l < r) {
            int size = r - l;
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                root = queue[l++];
                list.add(root.val);
                if(root.left != null) {
                    queue[r++] = root.left;
                }
                if(root.right != null) {
                    queue[r++] = root.right;
                }
            }
            ans.add(list);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        List<List<Integer>> lists = levelOrder(node3);
        System.out.println("lists = " + lists);
        // lists = [[3], [9, 20], [15, 7]]
    }
}
