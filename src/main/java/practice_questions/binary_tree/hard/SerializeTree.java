package practice_questions.binary_tree.hard;

import practice_questions.binary_tree.base.TreeNode;

/**
 * @BelongsPackage: practice_questions.binary_tree.hard
 * @ClassName: Codec
 * @Author: 丛虹羽
 * @Date: 2024/12/23 下午2:58
 * @Description: 二叉树的序列化与反序列化
 *
 * leetcode: https://leetcode.cn/problems/serialize-and-deserialize-binary-tree
 */
public class SerializeTree {

    // 技术点，虽然递归是拥有自己的现场数据的，可以通过设计全局变量，进行控制
    public static int cnt;

    /**
     * 序列化
     *
     * @param root 树的根节点
     * @return
     */
    public static String serialize(TreeNode root) {
        StringBuilder builer = new StringBuilder();
        process(root, builer);
        return builer.toString();
    }

    /**
     * 序列化递归函数，使用先序遍历的方式进行序列化
     *
     * @param root    根节点
     * @param builder StringBuilder类
     */
    public static void process(TreeNode root, StringBuilder builder) {
        if(root == null) {
            builder.append("#,");
        } else {
            builder.append(root.val + ",");
            process(root.left, builder);
            process(root.right, builder);
        }
    }

    /**
     * 反序列化
     *
     * @param data
     * @return
     */
    public static TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        cnt = 0;
        return process(strings);
    }

    /**
     * 使用递归，通过后续遍历的方式创建一棵树
     *
     * @param strings
     * @return
     */
    private static TreeNode process(String[] strings) {
        String cur = strings[cnt++];
        if(cur.equals("#")) {
            return null;
        } else {
            TreeNode head = new TreeNode(Integer.valueOf(cur));
            head.left = process(strings);
            head.right = process(strings);
            return head;
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
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        System.out.println(serialize(treeNode1));
        // 1,2,#,#,3,4,#,#,5,#,#,
    }
}