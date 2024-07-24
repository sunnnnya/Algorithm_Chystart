package basic_knowledge.sort.base_sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.sort.base_sort
 * @ClassName: SelectionSort
 * @Author: 丛虹羽
 * @Date: 2024/7/24 下午10:41
 * @Description: 选择排序
 */
public class SelectionSort {

    /**
     * 选择排序
     *
     * @param arr
     * @return
     */
    public static int[] selectionSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 从小到大
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
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
        int[] arr = {10, 9, 8, 11, 12, 21, 7};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
        // [7, 8, 9, 10, 11, 12, 21]
    }
}
