package sort;

import java.util.Arrays;

/**
 * @BelongsPackage: sort
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
     * 选择排序
     *
     * @param arr
     */
    public static void selectSortMethod(int[] arr) {
        if (arr == null || arr.length == 1) {
            return ;
        }
        for (int minIndex, i = 0; i < arr.length - 1; i++) {
            // 锁定第一个数，
            minIndex = i;
            // 从当前数后面找到最小的数，minIndex极记作索引
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 初始值和后面的值进行交换
            swap(arr, i, minIndex);
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr
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
     * @param arr
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
        int[] arr = new int[]{10, 2, 1, 2, 3, 16, 2, -1};
        // test_select_sort
        BaseSort.selectSortMethod(arr);
        System.out.println(Arrays.toString(arr));
        // [-1, 1, 2, 2, 2, 3, 10, 16]

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
