package practice_questions.merge_sort.hard;

/**
 * @BelongsPackage: practice_questions.merge_sort.hard
 * @ClassName: reversePairsII
 * @Author: 丛虹羽
 * @Date: 2024/8/14 上午9:43
 * @Description: 翻转对 **
 *
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * leetcode：https://leetcode.cn/problems/reverse-pairs
 */
public class ReversePairsII {

    /**
     * 归并排序的改写
     *
     * @param nums
     * @return
     */
    public static int reversePairs(int[] nums) {
        if(nums == null || nums.length == 1 || nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    /**
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1,  r) + merge(arr, l, mid, r);
    }

    /**
     * 数组归并的过程，注意要逆序处理
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     * @return
     */
    public static int merge(int[] arr, int l, int mid, int r) {
        int pp2 = mid + 1;
        int sum = 0;
        // 改写不一定要分析在合并的过程中，也可以出现在单独的过程中
        for (int i = l; i <= mid; i++) {
            // 注意点：可能会出现溢出的问题！！
            while (pp2 <= r && arr[i] > (2L * arr[pp2])) {
                pp2++;
            }
            sum += pp2 - mid - 1;
        }
        int p1 = l;
        int p2 = mid + 1;
        int index = 0;
        int[] help = new int[r - l + 1];
        while (p1 <= mid && p2 <= r) {
            help[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }
        while (p2 <= r) {
            help[index++]  = arr[p2++];
        }
        for (int i = 0; i < index; i++) {
            arr[l + i] = help[i];
        }
        return sum;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 3, 1};
        System.out.println(reversePairs(arr));
        // 2

        int[] arr1 = new int[]{2, 4, 3, 5, 1};
        System.out.println(reversePairs(arr1));
        // 3

        int[] arr2 = new int[]{5, 4, 3, 2, 1};
        System.out.println(reversePairs(arr2));
        // 4
    }
}
