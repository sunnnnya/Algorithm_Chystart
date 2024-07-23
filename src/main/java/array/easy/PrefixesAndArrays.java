package array.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: array
 * @ClassName: PrefixArray
 * @Author: 丛虹羽
 * @Date: 2024/7/23 下午10:56
 * @Description: 前缀和数组基础操作
 */
public class PrefixesAndArrays {


    /**
     * 前缀和数组
     *
     * @param arr
     * @return
     */
    public static int[] prefixesAndArray(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int[] prefixArr = new int[arr.length];
        prefixArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixArr[i] = arr[i] + prefixArr[i - 1];
        }
        return prefixArr;
    }

    /**
     * 获取从 l 到 r位数的和
     * @param arr  前缀数组
     * @param l    数组中第l个元素 1 ~ N
     * @param r    数组中第r个元素 1 ~ N
     * @return
     */
    public static int getLToRSum(int[] arr, int l, int r) {
        if (arr == null || l > r) {
            return -1;
        }
        return l == 1 ? arr[r - 1] : arr[r - 1] - arr[l - 2];
    }

    /**
     * 获取从 l 到 r下标的和
     * @param arr  前缀数组
     * @param l    数组中下标 l个元素 1 ~ N
     * @param r    数组中下标 r个元素 1 ~ N
     * @return
     */
    public static int getLToRSumArrayIndex(int[] arr, int l, int r) {
        if (arr == null || l > r) {
            return -1;
        }
        return l == 0 ? arr[r] : arr[r] - arr[l - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 32, 3, 32, 5, 6, 7, 7, 12, 32};
        // 获取前缀和数组
        int[] ints = prefixesAndArray(arr);
        System.out.println(Arrays.toString(ints));
        // [1, 33, 36, 68, 73, 79, 86, 93, 105, 137]

        // 求取数组第L个元素到第R个元素之间的和
        System.out.println(getLToRSum(ints, 2, 5));
        // 72

        // 获取数组第L下标位置的元素到第R下标位置的元素的和
        System.out.println(getLToRSumArrayIndex(ints, 1, 4));
        // 72

        System.out.println(getLToRSum(ints, 5, 6));
        // 11

        System.out.println(getLToRSumArrayIndex(ints, 4, 7));
        // 25
    }
}
