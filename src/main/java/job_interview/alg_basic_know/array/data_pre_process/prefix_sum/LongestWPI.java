package job_interview.alg_basic_know.array.data_pre_process.prefix_sum;

import java.util.HashMap;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.data_pre_process.prefix_sum
 * @ClassName: LongestWPI
 * @Author: 丛虹羽
 * @Date: 2025/3/30 13:51
 * @Description: 表现良好的最长时间段
 * https://leetcode.cn/problems/longest-well-performing-interval/
 */
public class LongestWPI {

    /**
     * 前缀和的使用
     *
     * @param hours 原始数组
     * @return      工作的时间点
     */
    public static int longestWPI(int[] hours) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int mx = 0;
        for(int i = 0, sum = 0; i < hours.length; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if(sum > 0) {
                mx = Math.max(mx, i + 1);
            } else {
                if(map.containsKey(sum - 1)) {
                    mx = Math.max(mx, i - map.get(sum - 1));
                }
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return mx;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{9, 9, 6, 0, 6, 6, 9};
        System.out.println(longestWPI(arr));
        // 3
    }
}
