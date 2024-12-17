package practice_questions.slide_window.easy;

/**
 * @BelongsPackage: practice_questions.slide_window.easy
 * @ClassName: FindShortestSubArray
 * @Author: 丛虹羽
 * @Date: 2024/12/17 下午10:43
 * @Description: 数组的度
 *
 * leetcode: https://leetcode.cn/problems/degree-of-an-array
 */
public class FindShortestSubArray {

    /**
     * 使用数组替换传统的 hashMap
     * 使用不定长滑窗
     *
     * @param nums 原始数组
     * @return     最段的度的长度
     */
    public static int findShortestSubArray(int[] nums) {
        // 数据范围固定使用数组进行词频统计
        int[] map = new int[50000];
        int count = findMaxCountNumber(nums);
        // 不定长最短滑窗
        int ans = nums.length + 1;
        for(int i = 0, left = 0; i < nums.length; i++) {
            map[nums[i]]++;
            while(map[nums[i]] == count) {
                ans = Math.min(ans, i - left + 1);
                map[nums[left++]]--;
            }
        }
        return ans;
    }

    /**
     * 找到数组中出现次数最多的次数: 2，最多重复次数 2 次
     *
     * @param nums 原始数组
     * @return
     */
    private static int findMaxCountNumber(int[] nums) {
        int[] help = new int[50000];
        int max = 0;
        for(int number : nums) {
            help[number]++;
            max = Math.max(max, help[number]);
        }
        return max;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,1};
        System.out.println(findShortestSubArray(arr));
        // 2
    }
}
