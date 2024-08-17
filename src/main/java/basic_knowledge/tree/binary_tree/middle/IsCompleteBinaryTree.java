package basic_knowledge.tree.binary_tree.middle;

import practice_questions.tree.base.TreeNode;

import java.util.LinkedList;

/**
 * @BelongsPackage: practice_questions.tree.medium
 * @ClassName: IsComplateBinaryTree
 * @Author: 丛虹羽
 * @Date: 2024/8/17 下午3:42
 * @Description: 判断是否是完全二叉树
 *
 * 要么是满二叉树，要么是依次变满的过程的二叉树
 *          1                         1
 *         / \                       / \
 *       2    3  是完全二叉树        2   3  不是完全二叉树
 *     / \   /                    / \    \
 *    3   1 2                    3  1     5
 */
public class IsCompleteBinaryTree {

    /**
     * 判断是否是完全二叉树
     *
     * @param root
     * @return
     */
    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 是否遇到过左右两个孩子不双全的节点【有右无左，有左无右】
        boolean leaf = false;
        TreeNode l = null;
        TreeNode r = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            l = root.left;
            r = root.right;
            // (l == null && r != null)：当某一个节点【有右孩子，但无左孩子】肯定不满足完全二叉树性质；
            // (leaf && (l != null || r != null)：当已经遇到过两个孩子不双全的节点后，只要只能是叶子节点，右节点或者左节点中有一个不为空都不是完全二叉树
            if ((l == null && r != null) || (leaf && (l != null || r != null))) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            // 开关状态触发
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode6;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        System.out.println(isCompleteTree(treeNode1));
        // true

        TreeNode treeNode7 = new TreeNode(1);
        TreeNode treeNode8 = new TreeNode(2);
        TreeNode treeNode9 = new TreeNode(3);
        TreeNode treeNode10 = new TreeNode(3);
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode12 = new TreeNode(5);
        treeNode7.left = treeNode8;
        treeNode7.right = treeNode9;
        treeNode9.right = treeNode12;
        treeNode8.left = treeNode10;
        treeNode8.right = treeNode11;
        System.out.println(isCompleteTree(treeNode7));
        // false
    }
}
