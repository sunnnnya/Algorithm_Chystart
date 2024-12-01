package basic_knowledge.sort.base_sort;

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
     * 选择排序 - O(n^2)
     *
     * @param arr
     * @return
     */
   public static int[] selectionSort(int[] arr) {
       if (arr == null || arr.length == 1 || arr.length == 0) {
           return arr;
       }
       for (int i = 0; i < arr.length - 1; i++) {
           int minIndex = i;
           for (int j = i + 1; j < arr.length; j++) {
               minIndex = arr[j] < arr[minIndex] ? j : minIndex;
           }
           swap(arr, minIndex, i);
       }
       return arr;
   }

    /**
     * 交换数组中的两个索引位置的元素，
     * 可以考虑使用 异或 运算进行交换，但是可能会出现被消成 0 的情况
     *
     * @param arr
     * @param i
     * @param j
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
        int[] arr = {10, 9, 8, 11, 12, 21, 7};
        System.out.println(Arrays.toString(selectionSort(arr)));
        // [7, 8, 9, 10, 11, 12, 21]

        int[] arr1 = {-4, 9, 8, 11, -2, 21, 0};
        System.out.println(Arrays.toString(selectionSort(arr1)));
        // [-4, -2, 0, 8, 9, 11, 21]
    }
}