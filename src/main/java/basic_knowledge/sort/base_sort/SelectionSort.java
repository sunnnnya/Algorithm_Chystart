package basic_knowledge.sort.base_sort;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.sort.base_sort
 * @ClassName: SelectionSort
 * @Author: 丛虹羽
 * @Date: 2024/7/24 下午10:41
 * @Description: 选择排序 - 一定要清楚数组的边界是从 0 ~ N - 1，需要合理的运用这一点！！！
 */
public class SelectionSort {

    /**
     * 选择排序 - O(n^2)
     *
     * @param arr 原始数组排序
     * @return
     */
   public static int[] selectionSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return arr;
        }
        for(int i = 0, minIndex; i < arr.length - 1; i++) {
            minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
        return arr;
   }

    /**
     * 交换数组中的两个索引位置的元素，
     * 可以考虑使用 异或 运算进行交换，但是可能会出现被消成 0 的情况
     *
     * @param arr 待交换的数据
     * @param i   i 位置的 index
     * @param j   j 位置的 index
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
        System.out.println("排序前：" + Arrays.toString(arr));
        System.out.println("排序后：" + Arrays.toString(selectionSort(arr)));
        // 排序前：[10, 9, 8, 11, 12, 21, 7]
        // 排序后：[7, 8, 9, 10, 11, 12, 21]

        System.out.println();

        int[] arr1 = {-4, 9, 8, 11, -2, 21, 0};
        System.out.println("排序前：" + Arrays.toString(arr1));
        System.out.println("排序后：" + Arrays.toString(selectionSort(arr1)));
        // 排序前：[-4, 9, 8, 11, -2, 21, 0]
        // 排序后：[-4, -2, 0, 8, 9, 11, 21]

        System.out.println();

        int[] arr2 = new int[]{10, 2, 1, 0, -3};
        System.out.println("排序前：" + Arrays.toString(arr2));
        System.out.println("排序后：" + Arrays.toString(selectionSort(arr2)));
        // 排序前：[10, 2, 1, 0, -3]
        // 排序后：[-3, 0, 1, 2, 10]
    }
}