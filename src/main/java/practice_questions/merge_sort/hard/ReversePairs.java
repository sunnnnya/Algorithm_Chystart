package practice_questions.merge_sort.hard;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.merge_sort.hard
 * @ClassName: ReversePairs
 * @Author: 丛虹羽
 * @Date: 2024/12/4 上午9:10
 * @Description: 交易逆序对的总数
 *
 * 在股票交易中，如果前一天的股价高于后一天的股价，则可以认为存在一个「交易逆序对」。
 * 请设计一个程序，输入一段时间内的股票交易记录 record，返回其中存在的「交易逆序对」总数。
 *
 * leetcode:https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 */
public class ReversePairs {

    /**
     * 查找逆序对的个数
     *
     * @param record
     * @return
     */
    public static int reversePairs(int[] record) {
        if (record == null || record.length < 2) {
            return 0;
        }
        return mergeSort(record, 0, record.length - 1);
    }

    /**
     * 归并排序的改写，需要抽象出来递归函数的返回值的结果到底要的是什么
     *
     * @param arr 原始数组
     * @param l   左边界
     * @param r
     * @return
     */
    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    /**
     * 进行数组的合并，同时找到小和问题
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     * @return
     */
    public static int merge(int[] arr, int l, int mid, int r) {
        int[] nums = new int[r - l + 1];
        int p1 = l, p2 = mid + 1, index = 0, sum = 0;
        while (p1 <= mid && p2 <= r) {
            sum += arr[p1] > arr[p2] ? (r - p2 + 1) : 0;
            nums[index++] = arr[p1] > arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            nums[index++] = arr[p1++];
        }
        while (p2 <= r) {
            nums[index++] = arr[p2++];
        }
        for (int i = 0; i < index; i++) {
            arr[l + i] = nums[i];
        }
        return sum;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] record = new int[]{9, 7, 5, 4, 6};
        System.out.println("数组：" + Arrays.toString(record) + " 的逆序对个数是：" + reversePairs(record));
        // 数组：[9, 7, 5, 4, 6] 的逆序对个数是：8

        int[] arr1 = new int[]{};
        System.out.println("数组：" + Arrays.toString(arr1) + " 的逆序对个数是：" + reversePairs(arr1));
        // 数组：[] 的逆序对个数是：0
    }
}