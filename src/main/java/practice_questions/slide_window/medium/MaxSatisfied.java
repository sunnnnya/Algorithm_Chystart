package practice_questions.slide_window.medium;

/**
 * @BelongsPackage: practice_questions.slide_window.medium
 * @ClassName: MaxSatisfied
 * @Author: 丛虹羽
 * @Date: 2024/12/8 上午10:15
 * @Description: 爱生气的书店老板
 *
 * leetcode：https://leetcode.cn/problems/grumpy-bookstore-owner
 */
public class MaxSatisfied {

    /**
     * 把问题进行拆分，一部分拿到不生气的值的和，一部分拿到规定范围内的生气的最大值
     *
     * @param customers
     * @param grumpy
     * @param minutes
     * @return
     */
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int[] s = new int[2];
        int max = 0;
        for(int i = 0; i < customers.length; i++) {
            // 关键点：分情况相加，
            //  s[0] 一直记录的是不生气的顾客数目
            //  s[1] 在窗口中找到生气的最大值
            s[grumpy[i]] += customers[i];
            if (i < minutes - 1) {
                continue;
            }
            max = Math.max(max, s[1]);
            // 如果离开窗口元素的生气数组是 1，则减去顾客数，反之 -0
            s[1] -= grumpy[i - minutes + 1] > 0 ? customers[i - minutes + 1] : 0;
        }
        return s[0] + max;
    }
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] customer = new int[]{1,0,1,2,1,1,7,5};
        int[] grumpy = new int[]{0,1,0,1,0,1,0,1};
        int minutes = 3;
        System.out.println("最大的满意度：" + maxSatisfied(customer, grumpy, 3));
    }
}