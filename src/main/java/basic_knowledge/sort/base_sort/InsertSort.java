package basic_knowledge.sort.base_sort;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.sort
 * @ClassName: SelectSort
 * @Author: 丛虹羽
 * @Date: 2024/7/21 下午10:58
 * @Description: 插入排序 —— 可以加强对 for 循环的使用
 */
public class InsertSort {

    /**
     * 插入排序
     *
     * @param arr 待排序的数组
     */
    public static void insertSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j >= 1 && arr[j - 1] > arr[j]; j--) {
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
        System.out.println("排序后的数组：" + Arrays.toString(arr1));
        // 排序后的数组：[-1, -1, 1, 2, 5, 6, 7, 8, 10]

        int[] arr2 = new int[]{5, -2, 3, 1, 0, 10, 2, 91, 11};
        insertSort(arr2);
        System.out.println("排序后的数组：" + Arrays.toString(arr2));
        // 排序后的数组：[-2, 0, 1, 2, 3, 5, 10, 11, 91]
    }
}
