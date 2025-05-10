package job_interview.code_top.tree.binary_tree;

import practice_questions.binary_tree.base.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsPackage: job_interview.code_top.tree.binary_tree
 * @ClassName: LevelOrderIII
 * @Author: 丛虹羽
 * @Date: 2025/5/10 11:49
 * @Description: N 叉树的层序遍历
 * https://leetcode.cn/problems/n-ary-tree-level-order-traversal/description/?envType=problem-list-v2&envId=nbQFMpWe
 */
public class LevelOrderIII {

    private static int MAXN = 100005;

    private static Node[] queue = new Node[MAXN];

    private static int l, r;

    /**
     * N 叉树的层序遍历
     *
     * @param root
     * @return
     */
    static List<List<Integer>> levelOrder(Node root) {
        l = 0;
        r = 0;
        queue[r++] = root;
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        while(l < r) {
            int size = r - l;
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                Node cur = queue[l++];
                list.add(cur.val);
                if(cur.children != null) {
                    for (Node node : cur.children) {
                        queue[r++] = node;
                    }
                }
            }
            ans.add(list);
        }
        return ans;
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
        System.out.println(levelOrder(node1));
        //
    }
}
