package job_interview.alg_basic_know.recursion.array_recursion;

/**
 * @BelongsPackage: job_interview.alg_basic_know.recursion.array_recursion
 * @ClassName: GetSum
 * @Author: 丛虹羽
 * @Date: 2025/5/17 12:57
 * @Description: 使用递归的方式获取数组的和
 */
public class GetSum {

    /**
     * 使用递归的方式求解数组的和
     *
     * @param nums 数组
     * @return int
     */
    static int sum(int[] nums) {
        return dfs(nums, nums.length - 1);
    }

    /**
     * 返回 0 ~ N 的之间的元素和
     *
     * @param nums 数组
     * @param n 下标
     * @return int
     */
    static int dfs(int[] nums, int n) {
        if(n == 0) {
            return nums[0];
        }
        return nums[n] + dfs(nums, n - 1);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println("Sum: " + sum(nums));
        // Sum: 15
    }
}
