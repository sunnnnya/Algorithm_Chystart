package practice_questions.prefix_sum_array.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.prefix_sum_array.easy
 * @ClassName: NumArray
 * @Author: 丛虹羽
 * @Date: 2024/9/2 下午9:54
 * @Description: 区域和检索 - 数组不可变
 *
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 *
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 *      NumArray(int[] nums) 使用数组 nums 初始化对象
 *      int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，
 *          包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
 *
 * leetcode: https://leetcode.cn/problems/range-sum-query-immutable
 */
public class NumArray {

    /**
     * 前缀和数组
     */
    public int[] sum;

    /**
     * 前缀和数组的初始化
     *
     * @param nums
     */
    public NumArray(int[] nums) {
        if (nums.length == 1) {
            this.sum = nums;
        }
        int N = nums.length;
        this.sum = new int[N];
        sum[0] = nums[0];
        for(int i = 1; i < N; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
        System.out.println(Arrays.toString(sum));
    }

    /**
     * 前缀和数组的范围查询
     *
     * @param left
     * @param right
     * @return
     */
    public int sumRange(int left, int right) {
        if (right >= sum.length) {
            return -1;
        }
        return left == 0 ? sum[right] : sum[right] - sum[left - 1];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        // 1
        System.out.println(numArray.sumRange(2, 5));
        // -1
        System.out.println(numArray.sumRange(0, 5));
        // -3
    }
}
