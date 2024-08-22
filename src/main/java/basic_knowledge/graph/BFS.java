package basic_knowledge.graph;

import basic_knowledge.graph.common.Graph;
import basic_knowledge.graph.common.GraphGenerator;
import basic_knowledge.graph.common.GraphNode;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @BelongsPackage: basic_knowledge.graph
 * @ClassName: BFS
 * @Author: 丛虹羽
 * @Date: 2024/8/22 下午1:38
 * @Description: 图的宽度优先遍历
 */
public class BFS {

    /**
     * 使用队列 + 哈希表(防止出现贿赂继续宁重复判断的)进行图的宽度优先遍历
     *
     * @param node
     */
    public static void bfs(GraphNode node) {
        if (node == null) {
            return;
        }
        HashSet<GraphNode> set = new HashSet<>();
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        set.add(node);
        System.out.println("图的宽度优先遍历顺序：");
        while(!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.value + " ");
            for (GraphNode cur : node.nexts) {
                if (!set.contains(cur)) {
                    set.add(cur);
                    queue.add(cur);
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
        int[][] graphArr = new int[][]{{3, 1, 5}, {6, 5, 3}, {2, 5, 7}, {1, 7, 4}, {8, 4, 3}};
        Graph graph = GraphGenerator.graphGenerator(graphArr);
        bfs(graph.nodes.get(1));
        // 1 5 3 7 4
    }
}
