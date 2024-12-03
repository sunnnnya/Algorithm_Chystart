package practice_questions.hash_table.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @BelongsPackage: practice_questions.hash_table.easy
 * @ClassName: TwoSum
 * @Author: 丛虹羽
 * @Date: 2024/12/2 上午11:07
 * @Description: 两数之和
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 *
 * leetcode: https://leetcode.cn/problems/two-sum
 * leetcode: https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted
 * leetcode: https://leetcode.cn/problems/kLl5u1
 */
public class TwoSum {

    /**
     * 使用 hash 表返回两数之和，Hash 的 value 记录的是索引值
     *
     * @param numbers 数组
     * @param target 目标值
     * @return       可以组成目标函数的索引数组
     */
    public static int[] twoSum1(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i};
            }
            map.put(numbers[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * 不使用 HashTable 的形式进行返回，前提是数组需要是有序的
     *
     * @param numbers 目标数组
     * @param target  目标值
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while(l < r) {
            int number = numbers[l] + numbers[r];
            if (number > target) {
                r--;
            } else if(number < target) {
                l++;
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
        int[] arr = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));
        // [0, 1]

        int[] arr1 = new int[]{2, 4, 5, 8};
        System.out.println(Arrays.toString(twoSum(arr1, 11)));
        // [-1, -1]
    }
}