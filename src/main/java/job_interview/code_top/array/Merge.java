package job_interview.code_top.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsPackage: job_interview.code_top.array
 * @ClassName: Merge
 * @Author: 丛虹羽
 * @Date: 2025/5/1 16:37
 * @Description: 合并区间
 * https://leetcode.cn/problems/merge-intervals/description/
 */
public class Merge {

    /**
     * 合并区间
     *
     * @param intervals 区间数组
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        for(int[] p : intervals) {
            int m = ans.size();
            if(m > 0 && p[0] <= ans.get(m - 1)[1]) {
                ans.get(m - 1)[1] = Math.max(ans.get(m - 1)[1], p[1]);
            } else {
                ans.add(p);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] staticArray = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        System.out.println(Arrays.deepToString(merge(staticArray)));
        // [[1, 6], [8, 10], [15, 18]]
    }
}
