package practice_questions.quick_sort;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.quick_sort
 * @ClassName: GetKthNumber
 * @Author: 丛虹羽
 * @Date: 2024/8/2 下午9:16
 * @Description: 无序数组中求第k小的数
 *
 * 通过改写快排实现 -> 通过判断 == N 的左右边界进行判断是不是满足，只会走一个分支
 *
 */
public class GetKthNumber {

    /**
     * 找到数组中的第k小的数
     *
     * @param arr    数组
     * @param L      左边界
     * @param R      右边界
     * @param index  表示需要找到k小的数
     */
    public static int process(int[] arr, int L, int R, int index) {
        if(L == R) {
            return arr[L];
        }
        int randomNumber = arr[L + (int)(Math.random() * (R - L + 1))];
        int[] p = partitation(arr, L, R, randomNumber);
        if (index >= p[0] && index <= p[1]) {
            return arr[index];
        } else if (index < p[0]) {
            return process(arr, L, p[0] - 1, index);
        } else {
            return process(arr, p[1] + 1, R, index);
        }
    }

    /**
     * 分割数组
     *
     * @param arr  待分割的数组
     * @param L    左边界
     * @param R    右边界
     * @param N    需要按照当前的值进行排序
     * @return    == N的左边界和右边界数组
     */
    public static int[] partitation(int[] arr, int L, int R, int N) {
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (arr[index] < N) {
                swap(arr, ++less, index++);
            } else if (arr[index] > N) {
                swap(arr, index, more--);
            } else {
                index++;
            }
        }
        return new int[]{less + 1, more - 1};
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
        System.out.println("===============测试partitation函数===============");
        int[] arr1 = new int[]{10, 2, 3, 1, 1, 4, 1, 2, 5, 7, 2, 10, 9, 12};
        int[] partitation = partitation(arr1, 0, arr1.length - 1, 10);
        System.out.print("原始数组：");
        System.out.println(Arrays.toString(arr1));
        //  [2, 3, 1, 1, 4, 1, 2, 5, 7, 2, 9, 10, 10, 12]
        System.out.println("分割之后的数组：");
        System.out.println(Arrays.toString(partitation));

        System.out.println("=================测试第k小的数===================");
        int[] arr = new int[]{10, 2, 3, 1, 1, 4, 1, 2, 5, 7, 2, 10, 9, 12};
        int k = 14;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        // [1, 1, 1, 2, 2, 2, 3, 4, 5, 7, 9, 10, 10, 12]
        System.out.println(arr[k - 1]);
        // 2

        System.out.println("===============测试返回第Kth的数===============");
        System.out.println(process(arr, 0, arr.length - 1,  k - 1));
        // 2
    }
}
