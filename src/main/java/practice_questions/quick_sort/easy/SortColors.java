package practice_questions.quick_sort.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.quick_sort
 * @ClassName: SortColors
 * @Author: 丛虹羽
 * @Date: 2024/8/3 上午10:38
 * @Description: 颜色分类
 *
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，
 * 并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 * leetcode： https://leetcode.cn/problems/sort-colors/description/
 */
public class SortColors {

    /**
     * 荷兰国旗问题解决，但不返回 == N 的左右边界
     *
     * @param arr
     */
    public static void sortColors(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        int less = -1;
        int more = arr.length;
        int index =  0;
        while (index < more) {
            if (arr[index] < 1) {
                swap(arr, index++, ++less);
            } else if (arr[index] > 1) {
                swap(arr, index, --more);
            } else {
                index++;
            }
        }
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
     * 荷兰国旗问题
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
