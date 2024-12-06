package practice_questions.array.easy;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @BelongsPackage: practice_questions.array.easy
 * @ClassName: Intersection
 * @Author: 丛虹羽
 * @Date: 2024/12/6 上午11:22
 * @Description: 给定两个数组 nums1 和 nums2 ，返回 它们的交集
 *
 * leetcode: https://leetcode.cn/problems/intersection-of-two-arrays
 */
public class Intersection {

    /**
     * 求两个数组的交集
     *
     * @param nums1 第一个数组
     * @param nums2 第二个数组
     * @return      返回交集数组
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];
        for(int number : nums1) {
            arr[number]++;
        }
        CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<>();
        for(int number : nums2) {
            if(arr[number] != 0) {
                set.add(number);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 2, 1};
        int[] arr2 = new int[]{2, 2};
        System.out.println(Arrays.toString(intersection(arr1, arr2)));
        // [2]

        int[] arr3 = new int[]{4, 9, 5};
        int[] arr4 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(arr3, arr4)));
        // [9, 4]
    }
}