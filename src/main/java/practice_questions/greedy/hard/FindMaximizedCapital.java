package practice_questions.greedy.hard;

import java.util.PriorityQueue;

/**
 * @BelongsPackage: basic_knowledge.greedy
 * @ClassName: FindMaximizedCapital
 * @Author: 丛虹羽
 * @Date: 2024/8/19 上午12:18
 * @Description: IPO
 *
 * 力扣希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
 * 给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。
 * 最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
 * 总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。
 *
 */
public class FindMaximizedCapital {

    /**
     * 项目的实体类
     */
    public static class Project {
        public int cost;
        public int profit;

        public Project(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    /**
     * 贪心策略的使用，找到当前资金范围内收益最大的项目投资
     *
     * @param k
     * @param w
     * @param profits
     * @param capital
     * @return
     */
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if(k == 0) {
            return w;
        }
        // 小根堆：按照项目的花费从小到大
        PriorityQueue<Project> costHeap = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        // 大根堆：按照项目的收益从大到小
        PriorityQueue<Project> profitHeap = new PriorityQueue<>((o1, o2) -> o2.profit - o1.profit);
        for (int i = 0; i < profits.length; i++) {
            costHeap.add(new Project(capital[i], profits[i]));
        }
        while (k-- > 0) {
            while (!costHeap.isEmpty() && costHeap.peek().cost <= w) {
                profitHeap.add(costHeap.poll());
            }
            // 资金没有办法解锁新项目，凑不够k个的话，就直接返回
            if (profitHeap.isEmpty()) {
                return w;
            }
            w += profitHeap.poll().profit;
        }
        return w;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
        // 4

        System.out.println(findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}));
        // 6
    }
}
