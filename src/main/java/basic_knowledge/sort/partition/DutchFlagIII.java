package basic_knowledge.sort.partition;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.sort.common
 * @ClassName: DutchFlagIII
 * @Author: 丛虹羽
 * @Date: 2024/12/4 下午8:37
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
        if(arr == null || arr.length < 2) {
            return arr;
        }
        int N = arr[arr.length - 1];
        int index = 0, L = 0, R = arr.length - 1;
        while (index <= R) {
            if (arr[index] < N) {
                swap(arr, L++, index++);
            } else if (arr[index] > N) {
                swap(arr, index, R--);
            } else {
                index++;
            }
        }
        return new int[]{L, R};
    }

    /**
     * 交换指定位置的值
     *
     * @param arr    数组
     * @param i      数组的下标索引
     * @param j      数组的下标索引
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
        int[] arr = new int[]{10, 2, 3, 2, 1, 5, 5, 8, 10, 12, 5, 19, 0, 1, 2, 21, 23, 5};
        System.out.println("原数组：" + Arrays.toString(arr));
        System.out.println("partition：" + Arrays.toString(dutchFlagIII(arr)));
        System.out.println("分区之后的数组：" + Arrays.toString(arr));

        int[] arr1 = new int[]{6, 6, 6, 5};
        System.out.println("原数组：" + Arrays.toString(arr1));
        System.out.println("partition：" + Arrays.toString(dutchFlagIII(arr1)));
        System.out.println("分区之后的数组：" + Arrays.toString(arr1));
    }
}