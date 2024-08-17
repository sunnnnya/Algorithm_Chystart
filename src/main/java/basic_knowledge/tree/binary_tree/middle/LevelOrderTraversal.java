package basic_knowledge.tree.binary_tree.middle;

import practice_questions.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsPackage: basic_knowledge.tree.binary_tree.easy
 * @ClassName: LevelOrderTraversal
 * @Author: 丛虹羽
 * @Date: 2024/7/28 上午9:51
 * @Description: 层序遍历
 *
 *  给定一课树：求逆序按层遍历打印每层的节点信息：
 *          1
 *        /   \
 *       2     3
 *        \   / \
 *         4 5   6
 *        / \   \   \
 *       7   8   9   10
 *                \  /
 *                11 12
 *
 *  [[11, 12], [7, 8, 9, 10], [4, 5, 6], [2, 3], [1]]
 *
 *  做法：
 *      （1）拿出此时队列的size，size有多少个，就执行操作2多少回，
 *      （2）弹出节点，以此添加左，右
 */
public class LevelOrderTraversal {

    /**
     * 层序遍历树结构
     *
     * @param root 树的根节点
     * @return
     */
    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) {
            return ans;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            while(size-- != 0) {
                TreeNode node = queue.pop();
                // 有左孩子添加左孩子
                if (node.left != null) {
                    queue.add(node.left);
                }
                // 有孩子添加右孩子
                if (node.right != null) {
                    queue.add(node.right);
                }
                list.add(node.val);
            }
            // 直接使用链表的逆序添加
            ans.add(0, list);
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
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode12 = new TreeNode(12);
        treeNode1.left = treeNode2;
        treeNode1.left.right = treeNode4;
        treeNode1.left.right.left = treeNode7;
        treeNode1.left.right.right = treeNode8;
        treeNode1.right = treeNode3;
        treeNode1.right.left = treeNode5;
        treeNode1.right.right = treeNode6;
        treeNode1.right.left.right = treeNode9;
        treeNode1.right.left.right.right = treeNode11;
        treeNode1.right.right.right = treeNode10;
        treeNode1.right.right.right.left = treeNode12;
        List<List<Integer>> lists = levelOrderTraversal(treeNode1);
        System.out.println(lists);
        // [[11, 12], [7, 8, 9, 10], [4, 5, 6], [2, 3], [1]]

        System.out.println("============动态数组的逆序添加测试=============");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0, 21);
        list.add(0, 22);
        list.add(0, 23);
        list.add(0, 24);
        // 不会出现覆盖的问题，而是会逆序塞入
        for (int number : list)  {
            System.out.println("number: " + number);
        }
        // number: 24
        // number: 23
        // number: 22
        // number: 21
    }
}
