package job_interview.alg_basic_know.array.data_pre_process.prefix_sum;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.data_preprocess.prefix_sum
 * @ClassName: PrefixSumArray
 * @Author: 丛虹羽
 * @Date: 2025/3/28 20:00
 * @Description: 区域和检索 - 数组不可变
 * https://leetcode.cn/problems/range-sum-query-immutable/description/
 */
public class NumArray {

    /**
     * 直接在原数组上进行修改
     *
     * @param nums 原始数组
     * @return     前缀和数组
     */
    public static int[] getPrefixSum(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    /**
     * 不扩充数组的方式获取指定区间的和
     *
     * @param nums   原始数组
     * @param left   left index
     * @param right  right index
     * @return       区间的范围和
     */
    public static int getResult(int[] nums, int left, int right) {
        return left == 0 ? nums[right] : nums[right] - nums[left - 1];
    }

    /**
     * 使用辅助数组进行处理数据，省去边界讨论的问题
     *
     * @param nums 原始数组
     * @return     前缀和数组
     */
    public static int[] getPrefixSumExtArray(int[] nums) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        for(int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        return sum;
    }

    /**
     * 获取指定索引范围的数据之和
     *
     * @param nums 原始数组
     * @return 返回范围中的值
     */
    public static int getResultWithExtArray(int[] nums, int left, int right) {
        return nums[right + 1] - nums[left];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{9, 1, -2, 3, -6, 21, 11, 100};
        int[] ans = getPrefixSum(nums);
        System.out.println(getResult(ans, 0, 2)); // 8
        System.out.println(getResult(ans, 1, 3)); // 2
        System.out.println(getResult(ans, 1, 5)); // 17

        System.out.println();

        int[] nums1 = new int[]{-1, -2, 3, 2, 1, -2, 21, 10};
        int[] ans1 = getPrefixSumExtArray(nums1);
        System.out.println(getResultWithExtArray(ans1, 0, 2)); // 0
        System.out.println(getResultWithExtArray(ans1, 1, 3)); // 3
        System.out.println(getResultWithExtArray(ans1, 1, 5)); // 2
    }
}
