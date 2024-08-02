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
     */
    private static void dutchFlagPlus(int[] arr) {
        if (arr == null || arr.length == 1) {
            return ;
        }
        int N = arr[arr.length - 1];
        int L = -1;
        int R = arr.length - 1;
        int index = 0;
        // 当前索引的值需要小于等于 > N 的左边界
        while (index < R) {
            if (arr[index] < N) {
                // 小于等于的使用index右移
                swap(arr, ++L, index++);
            } else if (arr[index] > N) {
                // 大于等于的时候index不移动
                swap(arr, index, --R);
            } else {
                index++;
            }
        }
        swap(arr, R, arr.length - 1);
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
        dutchFlagPlus(arr);
        System.out.println(Arrays.toString(arr));
        // [5, 2, 3, 5, 6, 6, 6, 8, 9, 14, 8, 10, 12]
    }
}
