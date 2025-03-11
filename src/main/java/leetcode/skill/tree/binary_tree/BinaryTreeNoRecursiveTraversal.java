package leetcode.skill.tree.binary_tree;

import leetcode.skill.tree.TreeNode;

import java.util.Stack;

/**
 * @package: leetcode.skill.tree.binary_tree
 * @author: chystart
 * @create: 2025-03-11 11:08
 * @description: 二叉树的非递归遍历
 **/
public class BinaryTreeNoRecursiveTraversal {

    /**
     * 二叉数的非递归遍历 —— 先序遍历，先压入右再压入左
     *
     * @param root 二叉树的根节点
     */
    public static void preOrder(TreeNode root) {
        if(root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.val + " ");
                if(root.right != null) {
                    stack.push(root.right);
                }
                if(root.left != null) {
                    stack.push(root.left);
                }
            }
            System.out.println();
        }
    }

    /**
     * 二叉数的非递归遍历 —— 中序遍历
     *
     * @param root 二叉树的根节点
     */
    public static void inOrder(TreeNode root) {
        if(root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while(!stack.isEmpty() || root != null) {
                // 左侧节点全部进栈
                if(root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    // 当左子树走完的时候，弹出，在右节点的左侧节点全部入栈
                    root = stack.pop();
                    System.out.print(root.val + " ");
                    root = root.right;
                }
            }
            System.out.println();
        }
    }

    /**
     * 二叉数的非递归遍历 —— 后序遍历
     *     理解：由先序遍历的 [根, 左子树, 右子树] 先压右再压左 转换一下 先压左再压右 变成 [根, 右子树, 左子树]
     *     然后使用栈 对 [根, 右子树, 左子树] 进行逆序 [左子树, 右子树, 根]
     *
     * @param root 二叉树的根节点
     */
    public static void postOrder(TreeNode root) {
        if(root != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> collection = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()) {
                root = stack.pop();
                collection.push(root);
                if(root.left != null) {
                    stack.push(root.left);
                }
                if(root.right != null) {
                    stack.push(root.right);
                }
            }
            while(!collection.isEmpty()) {
                System.out.print(collection.pop().val + " ");
            }
            System.out.println();
        }
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
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        // 先序遍历
        System.out.print("先序遍历：");
        preOrder(node1);
        System.out.println();

        // 中序遍历
        System.out.print("中序遍历：");
        inOrder(node1);
        System.out.println();

        // 后序遍历
        System.out.print("后序遍历：");
        postOrder(node1);
        System.out.println();
    }
}
