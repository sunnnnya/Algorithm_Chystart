package job_interview.alg_basic_know.recursion.array_recursion;

/**
 * @BelongsPackage: job_interview.alg_basic_know.recursion.array
 * @ClassName: GetMaxNumberInArray
 * @Author: 丛虹羽
 * @Date: 2025/3/25 13:10
 * @Description: 获取数组的最大值
 */
public class GetMaxNumber {

    /**
     * 返回数组中的最大值
     *
     * @param nums 原始数组
     * @return 最大值
     */
    public static int getMaxNumberInArray(int[] nums) {
        return dfs(nums, nums.length - 1);
    }

    /**
     * 递归函数的含义：从 0 ~ len上获取最大值
     *
     * @param nums
     * @param len
     * @return
     */
    public static int dfs(int[] nums, int len) {
        if(len == 0) {
            return nums[0];
        }
        return Math.max(dfs(nums, len - 1), nums[len]);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{9, 1, 2, 0, 12, 99, 5, 10};
        System.out.println("MaxNumber: " + getMaxNumberInArray(nums));
        // MaxNumber: 99
    }
}
