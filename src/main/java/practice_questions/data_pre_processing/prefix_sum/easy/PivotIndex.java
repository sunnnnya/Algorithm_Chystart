package practice_questions.data_pre_processing.prefix_sum.easy;

/**
 * @BelongsPackage: practice_questions.data_pre_processing.prefix_sum.easy
 * @ClassName: PivotIndex
 * @Author: 丛虹羽
 * @Date: 2024/12/13 下午10:06
 * @Description: 寻找数组的中心下标
 *
 * leetcode： https://leetcode.cn/problems/tvdfij
 */
public class PivotIndex {
    /**
     * 前缀和的基本使用方式
     *
     * @param nums 原始数组
     * @return     符合条件的索引位置
     */
    public static int pivotIndex(int[] nums) {
        int N = nums.length;
        if(N == 1) {
            return 0;
        }
        // 构建前缀和数组
        for(int i = 1; i < N; i++) {
            nums[i] += nums[i - 1];
        }
        if(nums[N - 1] - nums[0] == 0) {
            return 0;
        }
        int ans = -1;
        for (int i = 1; i < N - 1; i++) {
            if (nums[N - 1] - nums[i] == nums[i - 1]) {
                ans = i;
                break;
            }
        }
        if (ans == -1 && nums[nums.length - 2] == 0) {
            return nums.length - 1;
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(arr));
        // 3
    }
}