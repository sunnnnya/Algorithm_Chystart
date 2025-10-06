package job_interview.alg_basic_know.array.array_sort.base_sort;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.sort
 * @ClassName: Bubble
 * @Author: 丛虹羽
 * @Date: 2025/10/6 09:23
 * @Description: 冒泡排序
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param arr 原始数组
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        int n = arr.length;
        for(int i = n - 1; i >= 1; i--) {
            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
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
    private static void swap(int[] arr, int i, int j) {
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
        int[] arr = new int[]{9, 4, 1, 2, 6, 5, -1, 0, 6, 8};
        System.out.println("before bubble_sort: " + Arrays.toString(arr));
        // before bubble_sort: [9, 4, 1, 2, 6, 5, -1, 0, 6, 8]
        bubbleSort(arr);
        System.out.println("after bubble_sort: " + Arrays.toString(arr));
        // after bubble_sort: [-1, 0, 1, 2, 4, 5, 6, 6, 8, 9]
    }
}
