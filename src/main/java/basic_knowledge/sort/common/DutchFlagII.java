package basic_knowledge.sort.common;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.sort.common
 * @ClassName: DutchFlagII
 * @Author: 丛虹羽
 * @Date: 2024/7/30 下午9:43
 * @Description: 荷兰国旗问题
 *
 * 给定一个数组arr，和一个数num，
 *      请把小于num的数放在数组的左边，
 *      等于num的数放在数组的中间，
 *      大于num的数放在数组的右边。
 * 要求额外空间复杂度0(1)，时间复杂度0(N)
 */
public class DutchFlagII {

    /**
     * 荷兰过期加强版
     *
     * arr[i] < num, 把 arr[i]和 < 区域 的下一个数进行交换，然后 < 区域 往右扩
     * arr[i] == num i++，<= 区域不变
     * arr[i] > num 把 arr[i]和 >= 区域的前一个数进行交换，然后 i 不变，因为可能交换过来的数还是 < 或 > 的数
     *
     * @param arr
     * @param num
     */
    private static void dutchFlagPlus(int[] arr, int num) {
        if (arr == null || arr.length == 1) {
            return;
        }
        int L = 0;
        int R = arr.length - 1;
        int index = 0;
        // 相等的时候就已经终止了
        while (index <= R) {
            if (arr[index] < num) {
                swap(arr, L++, index++);
            } else if (arr[index] > num) {
                swap(arr, index, R--);
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
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 8, 6, 12, 5, 3, 8, 9, 14, 6, 6};
        dutchFlagPlus(arr, 8);
        System.out.println(Arrays.toString(arr));
        // [6, 5, 2, 6, 6, 5, 3, 8, 8, 14, 9, 12, 10]
    }
}
