package basic_knowledge.sort.advanced_sort;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.sort.advanced_sort
 * @ClassName: QuickSort
 * @Author: 丛虹羽
 * @Date: 2024/7/30 下午10:38
 * @Description: 快速排序
 *
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    // arr[l...r]排好序
    public static void quickSort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(arr, L + (int)(Math.random( ) * (R - L + 1)), R);
        int[] p = partition(arr, L, R); // 荷兰国旗问题
        // p[0] 等于区域的第一个数
        // p[1] 等于区域的最后一个数
        quickSort(arr, L,p[0] - 1);  // < 区
        quickSort(arr, p[1] + 1, R); // > 区
    }

    // 这是一个处理arr[l..r]的函数
    // 默认以arr[R]做划分值，arr[R] -> p    <p    ==p    >p
    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;                   // < 区右边界
        int more = R;                       // > 区左边界
        while (L < more) {                  // L 表示当前数的位置 arr[R] -> 划分值
            if (arr[L] < arr[R]) {          // 当前数 < 划分值
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {   // 当前数 > 划分值
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        // 小于区域的下一个位置 <=> 等于区域的第一个位置
        // 大于区域的位置 <=> 等于 arr[R] 的第一个位置，最后和 arr[R] 的位置交换了
        return new int[]{less + 1, more};
    }

    /**
     * 交换两个数
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
        int[] arr = {10, 8, 2, 12, 11, 10, 8, 2, 5, 6};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
        // [2, 2, 5, 6, 8, 8, 10, 10, 11, 12]
    }
}
