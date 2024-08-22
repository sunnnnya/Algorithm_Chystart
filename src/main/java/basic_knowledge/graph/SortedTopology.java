package basic_knowledge.graph;

import basic_knowledge.graph.common.Graph;
import basic_knowledge.graph.common.GraphGenerator;
import basic_knowledge.graph.common.GraphNode;

import java.sql.Array;
import java.util.*;

/**
 * @BelongsPackage: basic_knowledge.graph
 * @ClassName: SortedTopology
 * @Author: 丛虹羽
 * @Date: 2024/8/22 下午10:07
 * @Description: 拓扑排序模板代码实现
 */
public class SortedTopology {

    /**
     * 拓扑排序的实现
     *
     * @param graph
     * @return
     */
    public static List<GraphNode> sortedTopology(Graph graph) {
        if (graph == null) {
            return Collections.emptyList();
        }
        LinkedList<GraphNode> queue = new LinkedList<>();
        for (GraphNode node : graph.nodes.values()) {
            if (node.in == 0) {
                queue.add(node);
            }
        }
        ArrayList<GraphNode> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            GraphNode cur = queue.poll();
            list.add(cur);
            for(GraphNode n : cur.nexts) {
                n.in--;
                if (n.in == 0) {
                    queue.add(n);
                }
            }
        }
        return list;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 1, 5}, {2, 5, 2}, {4, 5, 3}, {3, 2, 7}, {5, 3, 7}};
        Graph graph = GraphGenerator.graphGenerator(arr);
        List<GraphNode> graphNodes = sortedTopology(graph);
        graphNodes.forEach(graphNode -> System.out.print(graphNode.value + " "));
    }
}
