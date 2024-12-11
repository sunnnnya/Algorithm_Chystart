package practice_questions.binary_answer.medium.min;

/**
 * @BelongsPackage: practice_questions.binary_answer.medium
 * @ClassName: MinEatingSpeed
 * @Author: 丛虹羽
 * @Date: 2024/12/11 下午3:18
 * @Description: 爱吃香蕉的珂珂
 *
 * 分析：
 *      首先，有很多堆香蕉要被吃，并且猴子一次只能以固定的速度吃一堆香蕉，即使吃完了也不能吃别的堆，需要进行等待，
 *      （1）答案的最小值 -> 1  : 吃完所有香蕉需要整个数组的总和时间   -> 时间最大
 *      （2）答案的最大值 -> 数组最大值：吃完所有香蕉需要整个数组的堆数 -> 时间最小
 *
 *      对 [l, r] 进行二分，
 *          当答案进行 f() 计算的时候，如果需要的时间 > h, 说明答案小了, l = mid + 1
 *          当答案进行 f() 计算的时候，如果需要的时间 <= h, 说明答案大了，或者恰好, r = mid - 1，因为可能会更小的速度也满足 <= h 的要求！！
 *      f函数：计算选择一个答案的时候，需要多长时间吃完！
 *
 * leetcode: https://leetcode.cn/problems/koko-eating-bananas
 */
public class MinEatingSpeed {
    /**
     * 二分答案：
     *      (1) 确定答案的范围
     *      (2) 对要求解的答案进行二分
     *      (3) 使用约束进行二分，并记录答案
     *
     * @param piles 原始数组
     * @param h     离开的小时数
     * @return
     */
    public static int minEatingSpeed(int[] piles, int h) {
        // 最小且达标的范围[l,r]
        int l = 1;
        int r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        int ans = 0;
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if(f(piles, mid) <= h) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 枚举每个答案能获取到的 小时数
     *
     * @param nums 原始数组
     * @param mid  答案值
     * @return     当前答案对应的小时数
     */
    private static long f(int[] nums, int mid) {
        long ans = 0;
        for(int number : nums) {
            // (a/b)结果向上取整，如果a和b都是非负数，可以写成(a + b - 1) / b
            ans += ((number + mid - 1) / mid);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{3,6,7,11};
        System.out.println(minEatingSpeed(arr, 8));
        // 4

        int[] arr1 = new int[]{30,11,23,4,20};
        System.out.println(minEatingSpeed(arr1, 30));
        // 30

        int[] arr2 = new int[]{30,11,23,4,20};
        System.out.println(minEatingSpeed(arr2, 23));
        // 23
    }
}
