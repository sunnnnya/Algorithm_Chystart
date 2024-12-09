package practice_questions.slide_window.medium.fixed_length;

/**
 * @BelongsPackage: practice_questions.slide_window.medium
 * @ClassName: NumOfSubarrays
 * @Author: 丛虹羽
 * @Date: 2024/12/7 下午8:49
 * @Description: 大小为 K 且平均值大于等于阈值的子数组数目
 *
 * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
 *      请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
 *
 * leetcode： https://leetcode.cn/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold
 */
public class NumOfSubArrays {

    /**
     * 定长滑动窗口的题
     *
     * @param arr 原始数组
     * @param k 窗口的宽度
     * @param threshold 要求平均值大于该值
     * @return
     */
    public static int numOfSubArrays(int[] arr, int k, int threshold) {
        int sum = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(i < k - 1) {
                continue;
            }
            if((sum / k) >= threshold) {
                count++;
            }
            sum -= arr[i - k + 1];
        }
        return count;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 2, 2, 2, 5, 5, 5, 8};
        System.out.println("满足条件的子数组的个数是：" + numOfSubArrays(arr1, 3, 4));

        int[] arr2 = new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
        System.out.println("满足条件的子数组的个数是：" + numOfSubArrays(arr2, 3, 5));
    }
}