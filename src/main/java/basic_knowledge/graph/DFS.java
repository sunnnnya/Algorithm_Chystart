package basic_knowledge.graph;

import basic_knowledge.graph.common.Graph;
import basic_knowledge.graph.common.GraphGenerator;
import basic_knowledge.graph.common.GraphNode;
import java.util.HashSet;
import java.util.Stack;

/**
 * @BelongsPackage: basic_knowledge.graph
 * @ClassName: DFS
 * @Author: 丛虹羽
 * @Date: 2024/8/22 下午1:58
 * @Description: 图的深度优先遍历
 */
public class DFS {

    /**
     * 使用栈实现图的深度优先遍历
     *
     * @param node
     */
    public static void dfs(GraphNode node) {
        // 当前节点不能再走了
        if (node == null) {
            return ;
        }
        Stack<GraphNode> stack = new Stack<>();
        HashSet<GraphNode> set = new HashSet<>();
        set.add(node);
        stack.push(node);
        System.out.print(node.value + " ");
        while (!stack.isEmpty()) {
            GraphNode cur = stack.pop();
            for(GraphNode next : cur.nexts) {
                if (!set.contains(next)) {
                    // 先验证老节点，再压入新的节点
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.print(next.value + " ");
                    break;
                }
            }
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] graphArr = new int[][]{{9, 1, 7}, {1, 1, 2}, {3, 2, 3}, {2, 2, 5}, {7, 5, 6}, {6, 6, 3}, {4, 3, 4}, {5, 4, 3}};
        Graph graph = GraphGenerator.graphGenerator(graphArr);
        System.out.println("图的深度优先遍历1：");
        dfs(graph.nodes.get(1));
        // 1 7 2 3 4 5 6

        System.out.println();

        int[][] graphArr1 = new int[][]{{6, 1, 5}, {3, 5, 7}, {2, 7, 2}, {1, 7, 4}, {5, 2, 6}, {7, 6, 4}};
        Graph graph1 = GraphGenerator.graphGenerator(graphArr1);
        System.out.println("图的深度优先遍历2：");
        dfs(graph1.nodes.get(1));
        // 1 5 7 2 6 4
    }
}
