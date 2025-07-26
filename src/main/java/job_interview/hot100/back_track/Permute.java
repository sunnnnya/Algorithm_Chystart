package job_interview.hot100.back_track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsPackage: job_interview.hot100.back_track
 * @ClassName: Permute
 * @Author: 丛虹羽
 * @Date: 2025/7/26 17:09
 * @Description: 全排列
 * https://leetcode.cn/problems/permutations/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Permute {

    /**
     * 回溯的基本使用
     *
     * @param nums 原始数据
     * @return List<List<Integer>>
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = Arrays.asList(new Integer[nums.length]);
        boolean[] path = new boolean[nums.length];
        dfs(0, ans, list, nums, path);
        return ans;
    }

    /**
     * 进行递归的操作
     *
     * @param pos 位置
     * @param ans 答案
     * @param list 列表
     * @param nums 原始数据
     * @param path 记录数组
     */
    private static void dfs(int pos, List<List<Integer>> ans, List<Integer> list, int[] nums, boolean[] path) {
        if(pos == nums.length) {
            ans.add(new ArrayList<Integer>(list));
            return ;
        }
        for(int i = 0; i < nums.length; i++) {
            if(! path[i]) {
                list.set(pos, nums[i]);
                path[i] = true;
                dfs(pos + 1, ans, list, nums, path);
                path[i] = false;
            }
        }
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
        // [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
    }
}
