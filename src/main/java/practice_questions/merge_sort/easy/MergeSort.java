package practice_questions.merge_sort.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.merge_sort
 * @ClassName: MergeSort
 * @Author: 丛虹羽
 * @Date: 2024/8/13 下午7:57
 * @Description: 归并排序基础模板
 */
public class MergeSort {

    /**
     * 归并排序
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return ;
        }
        process(arr, 0, arr.length - 1);
    }

    /**
     * loop
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void process(int[] arr, int l, int r) {
        // base case
        if(l == r) {
            return ;
        }
        int mid = l + ((r - l) >> 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    /**
     * 进行数组的合并
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int L = l;
        int R = mid + 1;
        int index = 0;
        while (L <= mid && R <= r) {
            help[index++] = arr[L] <= arr[R] ? arr[L++] : arr[R++];
        }
        while (L <= mid) {
            help[index++] = arr[L++];
        }
        while (R <= r) {
            help[index++] = arr[R++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{10, 2, 1, 3, -1, 0, 9, 10, 21, 20, 3, 7};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        // [-1, 0, 1, 2, 3, 3, 7, 9, 10, 10, 20, 21]
    }
}
