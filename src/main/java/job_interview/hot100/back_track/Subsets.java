package job_interview.hot100.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: job_interview.hot100.back_track
 * @ClassName: Subsets
 * @Author: 丛虹羽
 * @Date: 2025/7/26 17:31
 * @Description: 子集
 * https://leetcode.cn/problems/subsets/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Subsets {

    /**
     * 选或者不选的问题
     *
     * @param nums 原始数组
     * @return List<List<Integer>>
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(0, ans, list, nums);
        return ans;
    }

    /**
     * 深度优先搜索遍历
     *
     * @param pos  位置
     * @param ans  答案统计
     * @param list 答案列表
     * @param nums
     */
    private static void dfs(int pos, List<List<Integer>> ans, List<Integer> list, int[] nums) {
        if(pos == nums.length) {
            ans.add(new ArrayList<>(list));
            return ;
        }
        dfs(pos + 1, ans, list, nums);
        list.add(nums[pos]);
        dfs(pos + 1, ans, list, nums);
        list.remove(list.size() - 1);
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsets(nums));
        // [[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]
    }
}
