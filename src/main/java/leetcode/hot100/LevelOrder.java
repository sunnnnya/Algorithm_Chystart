package leetcode.hot100;

import leetcode.skill.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-18 16:01
 * @description: 二叉树的层序遍历
 *
 * leetcode: https://leetcode.cn/problems/binary-tree-level-order-traversal/description/?envType=study-plan-v2&envId=top-100-liked
 **/
public class LevelOrder {

    /**
     * bfs优化
     *
     * @param root 根节点
     * @return 层序遍历结果
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return list;
        }
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                root = queue.poll();
                subList.add(root.val);
                if(root.left != null) {
                    queue.add(root.left);
                }
                if(root.right != null) {
                    queue.add(root.right);
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
        System.out.println(levelOrder(node1));
        // [[3], [9, 20], [15, 7]]
    }
}
