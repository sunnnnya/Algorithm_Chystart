package practice_questions.tree.easy;

import practice_questions.tree.base.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @BelongsPackage: practice_questions.tree.easy
 * @ClassName: FindTargetNode
 * @Author: 丛虹羽
 * @Date: 2024/8/3 下午2:26
 * @Description: 寻找二叉搜索树中的目标节点
 *
 * 某公司组织架构以二叉搜索树形式记录，节点值为处于该职位的员工编号。请返回第 cnt 大的员工编号。
 *
 * leetcode：https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/description/
 *
 */
public class FindTargetNode {

    /**
     * 找到二叉搜索树中的第cnt大的值
     * 自己实现的方法！！
     *
     * @param root
     * @param cnt
     * @return
     */
    public static int findTargetNode(TreeNode root, int cnt) {
        if (root.left == null && root.right == null && cnt == 1) {
            return root.value;
        }
        List<Integer> listNumbers = inOrderTraversal(root);
        return listNumbers.get(listNumbers.size() - cnt);
    }

    /**
     * 获得当前树的中序遍历
     * 自己实现的方法！！
     *
     * @param root
     * @return
     */
    public static List<Integer> inOrderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        ArrayList<Integer> integers = new ArrayList<>();
        integers.addAll(inOrderTraversal(root.left));
        integers.add(root.value);
        integers.addAll(inOrderTraversal(root.right));
        return integers;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 测试数据1
        TreeNode treeNode1 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(9);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode1.left.left = treeNode4;
        treeNode1.left.right = treeNode5;
        System.out.println(findTargetNode(treeNode1, 2));
        // 7

        // 测试数据2
        TreeNode treeNode6 = new TreeNode(10);
        TreeNode treeNode7 = new TreeNode(5);
        TreeNode treeNode8 = new TreeNode(15);
        TreeNode treeNode9 = new TreeNode(2);
        TreeNode treeNode10 = new TreeNode(7);
        TreeNode treeNode11 = new TreeNode(20);
        TreeNode treeNode12 = new TreeNode(1);
        TreeNode treeNode13 = new TreeNode(6);
        TreeNode treeNode14 = new TreeNode(8);
        treeNode6.right = treeNode8;
        treeNode6.right.right = treeNode11;
        treeNode6.left = treeNode7;
        treeNode6.left.left = treeNode9;
        treeNode6.left.left.left = treeNode12;
        treeNode6.left.right = treeNode10;
        treeNode6.left.right.right = treeNode14;
        treeNode6.left.right.left = treeNode13;
        System.out.println(findTargetNode(treeNode6, 4));
        // 8
    }
}
