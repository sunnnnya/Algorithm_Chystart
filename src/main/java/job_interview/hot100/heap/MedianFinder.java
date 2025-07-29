package job_interview.hot100.heap;

import java.util.PriorityQueue;

/**
 * @BelongsPackage: job_interview.hot100.heap
 * @ClassName: MedianFinder
 * @Author: 丛虹羽
 * @Date: 2025/7/29 23:26
 * @Description: 数据流的中位数
 * https://leetcode.cn/problems/find-median-from-data-stream/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class MedianFinder {

    private PriorityQueue<Integer> left;

    private PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((a , b) -> {
            return b - a;
        });
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(left.size() == right.size()) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
    }

    public double findMedian() {
        if(left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }
}
