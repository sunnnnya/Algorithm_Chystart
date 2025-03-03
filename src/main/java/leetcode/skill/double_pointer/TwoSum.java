package leetcode.skill.double_pointer;

import java.util.Arrays;

/**
 * @BelongsPackage: leetcode.skill.double_pointer
 * @ClassName: TwoSum
 * @Author: 丛虹羽
 * @Date: 2025/3/3 21:56
 * @Description: 两数之和 II - 输入有序数组
 *
 * leetcode: https://leetcode.cn/problems/kLl5u1/description/
 */
public class TwoSum {

    /**
     * 双指针 —— 利用数组有序性
     *
     * @param numbers 原始数组
     * @param target  目标值
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while(l < r) {
            if (numbers[l] + numbers[r] < target) {
                l++;
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                return new int[]{l, r};
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,6,10};
        System.out.println(Arrays.toString(twoSum(arr, 8)));
        // [1, 3]

        int[] arr1 = new int[]{2,3,4};
        System.out.println(Arrays.toString(twoSum(arr1, 6)));
        // [0, 2]

        int[] arr2 = new int[]{-1,0};
        System.out.println(Arrays.toString(twoSum(arr2, -1)));
        // [0, 1]
    }
}
