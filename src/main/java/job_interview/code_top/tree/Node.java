package job_interview.code_top.tree;

import java.util.List;

/**
 * @BelongsPackage: practice_questions.binary_tree.base
 * @ClassName: Node
 * @Author: 丛虹羽
 * @Date: 2024/12/23 下午4:43
 * @Description: 多叉树中的节点定义
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}