package basic_knowledge.dynamic_program.two_dimensional;

import java.util.Arrays;

/**
 * @package: basic_knowledge.dynamic_program.two_dimensional
 * @author: chystart
 * @create: 2024-12-29 10:41
 * @description: 背包问题
 **/
public class Knapsack {

    /**
     * 暴力递归
     *      0/1 背包问题
     *
     * @param w   重量数组
     * @param v   价值数组
     * @param bag 背包容量
     * @return    不超重的情况下，能够得到的最大价值
     */
    public static int maxValue(int[] w, int[] v, int bag) {
        if(w == null || v == null || w.length != v.length || w.length == 0 || bag <= 0) {
            return 0;
        }
        return process(w, v, 0, bag);
    }

    /**
     * 表示从 index 位置到最后位置可以获得到的最大价值
     *      从左往右的尝试模型
     *  [index, w.length - 1]
     *
     * @param w     重量数组
     * @param v     价值数组
     * @param index 考虑 index 号货物
     * @param bag   背包容量
     * @return      最大价值
     */
    public static int process(int[] w, int[] v, int index, int bag) {
        if(bag < 0) {
            return -1;
        }
        if(index == w.length) {
            return 0;
        }
        int p1 = process(w, v,index + 1,bag);
        // 如果 base case 设置为 bag < 0 return 0，会出现问题！！！
        // 当前背包容量 6，返回 v[index] + process(w, v,index + 1,bag - w[index]);
        // 其中 process 会因为错误的 base case 返回 0.导致价值中添加了 v[index] 但其实是装不下的！！！
        // 所以先检验！！
        int p2 = 0;
        int next = process(w, v,index + 1,bag - w[index]);
        if(next != -1) {
            p2 = v[index] + next;
        }
        return Math.max(p1, p2);
    }

    /**
     * 暴力递归 + 缓存表 = 记忆化搜索
     *
     * @param w   重量数组
     * @param v   价值数组
     * @param bag 背包容量
     * @return    不超重的情况下，能够得到的最大价值
     */
    public static int maxValue1(int[] w, int[] v, int bag) {
        if(w == null || v == null || w.length != v.length || w.length == 0 || bag <= 0) {
            return 0;
        }
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];
        for(int i = 0; i < N + 1; i++) {
            for(int j = 0; j < bag + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return process1(w, v, 0, bag, dp);
    }

    /**
     * 表示从 index 位置到最后位置可以获得到的最大价值
     *      从左往右的尝试模型
     *  [index, w.length - 1]
     *
     * @param w     重量数组
     * @param v     价值数组
     * @param index 考虑 index 号货物
     * @param bag   背包容量
     * @return      最大价值
     */
    public static int process1(int[] w, int[] v, int index, int bag, int[][] dp) {
        if(bag < 0) {
            return -1;
        }
        if(index == w.length) {
            return 0;
        }
        if(dp[index][bag] != -1) {
            return dp[index][bag];
        }
        int p1 = process1(w, v,index + 1,bag, dp);
        int p2 = 0;
        int next = process1(w, v,index + 1,bag - w[index], dp);
        if(next != -1) {
            p2 = v[index] + next;
        }
        dp[index][bag] = Math.max(p1, p2);
        return dp[index][bag];
    }

    /**
     * 动态规划
     *
     * @param w   重量数组
     * @param v   价值数组
     * @param bag 背包容量
     * @return    不超重的情况下，能够得到的最大价值
     */
    public static int maxValue2(int[] w, int[] v, int bag) {
        if(w == null || v == null || w.length != v.length || w.length == 0 || bag <= 0) {
            return 0;
        }
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];
        for(int i = N - 1; i >= 0; i--) {
            for(int j = 0; j <= bag; j++) {
                int p1 = dp[i + 1][j];
                int p2 = 0;
                int next = j - w[i] < 0 ? -1 : dp[i + 1][j - w[i]];
                if(next != -1) {
                    p2 = v[i] + next;
                }
                dp[i][j] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 测试用例1：小型背包问题
        int[] w1 = {2, 3, 4, 5};     // 物品重量：2kg, 3kg, 4kg, 5kg
        int[] v1 = {3, 4, 5, 6};     // 对应价值：3元, 4元, 5元, 6元
        int bag1 = 10;               // 背包容量：10kg
        System.out.println("测试用例1 - 小型背包:");
        System.out.println("物品重量: " + Arrays.toString(w1));
        System.out.println("物品价值: " + Arrays.toString(v1));
        System.out.println("背包容量: " + bag1);
        System.out.println("最大价值: " + maxValue2(w1, v1, bag1));
        System.out.println("------------------------");

        // 测试用例2：价值差异大的情况
        int[] w2 = {1, 2, 3, 4};     // 物品重量：1kg, 2kg, 3kg, 4kg
        int[] v2 = {2, 8, 3, 10};    // 对应价值：2元, 8元, 3元, 10元
        int bag2 = 6;                // 背包容量：6kg
        System.out.println("测试用例2 - 价值差异大:");
        System.out.println("物品重量: " + Arrays.toString(w2));
        System.out.println("物品价值: " + Arrays.toString(v2));
        System.out.println("背包容量: " + bag2);
        System.out.println("最大价值: " + maxValue2(w2, v2, bag2));
        System.out.println("------------------------");

        // 测试用例3：重量相近的情况
        int[] w3 = {5, 4, 6, 5};     // 物品重量：5kg, 4kg, 6kg, 5kg
        int[] v3 = {8, 6, 9, 7};     // 对应价值：8元, 6元, 9元, 7元
        int bag3 = 15;               // 背包容量：15kg
        System.out.println("测试用例3 - 重量相近:");
        System.out.println("物品重量: " + Arrays.toString(w3));
        System.out.println("物品价值: " + Arrays.toString(v3));
        System.out.println("背包容量: " + bag3);
        System.out.println("最大价值: " + maxValue2(w3, v3, bag3));
    }
}