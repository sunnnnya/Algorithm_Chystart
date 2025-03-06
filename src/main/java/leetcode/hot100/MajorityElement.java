package leetcode.hot100;

import java.util.*;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-06 19:48
 * @description: 多数元素
 *
 * leetcode: https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-100-liked
 **/
public class MajorityElement {

    /**
     * 数组排序 —— 中位数一定是所谓的众数
     *
     * @param nums 原始数组
     * @return
     */
    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    /**
     * 摩尔投票
     *
     * @param nums 原始数组
     * @return
     */
    public static int majorityElement(int[] nums) {
        int x = 0, vot = 0;
        for(int num : nums) {
            if (vot == 0) {
                x = num;
            }
            vot += (x == num) ? 1 : -1;
        }
        return x;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 3};
        System.out.println(majorityElement(arr));
        // 3

        int[] arr1 = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(arr1));
        // 2
    }
}
