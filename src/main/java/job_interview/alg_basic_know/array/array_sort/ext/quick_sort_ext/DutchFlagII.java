package job_interview.alg_basic_know.array.array_sort.ext.quick_sort_ext;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.sort.common
 * @ClassName: DutchFlagII
 * @Author: 丛虹羽
 * @Date: 2024/12/4 下午9:43
 * @Description: 荷兰国旗问题
 *
 * 给定一个数组 arr，和一个数 num，<= num 的数放在数组的左边，== num 的数放在数组的中间，> num 的数放在数组的右边。
 * 要求额外空间复杂度 O(1)，时间复杂度 O(N)
 */
public class DutchFlagII {

    /**
     * 荷兰过期加强版
     *
     * arr[i] < num, 把 arr[i]和 < 区域 的下一个数进行交换，然后 < 区域 往右扩
     * arr[i] == num i++，<= 区域不变
     * arr[i] > num 把 arr[i]和 >= 区域的前一个数进行交换，然后 i 不变，因为可能交换过来的数不确定和 num 的大小关系
     *
     * @param arr
     */
    private static void dutchFlagPlus(int[] arr) {
        if(arr == null || arr.length < 2) {
            return ;
        }
        int less = 0, more = arr.length - 1, index = 0, target = arr[arr.length - 1];
        while(index <= more) {
            if(arr[index] < target) {
                swap(arr, index++, less++);
            } else if(arr[index] > target) {
                swap(arr, index, more--);
            } else {
                index++;
            }
        }
    }

    /**
     * 交换两个数
     *
     * @param arr 原始数组
     * @param i   指定索引
     * @param j   指定索引
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
        System.out.println("原数组：" + Arrays.toString(arr));
        // 原数组：[10, 5, 2, 8, 6, 12, 5, 3, 8, 9, 14, 6, 6]
        dutchFlagPlus(arr);
        System.out.println("荷兰国旗后的数组：" + Arrays.toString(arr));
        // 荷兰国旗后的数组：[5, 2, 3, 5, 6, 6, 6, 8, 9, 14, 12, 8, 10]
    }
}