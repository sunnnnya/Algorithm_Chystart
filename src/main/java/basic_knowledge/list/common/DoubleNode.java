package basic_knowledge.list.common;

/**
 * @BelongsPackage: basic_knowledge.list.common
 * @ClassName: DoubleNode
 * @Author: 丛虹羽
 * @Date: 2024/12/2 下午9:12
 * @Description: 双链表的节点结构
 */
public class DoubleNode {
    public Integer data;
    public DoubleNode last;
    public DoubleNode next;

    public DoubleNode(Integer data) {
        this.data = data;
    }
}