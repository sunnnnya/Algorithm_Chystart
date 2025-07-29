package job_interview.hot100.stack;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.hot100.stack
 * @ClassName: DailyTemperatures
 * @Author: 丛虹羽
 * @Date: 2025/7/29 11:27
 * @Description: 每日温度
 * https://leetcode.cn/problems/daily-temperatures/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class DailyTemperatures {

    /**
     * 单调栈使用
     *
     * @param temperatures 温度数组
     * @return int[]
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        int[] stack = new int[n];
        for(int i = 0, r = 0; i < temperatures.length; i++) {
            while(r > 0 && temperatures[i] > temperatures[stack[r - 1]]) {
                ans[stack[r - 1]] = i - stack[--r];
            }
            stack[r++] = i;
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(nums)));
        // [1, 1, 4, 2, 1, 1, 0, 0]
    }
}
