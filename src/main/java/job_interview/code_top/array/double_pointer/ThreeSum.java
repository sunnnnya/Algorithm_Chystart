package job_interview.code_top.array.double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsPackage: job_interview.code_top.array.double_pointer
 * @ClassName: ThreeSum
 * @Author: 丛虹羽
 * @Date: 2025/5/14 21:18
 * @Description: 三数之和
 * https://leetcode.cn/problems/3sum/description/
 */
public class ThreeSum {

    /**
     * 三数之和
     *
     * @param nums 原始数组
     * @return List<List<Integer>>
     */
    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n - 2; i++) {
            int x = nums[i];
            if(i > 0 && x == nums[i - 1]) continue;
            if(x + nums[n - 2] + nums[n - 1] < 0) continue;
            if(x + nums[i + 1] + nums[i + 2] > 0) break;
            int j = i + 1, k = n - 1;
            // i != j && j != k
            while(j < k) {
                int s = x + nums[j] + nums[k];
                if(s > 0) k--;
                else if(s < 0) j++;
                else {
                    ans.add(Arrays.asList(x, nums[j], nums[k]));
                    // 过滤重复元素
                    for(j++; j < k && nums[j] == nums[j - 1]; j++);
                    // 过滤重复元素
                    for(k--; j < k && nums[k] == nums[k + 1]; k--);
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
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
        //
    }
}
