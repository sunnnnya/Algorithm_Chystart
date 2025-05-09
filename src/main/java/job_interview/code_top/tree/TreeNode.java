package job_interview.code_top.tree;

/**
 * @BelongsPackage: job_interview.code_top.tree
 * @ClassName: TreeNode
 * @Author: 丛虹羽
 * @Date: 2025/5/9 16:00
 * @Description: 二叉树的节点
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
