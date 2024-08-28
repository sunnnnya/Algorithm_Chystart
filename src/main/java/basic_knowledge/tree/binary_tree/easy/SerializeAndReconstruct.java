package basic_knowledge.tree.binary_tree.easy;

import practice_questions.binary_tree.base.TreeNode;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @BelongsPackage: basic_knowledge.tree.binary_tree.easy
 * @ClassName: SerializeAndReconstruct
 * @Author: 丛虹羽
 * @Date: 2024/8/17 下午2:42
 * @Description: 树结构的 序列化 和 反序列化（使用先序遍历就够了）
 *
 *      一棵树的结构信息：        ——>      对应的序列化信息：
 *              1
 *             / \
 *           1   null                 先序遍历，#表示空
 *         / \                     [1, 1, #, 1, #, #, #]
 *      null  1
 *           / \
 *        null null
 */
public class SerializeAndReconstruct {

    /**
     * 返回一个树的序列化结构信息
     *
     * @param root
     * @return
     */
    public static Queue<String> serializeTree(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        LinkedList<String> ans = new LinkedList<>();
        pres(ans, root);
        return ans;
    }

    /**
     * 填充 ans 结果队列，搞清楚 值传递 和 引用传递 的区别，使用创建好的队列来统一接收字符串
     *
     * @param ans
     * @param root
     */
    public static void pres(Queue<String> ans, TreeNode root) {
        if (root == null) {
            // 程序需要返回值时，用 return 返回；
            // 还有正常程序执行完毕后也 直接返回；
            ans.add("#");
        } else {
            ans.add(String.valueOf(root.val));
            pres(ans, root.left);
            pres(ans, root.right);
        }
    }

    /**
     * 反序列化
     *
     * @param preList
     * @return
     */
    public static TreeNode buildByPreQueue(Queue<String> preList) {
        if(preList == null || preList.isEmpty()) {
            return null;
        }
        return preb(preList);
    }

    /**
     * 树的序列化的使用
     *
     * @param queue
     * @return
     */
    public static TreeNode preb(Queue<String> queue) {
        String value = queue.poll();
        if (Objects.equals(value, "#")) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.parseInt(value));
        head.left = preb(queue);
        head.right = preb(queue);
        return head;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(1);
        treeNode1.left = treeNode2;
        treeNode1.right = null;
        treeNode2.right = treeNode3;
        treeNode2.left = null;
        treeNode3.left = null;
        treeNode3.right = null;
        System.out.println(serializeTree(treeNode1));
        // [1, 1, #, 1, #, #, #]

        LinkedList<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("1");
        queue.add("#");
        queue.add("1");
        queue.add("#");
        queue.add("#");
        queue.add("#");
        System.out.println(serializeTree(buildByPreQueue(queue)));
        // [1, 1, #, 1, #, #, #]
    }
}
