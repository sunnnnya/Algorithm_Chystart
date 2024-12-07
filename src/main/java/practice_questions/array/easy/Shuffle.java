package practice_questions.array.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.array.easy
 * @ClassName: Shuffle
 * @Author: 丛虹羽
 * @Date: 2024/12/7 下午12:06
 * @Description: 重新排列数组
 *
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 *
 * leetcode: https://leetcode.cn/problems/shuffle-the-array/?envType=study-plan-v2&envId=primers-list
 */
public class Shuffle {

    /**
     * 重新排列
     *
     * @param nums
     * @param n
     * @return
     */
    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[i + n];
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 1, 3, 4, 7};
        System.out.println("重新排列之后的数组：" + Arrays.toString(shuffle(arr, 3)));
        // 重新排列之后的数组：[2, 3, 5, 4, 1, 7]
    }
}