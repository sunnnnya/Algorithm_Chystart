package job_interview.hot100.sub_string;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsPackage: job_interview.hot100.sub_string
 * @ClassName: MaxSlidingWindow
 * @Author: 丛虹羽
 * @Date: 2025/7/13 16:20
 * @Description: 滑动窗口最大值
 * https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class MaxSlidingWindow {

    /**
     * 定长滑动窗口 + 双端队列
     *
     * @param nums 原始数组
     * @param k    k 位数
     * @return 窗口中的最大值
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++) {
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        ans[0] = deque.peekFirst();
        for(int i = k; i < nums.length; i++) {
            if(deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            ans[i - k + 1] = deque.peekFirst();
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
        // [3, 3, 5, 5, 6, 7]
    }
}
