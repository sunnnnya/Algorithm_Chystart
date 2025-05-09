package job_interview.code_top.tree.binary_tree;

import job_interview.code_top.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: job_interview.code_top.tree.binary_tree
 * @ClassName: LevelOrder
 * @Author: 丛虹羽
 * @Date: 2025/5/9 15:58
 * @Description: 二叉树的层序遍历
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
 */
public class LevelOrderII {

    private static int MAXN = 50000;

    private static int l, r;

    private static TreeNode[] queue = new TreeNode[MAXN];

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        l = r = 0;
        queue[r++] = root;
        List<List<Integer>> ans = new ArrayList<>();
        while(l < r) {
            int size = r - l;
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue[l++];
                list.add(cur.val);
                if(cur.right != null) {
                    queue[r++] = cur.right;
                }
                if(cur.left != null) {
                    queue[r++] = cur.left;
                }
            }
            ans.add(list);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(levelOrder(root));
        // [[3], [20, 9], [7, 15]]
    }
}
