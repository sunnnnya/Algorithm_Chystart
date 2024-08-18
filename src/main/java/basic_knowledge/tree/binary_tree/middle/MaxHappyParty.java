package basic_knowledge.tree.binary_tree.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: basic_knowledge.tree.binary_tree.middle
 * @ClassName: MaxHappyParty
 * @Author: 丛虹羽
 * @Date: 2024/8/18 下午12:25
 * @Description: 二叉树树形dp 基础
 *
 * 现在有一棵多叉树，表示公司的层级关系，现在要发放请柬到公司开派对，每个人都有自己的 happy 值。
 * 如果自己的老板去了，自己就不能去了，但是自己的员工可以去，请使用 树形dp 求解公司派对的最大 happy 值。
 *               20
 *            / / \ \
 *           1  2  3  4     这棵树的最大 happy 值是 20 + 17 + 20
 *                / \
 *              17  20
 *
 *
 *               x
 *            /  \  \
 *           a    b  c
 * 思路：以 x 节点为头的树的最大 happy 值是多少？Math.max(x参加，x不参加)
 *      情况一：x 参加聚会
 *            【1】x 的 happy 值 + a 不来的最大 happy值 + b 不来的最大 happy 值 + c 不来的最大 happy 值...
 *      情况二：x 不参加聚会
 *            【1】Math.max(a参加最大值, a不参加最大值) + Math.max(b参加最大值, b不参加最大值) + Math.max(c参加最大值, c不参加最大值)
 *
 * 信息体：头节点参加 + 头节点不参加 信息
 */
public class MaxHappyParty {

    /**
     * 多叉树中的节点信息
     */
    public static class Employee {
        public int happy;
        public List<Employee> nexts;

        public Employee(int happy) {
            this.happy = happy;
            nexts = new ArrayList<>();
        }
    }

    /**
     * 信息体
     */
    public static class Info {
        // 头节点 不来 整棵树最大收益
        public int no;
        // 头节点 来 整棵树最大收益
        public int yes;

        public Info(int yes, int no) {
            this.yes = yes;
            this.no = no;
        }
    }

    /**
     * 递归体
     *
     * @param employee
     * @return
     */
    public static Info process(Employee employee) {
        if (employee == null) {
            return new Info(0, 0);
        }
        int yes = employee.happy;
        int no = 0;
        for (Employee e : employee.nexts) {
            Info nextInfo = process(e);
            no += Math.max(nextInfo.no, nextInfo.yes);
            yes += nextInfo.no;
        }
        return new Info(yes, no);
    }

    /**
     * 最大的收益
     * 
     * @param employee
     * @return
     */
    public static int maxHappy(Employee employee) {
        Info allInfo = process(employee);
        return Math.max(allInfo.no, allInfo.yes);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}
