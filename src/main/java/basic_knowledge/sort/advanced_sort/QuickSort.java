package basic_knowledge.sort.advanced_sort;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.sort.advanced_sort
 * @ClassName: QuickSort
 * @Author: 丛虹羽
 * @Date: 2024/12/6 下午10:21
 * @Description: 快速排序 - 空间复杂度O(logN) - 时间复杂度O（N * logN）
 *      快速排序使用的前置知识：荷兰国旗问题
 */
public class QuickSort {

    /**
     * 快速排序
     *
     * @param arr 原始数据
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序 partition 过程
     * @param arr 原始数组
     * @param L   左边界
     * @param R   右边界
     */
   public static void quickSort(int[] arr, int L, int R) {
       // L = 0、R = -1的时候，表示最左的值，直接不需要 partition
        if (L >= R) {
            return;
        }
        // 随机快排，随机选择一个数
        swap(arr, L + (int)(Math.random( ) * (R - L + 1)), R);
        int[] p = partition(arr, L, R); // 荷兰国旗问题
        // p[0] 等于区域的第一个数
        // p[1] 等于区域的最后一个数
        quickSort(arr, L,p[0] - 1);  // < 区
        quickSort(arr, p[1] + 1, R); // > 区
    }

    /**
     * 这是一个处理arr[l..r]的函数
     * 默认以arr[R]做划分值，arr[R] -> p    <p    ==p    >p
     *
     * @param arr 原始数组
     * @param L   左边界
     * @param R   右边界
     * @return    返回分区之后 == 的左右边界
     */
    public static int[] partition(int[] arr, int L, int R) {
        int less = L;
        int more = R;
        int index = L;
        int target = arr[R];
        while(index <= more) {
            if(arr[index] < target) {
                swap(arr, index++, less++);
            } else if (arr[index] > target) {
                swap(arr, index, more--);
            } else {
                index++;
            }
        }
        return new int[]{less, more};
    }

    /**
     * 交换两个数
     *
     * @param arr 原始数组
     * @param i   i 索引下标
     * @param j   j 索引下标
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
        int[] arr = {10, 8, 2, 12, 11, 10, 8, 2, 5, 6};
        System.out.println("原始数组：" + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("排序后的数组：" + Arrays.toString(arr));

        int[] arr1 = {10, 3, 2, 1, 50, 12, 32, 24};
        System.out.println("原始数组：" + Arrays.toString(arr1));
        quickSort(arr1);
        System.out.println("排序后的数组：" + Arrays.toString(arr1));
    }
}