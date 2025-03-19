package leetcode.hot100;

import java.util.Arrays;

/**
 * @BelongsPackage: leetcode.hot100
 * @ClassName: Rob
 * @Author: 丛虹羽
 * @Date: 2025/3/18 22:56
 * @Description: 打家劫舍
 *
 * leetcode: https://leetcode.cn/problems/house-robber/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Rob {

    /**
     * 记忆化搜索
     *
     * @param nums 原始数组
     * @return     偷取钱币的最大数
     */
    public static int rob1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return dfs(nums,n - 1, dp);
    }

    /**
     * 递归函数的含义表示从 0 ~ i 获取到的最大价值是多少
     *
     * @param i 第 i 个房子
     * @return 最大价值
     */
    public static int dfs(int[] nums, int i, int[] dp) {
        if(i < 0) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        dp[i] = Math.max(dfs(nums, i - 1, dp), dfs(nums,i - 2, dp) + nums[i]);
        return dp[i];
    }

    /**
     * 动态规划
     *
     * @param nums 原始数组
     * @return     偷取钱币的最大数
     */
    public static int rob(int[] nums) {
        int n = nums.length;
        // 此处为了对 i = 0 时候出现f[-1] f[-2] 进行特殊处理，所以直接设置为 n + 2的长度
        int[] f = new int[n + 2];
        for (int i = 0; i < n; i++) {
            f[i + 2] = Math.max(f[i + 1], f[i] + nums[i]);
        }
        return f[n + 1];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,9,3,1};
        System.out.println(rob(arr));
        // 12
    }
}
