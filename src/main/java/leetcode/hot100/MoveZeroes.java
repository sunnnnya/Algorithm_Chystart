package leetcode.hot100;

import java.util.Arrays;

/**
 * @BelongsPackage: leetcode.hot100
 * @ClassName: MoveZeroes
 * @Author: 丛虹羽
 * @Date: 2025/3/3 21:21
 * @Description: 移动零
 *
 * leetcode: https://leetcode.cn/problems/move-zeroes/?envType=study-plan-v2&envId=top-100-liked
 */
public class MoveZeroes {

    /**
     * 双指针 * 保持相对次序
     *
     * @param nums 原始数组
     */
    public static void moveZeroes(int[] nums) {
        int j = 0;
        // 左填充
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        // 刷0
        while(j < nums.length) {
            nums[j++] = 0;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = {0, 1, 0, 3, 12};
        moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
        // [1, 3, 12, 0, 0]

        int[] nums2 = {0};
        moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2));
        // [0]
    }
}
