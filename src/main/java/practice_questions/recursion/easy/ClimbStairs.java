package practice_questions.recursion.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.recursion.easy
 * @ClassName: ClimbStairs
 * @Author: 丛虹羽
 * @Date: 2024/8/15 下午11:47
 * @Description: 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * leetcode:https://leetcode.cn/problems/climbing-stairs
 */
public class ClimbStairs {

    /**
     * 使用递归解题(不使用记忆化搜索)，时间复杂度O（2^N）
     *
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    /**
     * 使用递归 + 记忆化搜索
     *
     * @return
     */
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return f2(n, dp);
    }

    public static int f2(int n, int[] dp) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = f2(n - 1, dp) + f2(n - 2, dp);
        return dp[n];
    }

    /**
     * 一维动态规划，实现
     *
     * @param n
     * @return
     */
    public static int climbStairs3(int n) {
        int[] arr = new int[46];
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i <= 45; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        // 2

        System.out.println(climbStairs(3));
        // 3
    }
}
