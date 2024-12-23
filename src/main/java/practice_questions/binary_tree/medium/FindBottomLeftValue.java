package practice_questions.binary_tree.medium;

import practice_questions.binary_tree.base.TreeNode;

/**
 * @BelongsPackage: practice_questions.binary_tree.medium
 * @ClassName: FindBottomLeftValue
 * @Author: 丛虹羽
 * @Date: 2024/12/23 下午11:35
 * @Description: 找树左下角的值
 *
 * leetcode: https://leetcode.cn/problems/LwUNpT
 */
public class FindBottomLeftValue {

    public static final int MAXN = 10001;

    public static TreeNode[] queue = new TreeNode[MAXN];

    public static int l, r;

    /**
     * 依旧使用层序遍历进行二叉树的遍历，直接使用 queue 和 l,r 拿以前的信息
     *
     * @param root 二叉树的根节点信息
     * @return
     */
    public static int findBottomLeftValue1(TreeNode root) {
        l = r = 0;
        int size = 0;
        queue[r++] = root;
        while(l < r) {
            size = r - l;
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue[l++];
                if(cur.left != null) {
                    queue[r++] = cur.left;
                }
                if(cur.right != null) {
                    queue[r++] = cur.right;
                }
            }
        }
        return queue[r - size].val;
    }

    /**
     * 传统 BFS，塞入队列的顺序先右再左，这样最后弹出队列的元素就一定是最后一层最左的元素
     *
     * @param root 树的根节点
     * @return
     */
    public static int findBottomLeftValue(TreeNode root) {
        l = r = 0;
        queue[r++] = root;
        while(l < r) {
            root = queue[l++];
            if(root.right != null) {
                queue[r++] = root.right;
            }
            if(root.left != null) {
                queue[r++] = root.left;
            }
        }
        return root.val;
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
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node5.right = node8;
        node6.left = node7;
        node4.left = node9;
        System.out.println(findBottomLeftValue(node1));
        // 9

        TreeNode node11 = new TreeNode(11);
        System.out.println(findBottomLeftValue(node11));
        // 11
    }
}