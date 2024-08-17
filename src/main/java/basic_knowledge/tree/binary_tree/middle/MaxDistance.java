package basic_knowledge.tree.binary_tree.middle;

import practice_questions.binary_tree.base.TreeNode;

/**
 * @BelongsPackage: practice_questions.tree.hard
 * @ClassName: Demo
 * @Author: 丛虹羽
 * @Date: 2024/8/17 下午5:09
 * @Description: 二叉树的递归套路拓展，树形 dp 的基础
 *
 * 给定一棵二叉树的头节点head，任何两个节点之间都存在距离，返回整棵二叉树的最大距离。
 *               a
 *             /  \
 *           b     c
 *         /  \   / \              从 i 到 w 的最大距离: i -> d -> b -> a -> c -> e -> w
 *       c    d  e   f                     最大距离长度：7
 *     / \   /   \
 *    g   h i     w
 *
 *   首先设定求以X为头的情况下，整棵树的的最大距离；
 *      如果最大路径不经过 x：
 *          （1）求左树上的最大距离；
 *          （2）求右树上的最大距离；
 *      如果最大路径经过 x：
 *          （1）左树中节点距离x最远（左树高度） + 右树中节点距离y最远（右树高度） + 1
 */
public class MaxDistance {

    /**
     * 信息体
     */
    public static class Info {
        // 整棵树中存在的最大距离信息
        public int maxDistance;
        // 整棵树的高度信息
        public int height;
        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    /**
     * 递归方程
     *
     * @param root
     * @return
     */
    public static Info process(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int maxDistance = Math.max(Math.max(leftInfo.maxDistance, rightInfo.maxDistance), leftInfo.height + rightInfo.height + 1);
        return new Info(maxDistance, height);
    }

    /**
     * 返回最大距离的函数
     *
     * @param root
     * @return
     */
    public static int maxDistance(TreeNode root) {
        return process(root).maxDistance;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}
