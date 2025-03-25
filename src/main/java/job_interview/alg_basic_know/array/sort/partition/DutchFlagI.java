package job_interview.alg_basic_know.array.sort.partition;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.sort.common
 * @ClassName: DutchFlagI
 * @Author: 丛虹羽
 * @Date: 2024/12/4 下午9:18
 * @Description: 基础荷兰国旗问题 I
 *
 * 给定一个数组 arr，和一个数 num，
 *      <= num 的数放在数组的左边，
 *      > num  的数放在数组的右边。
 * 要求额外空间复杂度0(1)，时间复杂度O(N)
 */
public class DutchFlagI {

    /**
     * arr[i] <= num, 把 arr[i]和 <=区域 的下一个数进行交换，然后 <= 区域 往右扩
     * arr[i] > num i++，<= 区域不变
     *
     * @param arr 原始数组
     * @param num 划分的值
     * @return
     */
    public static void dutchFlag(int[] arr, int num) {
        if(arr == null || arr.length < 2) {
            return;
        }
        int index = 0, L = 0;
        while(index < arr.length) {
            if(arr[index] <= num) {
                swap(arr, index++, L++);
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
        int[] arr = {4, 5, 3, 2, 5, 6, 5, 3, 2, 1, 2};
        System.out.println("原始数组：" + Arrays.toString(arr));
        dutchFlag(arr, 2);
        System.out.println("荷兰国旗后的数组：" + Arrays.toString(arr));
        // 原始数组：[4, 5, 3, 2, 5, 6, 5, 3, 2, 1, 2]
        // 荷兰国旗后的数组：[2, 2, 1, 2, 5, 6, 5, 3, 5, 3, 4]
    }
}