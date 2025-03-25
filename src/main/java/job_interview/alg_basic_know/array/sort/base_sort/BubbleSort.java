package job_interview.alg_basic_know.array.sort.base_sort;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.sort
 * @ClassName: Bubble
 * @Author: 丛虹羽
 * @Date: 2025/3/25 09:23
 * @Description: 冒泡排序
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param arr 原始数组
     */
    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for(int i = arr.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[j + 1]) { // 小 -> 大
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
        int[] arr = new int[]{9, 4, 1, 2, 6, 5, -1, 0, 6, 8};
        bubbleSort(arr);
        System.out.println("Result: " + Arrays.toString(arr));
        // Result: [-1, 0, 1, 2, 4, 5, 6, 6, 8, 9]
    }
}
