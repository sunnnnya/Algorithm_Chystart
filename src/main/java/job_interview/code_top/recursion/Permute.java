package job_interview.code_top.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsPackage: job_interview.code_top.recursion
 * @ClassName: Permute
 * @Author: 丛虹羽
 * @Date: 2025/5/8 13:50
 * @Description: 全排列
 * https://leetcode.cn/problems/permutations/description/
 */
public class Permute {

    /**
     * 全排列
     *
     * @param nums 原始数组
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = Arrays.asList(new Integer[nums.length]);
        boolean[] onPath = new boolean[nums.length];
        dfs(0, nums, ans, list, onPath);
        return ans;
    }

    private static void dfs(int pos, int[] nums, List<List<Integer>> ans, List<Integer> list, boolean[] onPath) {
        if (pos == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!onPath[i]) {
                list.set(pos, nums[i]);
                onPath[i] = true;
                dfs(pos + 1, nums, ans, list, onPath);
                onPath[i] = false;
            }
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
        // [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
    }
}
