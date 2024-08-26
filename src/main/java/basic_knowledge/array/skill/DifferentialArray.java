package basic_knowledge.array.skill;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.array.skill
 * @ClassName: DifferentialArray
 * @Author: 丛虹羽
 * @Date: 2024/8/26 下午6:31
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
     * @param arr
     * @param l
     * @param r
     * @param ops
     * @return
     */
    public static int[] differentialArray(int[] arr, int l, int r, int ops) {
        if (l > r) {
            return null;
        }
        if(l <= arr.length - 1) {
            arr[l] += ops;
        }
        if (r <= arr.length - 2) {
            arr[r + 1] -= ops;
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }
        return arr;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        // 现在想在 3 ~ 5 下标 +3
        System.out.println(Arrays.toString(differentialArray(arr, 3, 5, 3)));
        // [0, 0, 0, 3, 3, 3, 0, 0]

        int[] arr1 = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        // 现在想在 4 ~ 6 下标 -6
        System.out.println(Arrays.toString(differentialArray(arr1, 4, 6, -6)));
        // [0, 0, 0, 0, -6, -6, -6, 0]

        int[] arr2 = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        // 现在想在 3 ~ 7 下标 +5
        System.out.println(Arrays.toString(differentialArray(arr2, 3, 7, 5)));
        // [0, 0, 0, 5, 5, 5, 5, 5]
    }
}
