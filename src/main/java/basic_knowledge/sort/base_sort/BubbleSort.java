package basic_knowledge.sort.base_sort;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.sort.base_sort
 * @ClassName: BubbleSort
 * @Author: 丛虹羽
 * @Date: 2024/12/1 下午11:10
 * @Description: 冒泡排序
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param arr 待排序的数组
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return arr;
        }
        for(int i = arr.length - 1; i >= 1; i--) {
            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    /**
     * 交换数组中两个索引位置的元素
     *
     * @param arr 待交换的数组
     * @param i   i 位置的 index
     * @param j   j 位置的 index
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 使用异或的方式实现数组索引下标的交换
     * 0 ^ N = N
     * N ^ N = 0
     *
     * @param arr 原始数组
     * @param i   i index
     * @param j   j index
     */
    public static void swapWithXor(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {19, 2, 4, 2, 1, -1, 88, 12, 29};
        System.out.println("排序前：" + Arrays.toString(arr));
        System.out.println("排序后：" + Arrays.toString(bubbleSort(arr)));
        // 排序前：[19, 2, 4, 2, 1, -1, 88, 12, 29]
        // 排序后：[-1, 1, 2, 2, 4, 12, 19, 29, 88]

        int[] arr1 = new int[]{1, 2, 4, 4, 6, 7, 8};
        swapWithXor(arr1, 2, 6);
        System.out.println(Arrays.toString(arr1));
        // [1, 2, 8, 4, 6, 7, 4]

        swapWithXor(arr1, 2, 2);
        System.out.println(Arrays.toString(arr1));
        // [1, 2, 0, 4, 6, 7, 4]
    }
}