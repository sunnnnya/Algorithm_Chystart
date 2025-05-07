package job_interview.alg_basic_know.tree.binary_tree.ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.tree.binary_tree.ext
 * @ClassName: TreeNode
 * @Author: 丛虹羽
 * @Date: 2025/4/16 18:01
 * @Description: 树的基本信息结构
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
