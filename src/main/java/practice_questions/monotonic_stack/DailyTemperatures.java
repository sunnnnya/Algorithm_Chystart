package practice_questions.monotonic_stack;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.monotonic_stack
 * @ClassName: DailyTemperatures
 * @Author: 丛虹羽
 * @Date: 2024/8/25 上午11:22
 * @Description: 每日温度 时间复杂度 O（N）
 *
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * leetcode：https://leetcode.cn/problems/daily-temperatures
 */
public class DailyTemperatures {

    /**
     * 单调栈的使用，从 大 到 小
     *
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length;
        int[] stack = new int[N];
        int[] ans = new int[N];
        for (int i = 0, r = 0; i < N; i++) {
            while (r > 0 && temperatures[stack[r - 1]] < temperatures[i]) {
                ans[stack[r - 1]] = i - stack[--r];
            }
            stack[r++] = i;
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(arr)));
        // [1, 1, 4, 2, 1, 1, 0, 0]

        int[] arr1 = new int[]{30,40,50,60};
        System.out.println(Arrays.toString(dailyTemperatures(arr1)));
        // [1, 1, 1, 0]

        int[] arr2 = new int[]{30,60,90};
        System.out.println(Arrays.toString(dailyTemperatures(arr2)));
        // [1, 1, 0]

        int[] arr3 = new int[]{10, 10, 20, 20, 20, 30, 30, 30};
        System.out.println(Arrays.toString(dailyTemperatures(arr3)));
        // [2, 1, 3, 2, 1, 0, 0, 0]
    }
}
