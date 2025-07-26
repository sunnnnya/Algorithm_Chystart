package job_interview.hot100.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: job_interview.hot100.back_track
 * @ClassName: CombinationSum
 * @Author: 丛虹羽
 * @Date: 2025/7/26 21:16
 * @Description: 组合总和
 * https://leetcode.cn/problems/combination-sum/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class CombinationSum {

    /**
     * 选或者不选的问题
     *
     * @param candidates 原始数组
     * @param target 目标值
     * @return List<List<Integer>>
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, ans, path, target, candidates);
        return ans;
    }

    /**
     * 记忆
     *
     * @param pos 位置坐标
     * @param ans 答案累计
     * @param path 路径数组
     * @param target 目标值
     * @param candidates 原始数组
     */
    private static void dfs(int pos, List<List<Integer>> ans, List<Integer> path, int target, int[] candidates) {
        if(target == 0) {
            ans.add(new ArrayList<>(path));
            return ;
        }
        if(pos == candidates.length || target < 0) {
            return ;
        }
        dfs(pos + 1, ans, path, target, candidates);
        path.add(candidates[pos]);
        dfs(pos, ans, path, target - candidates[pos], candidates);
        path.remove(path.size() - 1);
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
        // [[7], [2, 2, 3]]
    }
}
