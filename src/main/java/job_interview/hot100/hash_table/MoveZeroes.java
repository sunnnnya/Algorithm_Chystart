package job_interview.hot100.hash_table;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.hot100.hash_table
 * @ClassName: MoveZeroes
 * @Author: 丛虹羽
 * @Date: 2025/7/13 08:17
 * @Description: 移动零
 * https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class MoveZeroes {

    /**
     * 双指针问题，一个维护 非0、一个维护 0 的
     *
     * @param nums 原始数组
     */
    public static void moveZeroes(int[] nums) {
        int zeroIdx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                swap(nums, i, zeroIdx++);
            }
        }
    }

    /**
     * 交换两个数
     *
     * @param arr 原始数组
     * @param i   i 下标索引
     * @param j   j 下标索引
     */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12};
        moveZeroes(arr);
        System.out.println("arr = " + Arrays.toString(arr));
        // arr = [1, 3, 12, 0, 0]
    }
}
