package basic_knowledge.sort.common;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.sort.common
 * @ClassName: DutchFlagIII
 * @Author: 丛虹羽
 * @Date: 2024/8/2 下午8:37
 * @Description: 荷兰国旗问题
 *
 * 对一个无序的数组，指定数组的最后一个值 N，把 <= N的值放在左边， == N的值放在中间， >= N的值放在右边
 * 然后返回 == N 的左右边界
 */
public class DutchFlagIII {

    /**
     * 荷兰国旗问题
     *
     * @param arr 带排序的数组
     * @return
     */
    public static int[] dutchFlagIII(int[] arr) {
        if(arr == null || arr.length == 1) {
            return arr;
        }
        int N = arr[arr.length - 1];
        int index = 0;
        int L = -1;
        int R = arr.length - 1;
        while (index < R) {
            if (arr[index] < N) {
                swap(arr, ++L, index++);
            } else if (arr[index] > N) {
                swap(arr, index, --R);
            } else {
                index++;
            }
        }
        // 交换最后一个值和从左往右数第一个 >N 的值
        swap(arr, arr.length - 1, R);
        return new int[]{L + 1, R};
    }

    /**
     * 交换指定位置的值
     *
     * @param arr    数组
     * @param i      数组的下标索引
     * @param j      数组的下标索引
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] - arr[j];
        arr[j] = arr[i] + arr[j];
        arr[i] = arr[j] - arr[i];
    }
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{10, 2, 3, 2, 1, 5, 5, 8, 10, 12, 5, 19, 0, 1, 2, 21, 23, 5};
        System.out.print("partitation数组：");
        System.out.println(Arrays.toString(dutchFlagIII(arr)));
        // partitation数组：[7, 10]

        System.out.print("分割之后的arr数组：");
        System.out.println(Arrays.toString(arr));
        // 分割之后的arr数组：[0, 0, 0, 0, 0, 1, 0, 5, 5, 5, 5, 12, 10, 8, 21, 23, 10, 19]
    }
}
