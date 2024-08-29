package practice_questions.binary_tree.easy;

import practice_questions.binary_tree.base.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @BelongsPackage: practice_questions.binary_tree.easy
 * @ClassName: IsSubTreeII
 * @Author: 丛虹羽
 * @Date: 2024/8/28 下午4:38
 * @Description: 使用一棵树的先序遍历，生成字符串信息，然后进行 kmp(字符匹配，字符串匹配) 的使用
 *
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 *
 * leetcode: https://leetcode.cn/problems/subtree-of-another-tree
 */
public class IsSubTreeII {

    /**
     * kmp + 树的先序序列化
     *
     * @param root
     * @param subRoot
     * @return
     */
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) {
            return true;
        }
        ArrayList<String> s1 = new ArrayList<>();
        ArrayList<String> s2 = new ArrayList<>();
        preSerialized(s1, root);
        preSerialized(s2, subRoot);
        return kmp(s1, s2) != -1;
    }

    /**
     * 树的先序序列化
     *
     * @param s
     * @param root
     */
    public static void preSerialized(List<String> s, TreeNode root) {
        if (root == null) {
            s.add(null);
        } else {
            s.add(String.valueOf(root.val));
            preSerialized(s, root.left);
            preSerialized(s, root.right);
        }
    }

    /**
     * 进行 kmp 的匹配问题，从 字符数组 变成 字符串数组
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int kmp(List<String> s1, List<String> s2) {
        if(s2.isEmpty()) {
            return -1;
        }
        int x = 0;
        int y = 0;
        int[] next = getNextArray(s2);
        while (x < s1.size() && y < s2.size()) {
            if (Objects.equals(s1.get(x), s2.get(y))) {
                x++;
                y++;
            } else if (y == 0) {
                x++;
            } else {
                y = next[y];
            }
        }
        return y == s2.size() ? x - s2.size() : -1;
    }

    /**
     * 获取 next 数组的过程
     *
     * @param s
     * @return
     */
    public static int[] getNextArray(List<String> s) {
        if (s.isEmpty() || s.size() == 1) {
            return new int[]{-1};
        }
        int[] next = new int[s.size()];
        next[0] = -1;
        next[1] = 0;
        for (int i = 2, cn = 0; i < s.size(); i++) {
            if (Objects.equals(s.get(i - 1), s.get(cn))) {
                next[i] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i] = 0;
            }
        }
        return next;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("==============测试获取next数组函数==============");
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("abc");
        list.add("a");
        list.add("b");
        list.add("abc");
        list.add("f");
        list.add("g");
        // ["a", "b", "abc", "a", "b", "abc", "f", "g"]
        System.out.println(Arrays.toString(getNextArray(list)));
        // [-1, 0, 0, 0, 1, 2, 3, 0]

        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(1);
        TreeNode treeNode8 = new TreeNode(2);
        treeNode6.left = treeNode7;
        treeNode6.right = treeNode8;

        System.out.println(isSubtree(treeNode1, treeNode6));
        // true
    }
}
