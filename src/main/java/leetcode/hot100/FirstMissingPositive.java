package leetcode.hot100;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-08 16:31
 * @description: 缺失的第一个正数 *
 *
 * leetcode: https://leetcode.cn/problems/first-missing-positive/description/?envType=study-plan-v2&envId=top-100-liked
 **/
public class FirstMissingPositive {

    /**
     * "概念"双指针
     *      l 的左边都是做到 i 位置上放着 i + 1 的区域，永远盯着 l 位置的数看，看能不能扩充(l++)
     *      [r ...] 标识垃圾区域，最好的情况下任务 1 ~ r 是收集全的
     *  情况：
     *    arr[l] == l + 1; l++
     *    arr[l] <= l; 垃圾
     *    arr[l] >  l; 垃圾
     *    arr[arr[l] - 1] == arr[l]; 垃圾
     *    交换
     *
     * @param nums 原始数组
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        int l = 0;
        int r = nums.length;
        while(l < r) {
            if(nums[l] == l + 1) {
                l++;
            } else if(nums[l] <= l || nums[l] > r || nums[nums[l] - 1] == nums[l]) {
                swap(nums, l, --r);
            } else{
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
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 0};
        System.out.println(firstMissingPositive(arr));
        // 3
    }
}
