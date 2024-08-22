package basic_knowledge.graph.common;

/**
 * @BelongsPackage: basic_knowledge.graph.common
 * @ClassName: GraphEdge
 * @Author: 丛虹羽
 * @Date: 2024/8/22 上午9:11
 * @Description: 图中边的描述信息
 */
public class GraphEdge {
    public int weigth;
    public GraphNode from;
    public GraphNode to;

    public GraphEdge(int weigth, GraphNode from, GraphNode to) {
        this.weigth = weigth;
        this.from = from;
        this.to = to;
    }
}
