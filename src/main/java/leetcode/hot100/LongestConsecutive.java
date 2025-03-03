package leetcode.hot100;

import java.util.HashSet;

/**
 * @BelongsPackage: leetcode.hot100
 * @ClassName: LongestConsecutive
 * @Author: 丛虹羽
 * @Date: 2025/3/3 21:08
 * @Description: 最长连续序列
 *
 * leetcode：https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class LongestConsecutive {

    /**
     * 哈希表
     *
     * @param nums 原始数组
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for(int num : nums) {
            set.add(num);
        }
        for(int s : set) {
            if(set.contains(s - 1)) {
                continue;
            }
            // 优化点：从最小的点出发到达的最长的位置信息！
            int y = s + 1;
            while(set.contains(y)) {
                y++;
            }
            ans = Math.max(ans, y - s);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(arr));
        // 4

        int[] arr2 = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(arr2));
        // 9

        int[] arr3 = new int[]{1,0,1,2};
        System.out.println(longestConsecutive(arr3));
        // 3
    }
}
