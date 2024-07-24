package basic_knowledge.sort;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.sort
 * @ClassName: SelectSort
 * @Author: 丛虹羽
 * @Date: 2024/7/21 下午10:58
 * @Description: 选择排序
 */
public class BaseSort {

    /**
     * 交换数组中对应两个索引的数
     *
     * @param arr 数组
     * @param i 交换的索引下标
     * @param j 交换的索引下标
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 冒泡排序
     *
     * @param arr 待排序的数组
     */
    public static void bubbleSortMethod(int[] arr) {
        if (arr == null || arr.length == 1) {
            return ;
        }
        // 每次移动的次数都会减少
        for (int i = arr.length - 1; i > 0; i--) {
            // 丛初始位置进行交换
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arr 待排序的数组
     */
    public static void insertSortMethod(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        // 从第二张牌开始，到最后一张牌
        for (int i = 1; i < arr.length; i++) {
            // 往前进行交换插入， 从大到小进行排序
            for (int j = i; j >= 1 && arr[j - 1] < arr[j]; j--) {
                swap(arr, j - 1, j);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{9, 5, 2, 1, -1, 8, 9};
        // test_bubble_sort
        BaseSort.bubbleSortMethod(arr1);
        System.out.println(Arrays.toString(arr1));
        // [9, 9, 8, 5, 2, 1, -1]

        int[] arr2 = new int[]{-1, 8, 6, 7, 5, 10, 2, 1, -1};
        // test_insert_sort
        BaseSort.insertSortMethod(arr2);
        System.out.println(Arrays.toString(arr2));
        // [-1, -1, 1, 2, 5, 6, 7, 8, 10]
    }
}
