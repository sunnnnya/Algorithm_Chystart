package job_interview.hot100.skill;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.hot100.skill
 * @ClassName: SortColors
 * @Author: 丛虹羽
 * @Date: 2025/7/13 09:45
 * @Description: 颜色分类
 * https://leetcode.cn/problems/sort-colors/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class SortColors {

    /**
     * 荷兰国旗：随机快排也使用这个思想
     *
     * @param nums 原始数组
     */
    public static void sortColors(int[] nums) {
        int index = 0, less = 0, more = nums.length - 1, target = 1;
        while(index <= more) {
            if(nums[index] < target) {
                swap(nums, index++, less++);
            } else if(nums[index] > target) {
                swap(nums, index, more--);
            } else {
                index++;
            }
        }
    }

    /**
     * 交换两个数
     *
     * @param nums 原始数组
     * @param i   i 下标索引
     * @param j   j 下标索引
     */
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
        // [0, 0, 1, 1, 2, 2]
    }
}
