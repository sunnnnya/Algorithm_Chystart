package basic_knowledge.sort.common;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.sort.common
 * @ClassName: DutchFlagI
 * @Author: 丛虹羽
 * @Date: 2024/7/30 下午9:18
 * @Description: 荷兰国旗问题
 *
 * 给定一个数组arr，和一个数num，
 *      请把小于等于num的数放在数组的左边，
 *      大于num的数放在数组的右边。
 * 要求额外空间复杂度0(1)，时间复杂度O(N)
 *
 */
public class DutchFlagI {

    /**
     * arr[i] <= num, 把 arr[i]和 <=区域 的下一个数进行交换，然后 <= 区域 往右扩
     * arr[i] > num i++，<= 区域不变
     *
     * @param arr
     * @param num
     * @return
     */
    public static void dutchFlag(int[] arr, int num) {
        if (arr == null) {
            return ;
        }
        if (arr.length == 1) {
            return ;
        }
        int L = 0; // 左边界
        int index = 0;
        while (index <= arr.length - 1) {
            if (arr[index] <= num) {
                swap(arr, L++, index++);
            } else {
                index++;
            }
        }
    }

    /**
     * swap two number
     *
     * @param arr array
     * @param i   array index
     * @param j   array index
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
        int[] arr = {10, 5, 2, 5, 6, 12, 5, 3, 7, 9, 10};
        dutchFlag(arr, 9);
        System.out.println(Arrays.toString(arr));
        // [5, 2, 5, 6, 5, 3, 7, 9, 10, 12, 10]

        int[] arr1 = {3, 5, 5, 2};
        dutchFlag(arr1, 4);
        System.out.println(Arrays.toString(arr1));
        // [3, 2, 5, 5]
    }
}
