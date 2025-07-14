package job_interview.hot100.ordinary_array;

/**
 * @BelongsPackage: job_interview.hot100.ordinary_array
 * @ClassName: FirstMissingPositive
 * @Author: 丛虹羽
 * @Date: 2025/7/14 13:35
 * @Description: 缺失的第一个正数 - 重点 - 技巧
 * https://leetcode.cn/problems/first-missing-positive/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class FirstMissingPositive {

    /**
     * "概念"双指针
     *      l 的左边都是做到 i 位置上放着 i + 1 数值的区域 ，永远盯着 l 位置的数看，看能不能扩充(l++)
     *      [r ...] 标识垃圾区域，最好的情况下任务 1 ~ r 是收集全的
     *  情况：
     *    if arr[l] == l + 1; l++
     *    else if arr[l] <= l; 当前我的左侧已经安排好了 l 的位置放着 l + 1，但此时出来一个 当前位置 <= l 说明一定是垃圾
     *            arr[l] > r; 我现在的预期是收集到 1 ~ r，但当前数值是 > r 的，所以一定是垃圾
     *            arr[arr[l] - 1] == arr[l]; 当不满足上面的时候，arr[l] 的值应该被分配到 arr[arr[l] - 1] 的位置，如果此时已经有一样的值了，说明当前值也是垃圾
     *    else 交换 l 和 nums[l] - 1 位置的值
     *
     * @param nums 原始数组
     * @return 缺失的第一个正数
     */
    public static int firstMissingPositive(int[] nums) {
        int l = 0, r = nums.length;
        while(l < r) {
            if(nums[l] == l + 1) {
                l++;
            } else if(nums[l] <= l || nums[l] > r || nums[nums[l] - 1] == nums[l]) {
                swap(nums, l, --r);
            } else {
                swap(nums, l, nums[l] - 1);
            }
        }
        return l + 1;
    }

    /**
     * 交换两个数
     *
     * @param arr 原始数组
     * @param i   i index
     * @param j   j index
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{7,8,9,11,12};
        System.out.println(firstMissingPositive(nums));
        // 1
    }
}
