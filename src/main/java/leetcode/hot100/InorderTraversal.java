package leetcode.hot100;

import leetcode.skill.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-11 09:56
 * @description: 二叉树的中序遍历
 *
 * leetcode: https://leetcode.cn/problems/binary-tree-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked
 **/
public class InorderTraversal {

    /**
     * 二叉树的中序遍历 —— 递归实现
     *
     * @param root 二叉树的根节点
     * @return 节点列表信息
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    /**
     * 二叉树的中序遍历
     *
     * @param root 二叉树的根节点
     * @param list 链表信息
     */
    public static void dfs(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
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
        node1.right = node2;
        node2.left = node3;
        System.out.println("中序遍历：" + inorderTraversal(node1));
    }
}
