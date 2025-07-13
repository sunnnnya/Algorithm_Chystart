package job_interview.hot100.hash_table;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsPackage: job_interview.hot100.hash_table
 * @ClassName: LongestConsecutive
 * @Author: 丛虹羽
 * @Date: 2025/7/12 21:55
 * @Description: 最长连续序列
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class LongestConsecutive {

    /**
     * 哈希表；
     *   首先在 HashSet 中存储所有的元素，然后不断减少要搜索的起始值，然后重新计算一次递增的过程
     *
     * @param nums 原始数组
     * @return 最长连续的序列
     */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for(int num : nums) {
            set.add(num);
        }
        for(int x : set) {
            if(set.contains(x - 1)) {
                continue;
            }
            int y = x + 1;
            while(set.contains(y)) {
                y++;
            }
            ans = Math.max(ans, y - x);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(arr));
        // 4
    }
}
