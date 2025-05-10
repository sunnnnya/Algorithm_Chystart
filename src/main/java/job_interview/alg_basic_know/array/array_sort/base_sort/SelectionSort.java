package job_interview.alg_basic_know.array.array_sort.base_sort;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.sort
 * @ClassName: SelectionSort
 * @Author: 丛虹羽
 * @Date: 2025/5/10 09:12
 * @Description: 选择排序
 */
public class SelectionSort {

    /**
     * 选择排序
     *
     * @param arr 原始数组
     */
    public static void selectionSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return ;
        }
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for(int j = i + 1; j < n; j++) {
                minIdx = arr[j] < arr[minIdx] ? j : minIdx;
            }
            swap(arr, i, minIdx);
        }
    }

    /**
     * 交换两个数
     *
     * @param arr 原始数组
     * @param i   i index
     * @param j   j index
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{9, 2, 1, 3, 2, 7, -1, 0};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
        // [-1, 0, 1, 2, 2, 3, 7, 9]
    }
}
