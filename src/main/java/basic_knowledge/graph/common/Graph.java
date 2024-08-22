package basic_knowledge.graph.common;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @BelongsPackage: basic_knowledge.graph.common
 * @ClassName: Graph
 * @Author: 丛虹羽
 * @Date: 2024/8/22 上午9:13
 * @Description: 图的结构描述
 */
public class Graph {
    public HashMap<Integer, GraphNode> nodes;
    public HashSet<GraphEdge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }
}
