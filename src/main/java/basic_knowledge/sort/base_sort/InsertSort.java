package basic_knowledge.sort.base_sort;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.sort
 * @ClassName: SelectSort
 * @Author: 丛虹羽
 * @Date: 2024/7/21 下午10:58
 * @Description: 插入排序
 */
public class InsertSort {

    /**
     * 插入排序
     *
     * @param arr 待排序的数组
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 从第二张牌开始，到最后一张牌
        for (int i = 1; i < arr.length; i++) {
            // 往前进行交换插入，第二牌进行比较停止，从大到小进行排序
            for (int j = i; j >= 1 && arr[j - 1] < arr[j]; j--) {
                swap(arr, j - 1, j);
            }
        }
    }

    /**
     * 交换数组中对应两个索引的数
     *
     * @param arr 数组
     * @param i   交换的索引下标
     * @param j   交换的索引下标
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
        int[] arr1 = new int[]{-1, 8, 6, 7, 5, 10, 2, 1, -1};
        insertSort(arr1);
        System.out.println(Arrays.toString(arr1));
        // [10, 8, 7, 6, 5, 2, 1, -1, -1]

        int[] arr2 = new int[]{5, -2, 3, 1, 0, 10, 2, 91, 11};
        insertSort(arr2);
        System.out.println(Arrays.toString(arr2));
        // [91, 11, 10, 5, 3, 2, 1, 0, -2]
    }
}
