package job_interview.hot100.dynamic_programming;

/**
 * @BelongsPackage: job_interview.hot100.dynamic_programming
 * @ClassName: MaxProduct
 * @Author: 丛虹羽
 * @Date: 2025/8/3 15:57
 * @Description: 乘积最大子数组
 * https://leetcode.cn/problems/maximum-product-subarray/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class MaxProduct {

    /**
     * 维护好最大和最小的数值
     *
     * @param nums 原始数组
     * @return int
     */
    public static int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int min = 1;
        int max = 1;
        for(int num : nums) {
            int mx = max;
            max = Math.max(Math.max(min * num, max * num), num);
            min = Math.min(Math.min(min * num, mx * num), num);
            ans = Math.max(Math.max(min, max), ans);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,-2,4};
        System.out.println(maxProduct(nums));
        // 6
    }
}
