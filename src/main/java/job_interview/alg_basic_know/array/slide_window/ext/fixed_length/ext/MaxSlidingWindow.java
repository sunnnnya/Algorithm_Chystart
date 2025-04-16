package job_interview.alg_basic_know.array.slide_window.ext.fixed_length.ext;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.slide_window.ext.fixed_length.ext
 * @ClassName: MaxSlidingWindow
 * @Author: 丛虹羽
 * @Date: 2025/4/16 17:08
 * @Description: 滑动窗口最大值
 * https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class MaxSlidingWindow {

    /**
     * 定长滑窗 —— TLE —— 优先队列的时间复杂度太高了
     *
     * @param nums 原始数组
     * @param k    窗口宽度
     * @return
     */
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int[] ans = new int[nums.length - k + 1];
        for(int i = 0, idx = 0; i < nums.length; i++) {
            if(i < k - 1) {
                queue.add(nums[i]);
                continue;
            }
            queue.add(nums[i]);
            ans[idx] = queue.peek();
            queue.remove(nums[idx++]);
        }
        return ans;
    }

    /**
     * 使用双端队列模拟最大值的情况
     *  维持最大值
     *
     * @param nums 原始数组
     * @param k    窗口宽度
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if(i > 0 && deque.peekFirst() == nums[i - 1]){
                deque.removeFirst();
            }
            while(!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            // 记录窗口最大值
            if(i >= 0) {
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
        // [3, 3, 5, 5, 6, 7]
    }
}
