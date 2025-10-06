package job_interview.alg_basic_know.array.array_sort.base_sort;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.sort.base_sort
 * @ClassName: InsertSort
 * @Author: 丛虹羽
 * @Date: 2025/10/6 09:57
 * @Description: 插入排序
 */
public class InsertSort {

    /**
     * 插入排序
     *
     * @param arr 原始数组
     */
    public static void insertSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            for(int j = i; j >= 1 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
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
        int[] arr = new int[]{9, 2, 1, 2, 3, 4, 8, 10};
        System.out.println("before insert_sort: " + Arrays.toString(arr));
        // before insert_sort: [9, 2, 1, 2, 3, 4, 8, 10]
        insertSort(arr);
        System.out.println("after insert_sort: " + Arrays.toString(arr));
        // after insert_sort: [1, 2, 2, 3, 4, 8, 9, 10]
    }
}
