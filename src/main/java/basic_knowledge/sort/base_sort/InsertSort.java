package basic_knowledge.sort.base_sort;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.sort
 * @ClassName: SelectSort
 * @Author: 丛虹羽
 * @Date: 2024/7/21 下午10:58
 * @Description: 选择排序
 */
public class InsertSort {

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
     * 插入排序
     *
     * @param arr 待排序的数组
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        // 从第二张牌开始，到最后一张牌
        for (int i = 1; i < arr.length; i++) {
            // 往前进行交换插入，第二牌进行比较停止， 从大到小进行排序
            for (int j = i; j >= 1 && arr[j - 1] < arr[j]; j--) {
                swap(arr, j - 1, j);
            }
        }
    }

    public static void main(String[] args) {

        int[] arr2 = new int[]{-1, 8, 6, 7, 5, 10, 2, 1, -1};
        // test_insert_sort
        InsertSort.insertSort(arr2);
        System.out.println(Arrays.toString(arr2));
        // [-1, -1, 1, 2, 5, 6, 7, 8, 10]
    }
}
