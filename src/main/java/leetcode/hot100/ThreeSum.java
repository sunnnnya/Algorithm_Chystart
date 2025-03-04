package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @BelongsPackage: leetcode.hot100
 * @ClassName: ThreeSum
 * @Author: 丛虹羽
 * @Date: 2025/3/4 11:19
 * @Description: 三数之和
 *
 * leetcode： https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class ThreeSum {

    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n - 2; i++) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) continue; // 后面出现的重复的数直接跳
            if (x + nums[i + 1] + nums[i + 2] > 0) break; // 优化一
            if (x + nums[n - 2] + nums[n - 1] < 0) continue; // 优化二
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int s = x + nums[j] + nums[k];
                if (s > 0) {
                    k--;
                } else if (s < 0) {
                    j++;
                } else {
                    ans.add(Arrays.asList(i, j, k));
                    for (j++; j < k && nums[j] == nums[j - 1]; j++); // 跳过重复数字
                    for (k--; k > j && nums[k] == nums[k + 1]; k--); // 跳过重复数字
                }
            }
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}
