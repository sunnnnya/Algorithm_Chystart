package basic_knowledge.tree.binary_tree.easy;

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
     * 先序遍历
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
     * 中序遍历
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
     * 后序遍历
     *
     * @param head
     */
    private static void sub(Node head) {
        if (head == null) {
            return ;
        }
        sub(head.left);
        sub(head.right);
        System.out.print(head.value + " ");
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

        System.out.print("先序遍历： ");
        pre(head); // 先序遍历： 1 2 4 5 3 6 7
        System.out.println();

        System.out.print("中序遍历： ");
        mid(head); // 中序遍历： 4 2 5 1 6 3 7
        System.out.println();

        System.out.print("后序遍历： ");
        sub(head); // 后序遍历： 4 5 2 6 7 3 1
        System.out.println();
    }
}
