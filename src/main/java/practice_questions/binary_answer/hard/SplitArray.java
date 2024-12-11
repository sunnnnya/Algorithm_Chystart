package practice_questions.binary_answer.hard;

/**
 * @BelongsPackage: practice_questions.binary_answer.hard
 * @ClassName: SplitArray
 * @Author: 丛虹羽
 * @Date: 2024/12/11 下午10:07
 * @Description: 分割数组的最大值
 *
 * 给定一个非负整数数组 nums 和一个整数 k ，你需要将这个数组分成 k 个非空的连续子数组，使得这 k 个子数组各自和的最大值 最小。
 * 返回分割后最小的和的最大值。
 *
 * leetcode： https://leetcode.cn/problems/split-array-largest-sum
 */
public class SplitArray {

    /**
     * 使用二分答案获取数组中可分割的最大子数组值 -> 最小，要的是最小的值
     *
     * @param nums
     * @param k
     * @return
     */
    public static int splitArray(int[] nums, int k) {
        long l = 0;
        long r = 0;
        for (int number : nums) {
            r += number;
        }
        long ans = 0;
        while(l <= r) {
            long mid = l + ((r - l) >> 1);
            // <= 理解：
            //  （1）当返回值 <= k 时，有可能当前值 < k ，但题目中要求 == k，所以需要通过单调性，通过 减少 答案 来增加 k
            //  （2）但返回值已经 == k，说明找到了，可以满足的答案了，但是此时的答案并不一定是最小的，所以继续 r = mid - 1;
            if(f(nums, mid) <= k) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)ans;
    }

    /**
     * 让数组的每一部分累加和 <= target 时，划分成及部分够用
     *
     * @param nums
     * @param limit
     * @return
     */
    private static int f(int[] nums, long limit) {
        int ans = 1;
        for(int i = 0, sum = 0; i < nums.length; i++) {
            if (nums[i] > limit) {
                return Integer.MAX_VALUE;
            }
            if (sum + nums[i] > limit) {
                ans++;
                // 最小值直接更新成进入会超过 target 的值
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{7,2,5,10,8};
        System.out.println(splitArray(arr, 2));
        //

        int[] arr1 = new int[]{1,2,3,4,5};
        System.out.println(splitArray(arr1, 2));
        //

        int[] arr2 = new int[]{1,4,4};
        System.out.println(splitArray(arr2, 3));
        //
    }
}