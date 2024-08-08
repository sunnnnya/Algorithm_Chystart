package basic_knowledge.sort.base_sort;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.sort.base_sort
 * @ClassName: BucketSort
 * @Author: 丛虹羽
 * @Date: 2024/8/8 下午8:34
 * @Description: 桶排序
 *
 * 指定多少个桶，依次按照个位，十位，百位,....依次入桶，然后再拿出来，最终的结果就是排好序的数组
 *
 * arr原数组     = [013, 021, 011, 052, 062];
 * -- 第一轮
 *   count词频数组 = [0, 2, 2, 1, 0, 0, 0, 0, 0, 0]; 表示位数为几出现了多少次 count[2] = 2表示个位为2的有两个数
 *          index =  0  1  2  3  4  5  6  7  8  9
 *
 * count前缀和数组 = [0  2  4  5  5  5  5  5  5  5]; 表示位数 <= index的有多少个；
 *          index =  0  1  2  3  4  5  6  7  8  9
 *
 * 按照arr原数组：从后向前遍历，比如：062个位数为2，然后对应count的前缀和数组count[2] = 4表示当前数组中个位数<=2的数有四个，故当前值放在index为3的位置，然后count[2]--
 *    help辅助数组 = [021, 011, 052, 062, 013]
 *
 *
 */
public class BucketSort {

    /**
     * 返回一个数组中最大值的位数
     *
     * @param nums
     * @return
     */
    public static int maxBits(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int number : nums) {
            max = Math.max(number, max);
        }
        int ans = 0;
        while (max != 0) {
            max /= 10;
            ++ans;
        }
        return ans;
    }

    /**
     * 获取一个数指定位数上的值，从右往左取
     *
     * @param x
     * @param d
     * @return
     */
    public static int getDigit(int x, int d){
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    /**
     * 进行桶排序的函数
     *
     * @param arr     待排序的数组
     * @param L       排序数组的左边界
     * @param R       排序数组的右边界
     * @param maxBits 排序数组中的最大值的位数
     */
    public static void process(int[] arr, int L, int R, int maxBits) {
        final int radix = 10; // 0 ~ 9
        int i = 0, j = 0;
        int[] bucket = new int[R - L + 1];
        for (int d = 1; d <= maxBits; d++) { // 最大值是几位的就入桶出桶多少次
            int[] count = new int[radix];
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                // 此处位置相当于重新赋值bucket数组
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    /**
     * 桶排序的入口
     *
     * @param arr
     */
    public static void bucketSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return ;
        }
        process(arr, 0, arr.length - 1, maxBits(arr));
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main (String[]args){
        int[] arr = new int[]{10, 21, 12, 9, 12, 123, 321, 7, 67, 199};
        System.out.println(maxBits(arr));
        // 3

        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
        // [7, 9, 10, 12, 12, 21, 67, 123, 199, 321]
    }
}
