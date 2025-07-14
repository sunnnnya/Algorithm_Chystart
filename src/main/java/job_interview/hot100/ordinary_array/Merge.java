package job_interview.hot100.ordinary_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsPackage: job_interview.hot100.ordinary_array
 * @ClassName: Merge
 * @Author: 丛虹羽
 * @Date: 2025/7/14 12:24
 * @Description: 合并区间
 * https://leetcode.cn/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Merge {

    /**
     * 贪心算法思想：
     *  可拓展就不断更新右边界，不可更新，直接填充答案
     *
     * @param intervals 原始数组
     * @return int[][]
     */
    public static int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (nums1, nums2) -> (nums1[0] - nums2[0]));
        for(int[] interval : intervals) {
            int m = ans.size();
            if(m > 0 && interval[0] <= ans.get(m - 1)[1]) {
                ans.get(m - 1)[1] = Math.max(interval[1], ans.get(m - 1)[1]);
            } else {
                ans.add(interval);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(nums)));
        // [[1, 6], [8, 10], [15, 18]]
    }
}
