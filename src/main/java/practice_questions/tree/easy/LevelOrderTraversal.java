package practice_questions.tree.easy;

import practice_questions.tree.base.TreeNode;
import java.util.LinkedList;

/**
 * @BelongsPackage: practice_questions.tree.easy
 * @ClassName: LevelOrderTraversal
 * @Author: 丛虹羽
 * @Date: 2024/8/17 下午12:45
 * @Description: 树的层序遍历 （使用队列）
 *
 */
public class LevelOrderTraversal {

    /**
     * 树的最普通的层序遍历
     *
     * @param root
     * @return
     */
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return ;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.print(root.val + " ");
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
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
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        System.out.print("二叉树的层序遍历的结果：");
        levelOrderTraversal(treeNode1);
        // 二叉树的层序遍历的结果：1 2 3 4 5 6 7
    }
}
