package practice_questions.quick_sort.medium;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.quick_sort.medium
 * @ClassName: DindKthLargest
 * @Author: 丛虹羽
 * @Date: 2024/8/14 下午3:42
 * @Description: 数组中的第K个最大元素
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * leetcode: https://leetcode.cn/problems/kth-largest-element-in-an-array
 */
public class FindKthLargest {

    /**
     * 利用荷兰国旗问题，随机进行 partitation，快速排序的改写
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        if (nums.length == 1 && k > 1) {
            return -1;
        }
        return process(nums, 0, nums.length - 1, k - 1);
    }

    /**
     * 递归函数
     *
     * @param arr
     * @param l
     * @param r
     * @param index
     * @return
     */
    public static int process(int[] arr, int l, int r, int index) {
        int randomNumber = arr[l + (int)(Math.random() * (r - l + 1))];
        int[] p = partition(arr, l, r, randomNumber);

        if (index >= p[0] && index <= p[1]) {
            return arr[index ];
        } else if (index < p[0]) {
            return process(arr, l, p[0] - 1, index);
        } else {
            return process(arr, p[1] + 1, r, index);
        }
    }

    /**
     * 同样使用荷兰国旗问题，但是从大到小进行组织
     *
     * @param arr
     * @param l
     * @param r
     * @param N
     * @return
     */
    public static int[] partition(int[] arr, int l, int r, int N) {
        int less = l - 1;
        int more = r + 1;
        int index = l;
        while (index < more) {
            if (arr[index] > N) {
                swap(arr, index++, ++less);
            } else if (arr[index] < N) {
                swap(arr, index, --more);
            } else {
                index++;
            }
        }
        // 返回的是在数组中的 index 位置
        return new int[]{less + 1, more - 1};
    }

    /**
     * i、j下标的值交换
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
        System.out.println("==================测试Partitaion函数==================");
        int[] arr = new int[]{3,2,3,1,2,4,5,5,6};
        int[] partition = partition(arr, 0, arr.length - 1, 2);
        System.out.println(Arrays.toString(partition));
        // [6, 7]
        System.out.println(Arrays.toString(arr));
        // [3, 3, 6, 4, 5, 5, 2, 2, 1]

        System.out.println("===============测试返回数组中第K大的数===================");
        int[] arr1 = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(arr1, 4));
        // 4

        int[] arr2 = new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest(arr2, 2));
        // 5
    }
}