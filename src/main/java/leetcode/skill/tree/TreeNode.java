package leetcode.skill.tree;

/**
 * @package: leetcode.skill.tree
 * @author: chystart
 * @create: 2025-03-11 09:57
 * @description: 二叉树节点
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
