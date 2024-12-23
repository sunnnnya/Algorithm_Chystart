package practice_questions.binary_tree.medium;

import practice_questions.binary_tree.base.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsPackage: practice_questions.binary_tree.medium
 * @ClassName: levelOrderII
 * @Author: 丛虹羽
 * @Date: 2024/12/23 下午4:43
 * @Description: N 叉树的层序遍历
 *
 * leetcode: https://leetcode.cn/problems/n-ary-tree-level-order-traversal/?envType=problem-list-v2&envId=nbQFMpWe
 */
public class levelOrderII {

    public static final int MAXN = 10001;

    public static Node[] queue = new Node[MAXN];

    public static int l, r;

    /**
     * N 叉树的 BFS 遍历
     *
     * @param root 树的根节点
     * @return
     */
    public static List<List<Integer>> levelOrderII(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        l = r = 0;
        queue[r++] = root;
        while(l < r) {
            int size = r - l;
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                Node node = queue[l++];
                list.add(node.val);
                if(node.children != null) {
                    for(Node child : node.children) {
                        queue[r++] = child;
                    }
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
    public static void print(List<List<Integer>> ll) {
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
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        List<Node> list1 = Arrays.asList(node2, node3, node4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> list2 = Arrays.asList(node5, node6);
        Node node1 = new Node(1);
        node1.children = list1;
        node3.children = list2;
        print(levelOrderII(node1));
        // [1][2, 3, 4][5, 6]
    }
}