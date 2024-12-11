package practice_questions.binary_answer.medium.min;

/**
 * @BelongsPackage: practice_questions.binary_answer.medium
 * @ClassName: ShipWithinDays
 * @Author: 丛虹羽
 * @Date: 2024/12/11 下午4:10
 * @Description: 在 D 天内送达包裹的能力
 *
 * leetcode: https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days
 */
public class ShipWithinDays {

    /**
     * 二分答案：枚举要求的答案范围
     *      最小的运输能力是获取中的最大值，否则上面都装不下何谈运输！！！
     *      最大的运输能力是数组中的整数和，一次全部装上去运走！！
     *
     * @param weights
     * @param days
     * @return
     */
    public static int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;
        for (int number : weights) {
            l = Math.max(l, number);
            r += number;
        }
        int ans = 0;
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if(f(weights, mid) <= days) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 连续子数组和 <= sum 的个数
     *
     * @param weights 原始数组
     * @param target  目标值
     * @return
     */
    private static int f(int[] weights, int target) {
        int ans = 0;
        for(int i = 0, sum = 0; i < weights.length; i++){
            if(sum + weights[i] > target){
                ans++;
                sum = weights[i];
            }else{
                sum += weights[i];
            }
        }
        ans += 1;
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(arr, 5));
        // 15

        int[] arr1 = new int[]{3,2,2,4,1,4};
        System.out.println(shipWithinDays(arr1, 3));
        // 6

        int[] arr2 = new int[]{1,2,3,1,1};
        System.out.println(shipWithinDays(arr2, 4));
        // 3
    }
}
