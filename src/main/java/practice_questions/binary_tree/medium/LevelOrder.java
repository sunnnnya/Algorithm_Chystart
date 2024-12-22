package practice_questions.binary_tree.medium;

import practice_questions.binary_tree.base.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @BelongsPackage: practice_questions.binary_tree.medium
 * @ClassName: LevelOrder
 * @Author: 丛虹羽
 * @Date: 2024/12/22 下午3:46
 * @Description: 使用数组模拟队列，进行层序遍历
 *
 * 经典 BFS 问题，弹出队列中节点，然后加入新的节点，依次处理。
 *
 * leetcode： https://leetcode.cn/problems/binary-tree-level-order-traversal/
 */
public class LevelOrder {

    // 分析好数据，然后针对题中的数据量，给定满足条件的长度
    public static final int MAXN = 20001;

    public static TreeNode[] queue = new TreeNode[MAXN];

    public static int l = 0, r = 0;

    /**
     * 层序遍历，对 bfs 进行优化 分层处理，同时使用数组模拟队列，优化常数时间
     *
     * @param root 二叉树的根节点
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }
        queue[r++] = root;
        List<List<Integer>> ans = new ArrayList<>();
        // l == r 说明，队列空了
        while(l < r) {
            int size = r - l;
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue[l++];
                list.add(cur.val);
                if(cur.left != null) {
                    queue[r++] = cur.left;
                }
                if(cur.right != null) {
                    queue[r++] = cur.right;
                }
            }
            ans.add(list);
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
        print(levelOrder(treeNode1));
        // [3][9, 20][15, 7]

        TreeNode treeNode6 = new TreeNode(1);
        print(levelOrder(treeNode6));
        // [1]

        TreeNode treeNode7 = null;
        print(levelOrder(treeNode7));
        // []
    }
}