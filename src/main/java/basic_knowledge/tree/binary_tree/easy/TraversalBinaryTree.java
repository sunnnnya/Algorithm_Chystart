package basic_knowledge.tree.binary_tree.easy;

import java.util.Stack;

/**
 * @BelongsPackage: basic_knowledge.tree.binary_tree.easy
 * @ClassName: TraversalBinasryTree
 * @Author: 丛虹羽
 * @Date: 2024/7/28 上午12:20
 * @Description: 遍历二叉树
 */
public class TraversalBinaryTree {

    /**
     * 二叉树中的节点结构信息
     */
    public static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 使用递归的方式实现先序遍历
     *
     * @param head
     */
    private static void pre(Node head) {
        if (head == null) {
            return ;
        }
        System.out.print(head.value + " ");
        pre(head.left);
        pre(head.right);
    }

    /**
     * 使用递归的方式实现中序遍历
     *
     * @param head
     */
    private static void mid(Node head) {
        if (head == null) {
            return ;
        }
        mid(head.left);
        System.out.print(head.value + " ");
        mid(head.right);
    }

    /**
     * 使用递归的方式实现后序遍历
     *
     * @param head
     */
    private static void post(Node head) {
        if (head == null) {
            return ;
        }
        post(head.left);
        post(head.right);
        System.out.print(head.value + " ");
    }

    /**
     * 使用stack的方式实现先序遍历
     * 压栈的顺序：先右节点 后左节点 -> 根 左 右
     *
     * @param head
     */
    private static void preStack(Node head) {
        if (head == null) {
            return ;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.value + " ");
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
        System.out.println();
    }

    /**
     * 使用栈的方式实现中序遍历
     *
     * @param head
     */
    public static void midStack(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || head != null) {
                // 不为空的时候把整个左节点全都压入到栈里面
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System. out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System. out.println();
    }

    /**
     * 使用栈的方式实现后序遍历
     * 后续遍历先压入左节点、再压入右节点 -> 根 右 左 -> 全部放在栈中逆序 -> 左 右 根
     *
     * @param head
     */
    private static void postStack(Node head) {
        if (head != null) {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().value + " ");
            }
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node( 7);

        System.out.print("使用递归的方式实现先序遍历： ");
        pre(head); // 先序遍历： 1 2 4 5 3 6 7
        System.out.println();

        System.out.print("使用递归的方式实现中序遍历： ");
        mid(head); // 中序遍历： 4 2 5 1 6 3 7
        System.out.println();

        System.out.print("使用递归的方式实现后序遍历： ");
        post(head); // 后序遍历： 4 5 2 6 7 3 1
        System.out.println();

        System.out.print("使用栈的方式实现先序遍历： ");
        preStack(head); // 先序遍历：1 2 4 5 3 6 7

        System.out.print("使用栈的方式实现中序遍历：");
        midStack(head); // 中序遍历：4 2 5 1 6 3 7

        System.out.print("使用栈的方式实现后序遍历： ");
        postStack(head); // 后序遍历：4 5 2 6 7 3 1
    }
}
