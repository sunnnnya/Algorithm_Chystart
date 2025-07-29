package job_interview.hot100.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @BelongsPackage: job_interview.hot100.heap
 * @ClassName: TopKFrequent
 * @Author: 丛虹羽
 * @Date: 2025/7/29 23:03
 * @Description: 前 K 个高频元素
 * https://leetcode.cn/problems/top-k-frequent-elements/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class TopKFrequent {

    /**
     * 优先级队列 + 哈希表统计
     *   使用 哈希表 进行数量的统计，使用优先级队列进行答案更新处理
     *
     * @param nums 原始数组
     * @param k    k 个元素
     * @return int[]
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((l1, l2) -> {
            return l1[1] - l2[1];
        });
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            if(queue.size() == k) {
                if(queue.peek()[1] < value) {
                    queue.poll();
                    queue.offer(new int[]{key, value});
                }
            } else {
                queue.offer(new int[]{key, value});
            }
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = queue.poll()[0];
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
        // [2, 1]
    }
}
