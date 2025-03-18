package leetcode.hot100;

import leetcode.skill.tree.TreeNode;

import java.util.*;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-18 16:01
 * @description: 二叉树的层序遍历
 *
 * leetcode: https://leetcode.cn/problems/binary-tree-level-order-traversal/description/?envType=study-plan-v2&envId=top-100-liked
 **/
public class LevelOrder {

    public static int MAXN = 2000;

    public static TreeNode[] queue = new TreeNode[MAXN];

    public static int l, r = 0;

    /**
     * bfs优化
     *
     * @param root 根节点
     * @return 层序遍历结果
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> list = new ArrayList<>();
        queue[r++] = root;
        while(l < r) {
            int size = r - l;
            List<Integer> subList = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue[l++];
                subList.add(cur.val);
                if(cur.left != null) {
                    queue[r++] = cur.left;
                }
                if(cur.right != null) {
                    queue[r++] = cur.right;
                }
            }
            list.add(subList);
        }
        return list;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println("Result: " + levelOrder(node1));
        // Result: [[3], [9, 20], [15, 7]]
    }
}
