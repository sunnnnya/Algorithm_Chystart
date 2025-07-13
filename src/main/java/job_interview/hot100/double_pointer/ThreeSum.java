package job_interview.hot100.double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsPackage: job_interview.hot100.double_pointer
 * @ClassName: ThreeSum
 * @Author: 丛虹羽
 * @Date: 2025/7/13 11:25
 * @Description: 三数之和
 * https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class ThreeSum {

    /**
     * 测试
     *
     * @param nums 原始数组
     * @return List<List<Integer>>
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n - 2; i++) {
            int x = nums[i];
            if(i > 0 && x == nums[i - 1]) continue;
            if(x + nums[n - 1] + nums[n - 2] < 0) continue;
            if(x + nums[i + 1] + nums[i + 2] > 0) break;
            int j = i + 1, k = n - 1;
            while(j < k) {
                int s = x + nums[j] + nums[k];
                if(s < 0) j++;
                else if(s > 0) k--;
                else {
                    ans.add(Arrays.asList(x, nums[j], nums[k]));
                    for(j++; j < k && nums[j] == nums[j - 1]; j++);
                    for(k--; j < k && nums[k] == nums[k + 1]; k--);
                }
            }
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
        // [[-1, -1, 2], [-1, 0, 1]]
    }
}
