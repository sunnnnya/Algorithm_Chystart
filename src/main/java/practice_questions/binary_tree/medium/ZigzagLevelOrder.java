package practice_questions.binary_tree.medium;

import practice_questions.binary_tree.base.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @BelongsPackage: practice_questions.binary_tree.medium
 * @ClassName: ZigzagLevelOrder
 * @Author: 丛虹羽
 * @Date: 2024/12/22 下午5:30
 * @Description: 二叉树的锯齿形层序遍历 —— 和普通的层次遍历的之间的区别就是对输入链表的元素进行边界逆序处理
 *
 * leetcode： https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal
 */
public class ZigzagLevelOrder {

    public static final int MAXN = 20001;

    public static TreeNode[] queue = new TreeNode[MAXN];

    public static int l, r;

    /**
     * 优化传统的 BFS，使用数组平替系统实现的队列
     *
     * @param root 二叉树的根节点
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }
        l = r = 0;
        List<List<Integer>> ans = new ArrayList<>();
        queue[r++] = root;
        boolean reverse = false;
        while(l < r) {
            int size = r - l;
            List<Integer> list = new ArrayList<>();
            // 循环用的很好!!
            for(int i = reverse ? r - 1 : l, j = reverse ? -1 : 1, k = 0; k < size; i += j, k++){
                list.add(queue[i].val);
            }
            // 队列更新
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue[l++];
                if(cur.left != null) {
                    queue[r++] = cur.left;
                }
                if(cur.right != null) {
                    queue[r++] = cur.right;
                }
            }
            ans.add(list);
            reverse = !reverse;
        }
        return ans;
    }

    /**
     * 打印动态数组
     *
     * @param ll
     */
    private static void print(List<List<Integer>> ll) {
        for(List<Integer> l : ll) {
            System.out.print(l);
        }
        System.out.println();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        print(zigzagLevelOrder(treeNode1));
        // [3][20, 9][15, 7]

        TreeNode treeNode6 = new TreeNode(1);
        print(zigzagLevelOrder(treeNode6));
        // [1]

        TreeNode treeNode7 = null;
        print(zigzagLevelOrder(treeNode7));
        // []
    }
}