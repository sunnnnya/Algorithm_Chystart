package basic_knowledge.graph.common;

/**
 * @BelongsPackage: basic_knowledge.graph.common
 * @ClassName: GraphGenerator
 * @Author: 丛虹羽
 * @Date: 2024/8/22 上午9:17
 * @Description: 给了指定的数据结构，转换成通用的结构
 */
public class GraphGenerator {
    /**
     * N * 3 的矩阵
     * [wight, from节点上面的值, to节点上面的值]
     *
     * @param matrix
     * @return
     */
    public static Graph graphGenerator(int[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            // 拿到节点表示的信息
            int weight = matrix[i][0];
            int from = matrix[i][1];
            int to = matrix[i][2];
            // 创建图中点集的过程
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new GraphNode(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new GraphNode(to));
            }
            GraphNode fromNode = graph.nodes.get(from);
            GraphNode toNode = graph.nodes.get(to);
            GraphEdge edge = new GraphEdge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(edge);
            graph.edges.add(edge);
        }
        return graph;
    }
}
