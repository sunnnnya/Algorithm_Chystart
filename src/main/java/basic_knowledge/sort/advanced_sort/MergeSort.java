package basic_knowledge.sort.advanced_sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.sort.advanced_sort
 * @ClassName: MerageSort
 * @Author: 丛虹羽
 * @Date: 2024/7/30 下午1:47
 * @Description: 归并排序
 *
 * master公式：分析 等规模子问题 递归函数的时间复杂度的
 * T(N) = a * (N / b) + O(N ^ d)
 * log(b^a) < d = O(N^d)
 * log(b^a) > d = O(N^log(b^a))
 * log(b^a) = d = O(N^d * log N)
 *
 * T(N) = 2 * (N / 2) + O(N ^ 1)
 * a = 2、b = 2、d = 1
 * log(2^2) = 1 == d -> O(N * logN) 下面递归的时间复杂度分析
 *
 */
public class MergeSort {

    /**
     * 归并排序
     *
     * @param arr
     * @return
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    /**
     * 逐渐的排序过程
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    /**
     * 合并数组的过程
     *
     * @param arr 数组
     * @param L   左边界
     * @param M   中间边界
     * @param R   右边界
     */
    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        // 都不越界
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // p1 没越界
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        // p2 没越界
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        // help数组拷贝到原数组
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {10, 2, 4, 2, 1, 6, 10, 22, 89, 100, 121, 2, 3, 8};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        // [1, 2, 2, 2, 3, 4, 6, 8, 10, 10, 22, 89, 100, 121]
    }
}
