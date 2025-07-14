package job_interview.hot100.ordinary_array;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.hot100.ordinary_array
 * @ClassName: ProductExceptSelf
 * @Author: 丛虹羽
 * @Date: 2025/7/14 12:56
 * @Description: 除自身以外数组的乘积
 * https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class ProductExceptSelf {

    /**
     * 先从后到钱进行遍历，再从前到后进行成绩计算
     *
     * @param nums 原始数组
     * @return int[]
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--) {
            ans[i] = ans[i + 1] * nums[i + 1];
        }
        int pre = 1;
        for(int i = 0; i < n; i++) {
            ans[i] *= pre;
            pre *= nums[i];
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        // [24, 12, 8, 6]
    }
}
