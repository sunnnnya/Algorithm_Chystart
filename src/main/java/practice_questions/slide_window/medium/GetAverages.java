package practice_questions.slide_window.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.slide_window.medium
 * @ClassName: GetAverages
 * @Author: 丛虹羽
 * @Date: 2024/12/7 下午10:37
 * @Description:  半径为 k 的子数组平均值
 *
 * leetcode: https://leetcode.cn/problems/k-radius-subarray-averages
 */
public class GetAverages {

    /**
     * 使用滑动窗口的方式创建均值数组
     *
     * @param nums 原始数组
     * @param k    半径
     * @return     均值数组
     */
    public static int[] getAverages(int[] nums, int k) {
        long sum = 0;
        int N = nums.length;
        int[] avg = new int[N];
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(notEnough(i, k, N)) {
                avg[i] = -1;
            }
            if(i < 2 * k) {
                continue;
            }
            avg[i - k] = (int)(sum / ((2 * k + 1)));
            sum -= nums[(i - 2 * k)];
        }
        return avg;
    }

    /**
     * 判断是否超出半径
     *
     * @param i 当前的 index
     * @param k 半径的长度
     * @param l 数组的总长度
     * @return
     */
    private static boolean notEnough(int i, int k, int l) {
        return 0 > i - k || i + k > l - 1;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6};
        System.out.println("数组：" + Arrays.toString(arr) + " 对应的均值数组如下所示：");
        System.out.println(Arrays.toString(getAverages(arr, 3)));
    }
}