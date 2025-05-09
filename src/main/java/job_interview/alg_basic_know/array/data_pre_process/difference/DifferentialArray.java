package job_interview.alg_basic_know.array.data_pre_process.difference;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.array.skill
 * @ClassName: DifferentialArray
 * @Author: 丛虹羽
 * @Date: 2025/5/9 下午6:31
 * @Description: 差分数组
 */
public class DifferentialArray {

    /**
     * 差分数组的基本操作
     * 想在 l ~ r 的位置上 加 或 减 一个数 number
     * 差分的思想：
     *      arr[l] += number
     *      arr[r + 1] -= number
     * 最后的数组求前缀和就是操作之后的答案；
     *
     * @param nums 原始数组
     * @param l    l边界
     * @param r    r边界
     * @param v    值
     * @return void
     */
    static void diff(int[] nums, int l, int r, int v) {
        nums[l] += v;
        nums[r + 1] -= v;
    }

    /**
     * 构建前缀和数组
     *
     * @param arr 原始数组
     */
    static void preSum(int[] arr) {
        int n = arr.length;
        for(int i = 1; i < n - 1; i++) {
            arr[i] += arr[i - 1];
        }
    }

    /**
     * 扩充数组元素，免去最后一位数的条件判断
     *
     * @param nums 原始数组
     * @return int[]
     */
    static int[] changeArr(int[] nums) {
        int n = nums.length;
        return new int[n + 1];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        int[] extArr = changeArr(arr);
        System.out.println("extArr = " + Arrays.toString(extArr));
        // extArr = [0, 0, 0, 0, 0, 0, 0, 0, 0]

        diff(extArr, 3, 5, 3);
        diff(extArr, 1, 5, -1);
        diff(extArr, 0, 3, 5);

        preSum(extArr);
        System.out.println("extArr = " + Arrays.toString(extArr));
        // extArr = [5, 4, 4, 7, 2, 2, 0, 0, 0]
    }
}
