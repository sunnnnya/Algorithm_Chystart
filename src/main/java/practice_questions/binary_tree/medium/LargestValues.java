package practice_questions.binary_tree.medium;

import practice_questions.binary_tree.base.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: practice_questions.binary_tree.medium
 * @ClassName: LargestValues
 * @Author: 丛虹羽
 * @Date: 2024/12/22 下午10:19
 * @Description: 在每个树行中找最大值
 *
 * leetcode； https://leetcode.cn/problems/hPov7L/description/
 */
public class LargestValues {

    public static final int MAXN = 10004;

    public static TreeNode[] queue = new TreeNode[MAXN];

    public static int l, r;

    /**
     * 使用数组模拟栈结构，同时优化 BFS 中一次处理维护同一层级的节点信息
     *
     * @param root 根节点
     * @return
     */
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        l = r = 0;
        queue[r++] = root;
        while(l < r) {
            int size = r - l, max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++) {
                TreeNode node = queue[l++];
                max = Math.max(max, node.val);
                if(node.left != null) {
                    queue[r++] = node.left;
                }
                if(node.right != null) {
                    queue[r++] = node.right;
                }
            }
            ans.add(max);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(9);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;
        System.out.println(largestValues(treeNode1));
        // [1, 3, 9]
    }
}