package basic_knowledge.sort.base_sort;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.sort.base_sort
 * @ClassName: BubbleSort
 * @Author: 丛虹羽
 * @Date: 2024/7/24 下午11:10
 * @Description: 冒泡排序
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return arr;
        }
        // 指定走的趟数
        for (int i = arr.length - 1; i >= 1; i--) {
            // 第一次从 0 ~ n - 2
            // 第二次从 0 ~ n - 3
            //   最后从 0 ~ 1
            for (int j = 0; j < i; j++) {
                // 从大到小
                if (arr[j] < arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    /**
     * 交换数组中两个索引位置的元素
     *
     * @param arr
     * @param i
     * @param j
     * @return
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {19, 2, 4, 2, 1, -1, 88, 12, 29};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        // [88, 29, 19, 12, 4, 2, 2, 1, -1]
    }
}
