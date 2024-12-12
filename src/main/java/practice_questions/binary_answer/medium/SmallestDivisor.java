package practice_questions.binary_answer.medium;

/**
 * @BelongsPackage: practice_questions.binary_answer.medium
 * @ClassName: SmallestDivisor
 * @Author: 丛虹羽
 * @Date: 2024/12/12 上午11:41
 * @Description: 使结果不超过阈值的最小除数
 *
 * leetcode：https://leetcode.cn/problems/find-the-smallest-divisor-given-a-threshold
 */
public class SmallestDivisor {

    /**
     * 需要注意数据的范围，枚举答案的边界可能会爆 int
     *
     * @param nums      原始数组
     * @param threshold 题目要求的限制
     * @return
     */
    public static int smallestDivisor(int[] nums, int threshold) {
        long l = 1;
        long r = 0;
        for(int number : nums) {
            r += number;
        }
        long ans = 0;
        while(l <= r) {
            long mid = l + ((r - l) >> 1);
            // 合理分析，单调性，当前的值 <= k 说明 mid 还是很大，适当减少答案 mid ，f() 返回值会增加
            if(f(nums, mid) <= threshold) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)ans;
    }

    /**
     * 小技巧： a / b <=> (a + b - 1) / b
     *
     * @param nums  原始数组
     * @param limit 被除数
     * @return      返回数组中每个元素 / limit 之后的和
     */
    private static int f(int[] nums, long limit) {
        int ans = 0;
        for(int number : nums) {
            ans += (int) ((number + limit - 1) / limit);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,5,9};
        System.out.println(smallestDivisor(arr, 6));
        // 5

        int[] arr1 = new int[]{2,3,5,7,11};
        System.out.println(smallestDivisor(arr1, 11));
        // 3

        int[] arr2 = new int[]{19};
        System.out.println(smallestDivisor(arr2, 5));
        // 4
    }
}