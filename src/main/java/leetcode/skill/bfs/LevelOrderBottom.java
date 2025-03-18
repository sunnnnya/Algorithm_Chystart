package leetcode.skill.bfs;

import leetcode.skill.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @package: leetcode.skill.bfs
 * @author: chystart
 * @create: 2025-03-18 17:15
 * @description: 二叉树的层序遍历 II
 *
 * leetcode: https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/
 **/
public class LevelOrderBottom {

    public static int MAXN = 20001;

    public static TreeNode[] queue = new TreeNode[MAXN];

    public static int l = 0, r = 0;

    /**
     * bfs优化 + 反转
     *
     * @param root 树的根节点
     * @return 顺序
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
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
        Collections.reverse(list);
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
        System.out.println("Result: " + levelOrderBottom(node1));
        // Result: [[15, 7], [9, 20], [3]]
    }
}
