package practice_questions.binary_tree.medium;

import practice_questions.binary_tree.base.TreeNode;
import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.binary_tree.medium
 * @ClassName: DecorateRecord
 * @Author: 丛虹羽
 * @Date: 2024/12/22 下午11:50
 * @Description: 彩灯装饰记录
 *
 * leetcode: https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 */
public class DecorateRecord {

    public static final int MAXN = 1010;

    public static TreeNode[] queue = new TreeNode[MAXN];

    public static int l, r;

    /**
     * 不需要覆盖，直接使用 queue 进行复用就可以，只是记录截取的边界；
     *
     * @param root
     * @return
     */
    public static int[] decorateRecord(TreeNode root) {
        if(root == null) {
            return new int[]{};
        }
        int num = 0;
        l = r = 0;
        queue[r++] = root;
        // queue is not empty
        while(l < r) {
            TreeNode node = queue[l++];
            if(node.left != null) {
                queue[r++] = node.left;
            }
            if(node.right != null) {
                queue[r++] = node.right;
            }
            num++;
        }
        int[] ans = new int[num];
        for(int i = 0; i < num; i++) {
            ans[i] = queue[i].val;
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(17);
        TreeNode treeNode3 = new TreeNode(21);
        TreeNode treeNode4 = new TreeNode(18);
        TreeNode treeNode5 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.right = treeNode5;
        System.out.println(Arrays.toString(decorateRecord(treeNode1)));
        // [8, 17, 21, 18, 6]
    }
}