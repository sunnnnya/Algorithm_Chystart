package basic_knowledge.morris;

/**
 * @BelongsPackage: basic_knowledge.morris
 * @ClassName: Morris
 * @Author: 丛虹羽
 * @Date: 2024/8/3 下午10:09
 * @Description: Morris遍历（装逼使用）：一种二叉树的遍历方式，时间复杂度O(N)，空间复杂度O(1)！！！！！
 *
 * Morris遍历细节：利用每个节点的右指针的状态进行遍历
 *
 * 假设当前节点 cur，开始时 cur 来到头节点的位置
 * （1）如果 cur 没有左孩子，cur 向右移动(cur = cur.right);
 * （2）如果 cur 有左孩子，找到左子树上最右的节点 mostRight
 *      [1]如果 mostRight 的右指针指向空，让其指向 cur，然后 cur 向左移动(cur = cur.left)
 *      [2]如果 mostRight 的右指针指向 cur， 让其指向 null，然后 cur 向右移动(cur = cur.right)
 * （3）cur 为空时停止遍历
 *
 *              (1)
 *            |     \
 *          (2)     (3)
 *         |   \   |   \
 *       (4)   (5)(6)  (7)
 *
 *    Morris 序：1 2 4 2 5 1 3 6 3 7
 *    先序遍历  ：1 2 4 5 3 6 7
 *      当前节点无左树：只会到达自己一次，直接打印
 *      当前节点有左树：第一次到达自己的时候打印（mostRight.right = null）
 *    中序遍历  ：4 2 5 1 6 3 7
 *      当前节点有左树：只会到达自己一次，直接打印
 *      当前节点有左树：第二次到达自己的时候打印（mostRight.right == cur）
 *    后序列遍历：4 5 2 6 7 3 1
 *      Morris序: 1 2 4 2 5 1 3 6 3 7
 *                      ↓   ↓     ↓
 *                      4  5 2    6 + 7 3 1 -> 后序遍历
 *      到了第二次到达的节点，依次逆序打印左树的右边界，然后最后逆序打印整颗树的右边界
 *      1:问题：如何进行逆序打印：链表的反转
 */
public class Morris {

    /**
     * 二叉树的节点信息
     */
    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 使用Morris序遍历二叉树
     *
     * @param head
     */
    public static void morris(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            System.out.print(cur.value + " ");
            mostRight = cur.left;
            if (mostRight != null) {
                // 自己左树的最右孩子，直到是 mostRight.right == null 或者 mostRight.right == cur都是不满足的条件
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
        System.out.println();
    }

    /**
     * Morris先序遍历树中的节点信息
     *
     * @param head
     */
    private static void preOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                // 自己左树的最右孩子，直到是 mostRight.right == null 或者 mostRight.right == cur都是不满足的条件
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null) {
                    System.out.print(cur.value + " ");
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                System.out.print(cur.value + " ");
            }
            cur = cur.right;
        }
        System.out.println();
    }

    /**
     * Morris中序遍历树中的节点信息
     *
     * @param head
     */
    private static void inOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                // 自己左树的最右孩子，直到是 mostRight.right == null 或者 mostRight.right == cur都是不满足的条件
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    System.out.print(cur.value + " ");
                    mostRight.right = null;
                }
            } else {
                System.out.print(cur.value + " ");
            }
            cur = cur.right;
        }
        System.out.println();
    }

    /**
     * Morris后序遍历二叉树
     *
     * @param head
     */
    public static void postOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                // 自己左树的最右孩子，直到是 mostRight.right == null 或者 mostRight.right == cur都是不满足的条件
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    // 既然能到两次，说明一定有左树
                    printRightEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printRightEdge(head);
        System.out.println();
    }

    /**
     * 逆序打印右边界，链表
     *
     * @param head
     */
    private static void printRightEdge(TreeNode head) {
        TreeNode treeNode = reverseList(head);
        print(treeNode);
        reverseList(treeNode);
    }

    /**
     * 链表的反转
     *
     * @param head
     */
    private static TreeNode reverseList(TreeNode head) {
        if (head == null) {
            return null;
        }
        TreeNode pre = null;
        TreeNode next = null;
        while (head != null) {
            next = head.right;
            head.right = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 打印链表的节点信息
     *
     * @param head
     */
    public static void print(TreeNode head) {
        if (head == null) {
            return ;
        }
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.right;
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
        TreeNode treeNode8 = new TreeNode(8);
        treeNode1.left = treeNode2;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        System.out.println("morris序遍历：");
        morris(treeNode1);
        System.out.println("morris的先序遍历：");
        preOrder(treeNode1);
        System.out.println("morris的中序遍历：");
        inOrder(treeNode1);
        System.out.println("morris的后序遍历：");
        postOrder(treeNode1);
    }
}
