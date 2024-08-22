package basic_knowledge.graph.common;

import java.util.ArrayList;

/**
 * @BelongsPackage: basic_knowledge.graph.common
 * @ClassName: GraphNode
 * @Author: 丛虹羽
 * @Date: 2024/8/22 上午9:08
 * @Description: 图中点的结构描述
 */
public class GraphNode {
    public int value;
    public int in;
    public int out;
    public ArrayList<GraphNode> nexts;
    public ArrayList<GraphEdge> edges;

    public GraphNode(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
