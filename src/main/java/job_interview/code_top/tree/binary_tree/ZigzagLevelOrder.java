package job_interview.code_top.tree.binary_tree;

import job_interview.code_top.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @BelongsPackage: job_interview.code_top.tree.binary_tree
 * @ClassName: ZigzagLevelOrder
 * @Author: 丛虹羽
 * @Date: 2025/5/11 12:59
 * @Description: 二叉树的锯齿形层序遍历
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/
 */
public class ZigzagLevelOrder {

    private static int MAXN = 2005;

    private static TreeNode[] queue = new TreeNode[MAXN];

    private static int l, r;

    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        l = r = 0;
        queue[r++] = root;
        int level = 0;
        while(l < r) {
            int size = r - l;
            level++;
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
            if((level & 1) == 1){
                ans.add(list);
            } else {
                Collections.reverse(list);
                ans.add(list);
            }
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
        System.out.println(zigzagLevelOrder(root));
        // [[3], [20, 9], [15, 7]]
    }
}
