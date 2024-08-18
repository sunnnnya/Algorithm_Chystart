package basic_knowledge.greedy;

import java.util.PriorityQueue;

/**
 * @BelongsPackage: basic_knowledge.greedy
 * @ClassName: CutGold
 * @Author: 丛虹羽
 * @Date: 2024/8/18 下午11:17
 * @Description: 贪心的典型题目
 *
 * 问题描述：长度为20的金条，不管怎么切，都要花费20个铜板(一块金条切成两半，是需要花费和长度数值一样的铜板的)；
 *  例如：给定数组{10,20,30}，代表一共三个人，整块金条长度为60，金条要分成10，20，30三个部分。
 *      如果先把长度60的金条分成10和50，花费60:再把长度50的金条分成20和30，花费50:一共花费110铜板
 *      如果先把长度60的金条分成30和30，花费60:再把长度30金条分成10和20，花费30;一共花费90铜板。
 * 输入一个数组，返回分割的最小代价。
 *
 * 哈夫曼树知识点总结：
 *      1. 统计频率: 统计每个字符在数据中出现的频率。
 *      2. 构建优先队列: 将每个字符及其频率作为一个节点， 并按照频率从小到大的顺序放入优先队列（最小堆）。
 *      3. 构建哈夫曼树:
 *          从优先队列中取出两个频率最小的节点， 构建一个新的父节点， 其频率为两个子节点频率之和。
 *          将新的父节点插回优先队列。
 *          重复上述步骤， 直到队列中只剩下一个节点， 即哈夫曼树的根节点。
 *      4. 生成编码: 从根节点出发， 对每个节点规定左边路径为0， 右边路径为1， 最终从根节点到叶节点的路径构成了该字符的哈夫曼编码。
 *  blog：https://blog.csdn.net/xyy1028/article/details/139965597
 *
 *  总结：
 *      （1）整棵哈夫曼树的代价是所有非叶结点的和；
 *      （2）所有叶子节点的和就是最后的根节点；
 */
public class CutGold {

    /**
     * 实际上就是哈夫曼编码
     *
     * @param arr
     * @return
     */
    public static int cutGold(int[] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int number : arr) {
            heap.add(number);
        }
        // 构建哈夫曼树的总代价,所有非叶子节点值 之和
        int sum = 0;
        int cur = 0;
        while(heap.size() > 1) {
            cur = heap.poll() + heap.poll();
            sum += cur;
            heap.add(cur);
        }
        return sum;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{10, 30, 20};
        System.out.println(cutGold(arr));
        // 90

        //        (60)
        //        /  \
        //      (30)  30        所有叶子节点之和就是根节点的值；
        //      / \             所有非叶子节点的值就是构建整棵树的代价；
        //     10  20
    }
}
