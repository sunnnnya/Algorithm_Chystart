package basic_knowledge.array.skill;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.array.skill
 * @ClassName: PrefixSumArray
 * @Author: 丛虹羽
 * @Date: 2024/12/3 上午10:08
 * @Description: 前缀和数组的使用
 */
public class PrefixSumArray {

    /**
     * 针对原数组求前缀和数组
     *
     * @param nums 待求前缀和的数组
     * @return     返回原数组的前缀和数组
     */
    public static int[] getPrefixArray(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    /**
     * 拷贝数组的方式返回前缀和数组
     *
     * @param nums 原始数组
     * @return     前缀和数组
     */
    public static int[] getPrefixArrayClone(int[] nums) {
        int[] cloneArr = new int[nums.length];
        cloneArr[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            cloneArr[i] = nums[i] + cloneArr[i - 1];
        }
        return cloneArr;
    }

    /**
     * 求指定范围的和，使用下标
     *
     * @param arr 前缀和数组
     * @param l   左侧索引下标
     * @param r   右侧索引下标
     * @return    l - r 的和
     */
    public static int getSumUseIndex(int[] arr, int l, int r) {
        return l == 0 ? arr[r] : arr[r] - arr[l - 1];
    }

    /**
     * 使用数组位置，返回前缀和信息
     *
     * @param arr 前缀和数组
     * @param l   左侧索引位置
     * @param r   右侧索引位置
     * @return    l - r 的结果
     */
    public static int getSumUseNumber(int[] arr, int l, int r) {
        return l == 1 ? arr[r - 1] : arr[r - 1] - arr[l - 2];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("=====================求前缀和数组======================");
        int[] arr = new int[]{7, 2, 1, 4, 2, 6, 8, 10};
        System.out.println("原数组：" + Arrays.toString(arr));
        System.out.println("前缀和数组：" + Arrays.toString(getPrefixArray(arr)));
        // 原数组：[7, 2, 1, 4, 2, 6, 8, 10]
        // 前缀和数组：[7, 9, 10, 14, 16, 22, 30, 40]

        System.out.println();

        int[] arr1 = new int[]{1, 2, 5, 21, 7, 9, 10};
        System.out.println("原数组：" + Arrays.toString(arr1));
        System.out.println("前缀和数组：" + Arrays.toString(getPrefixArrayClone(arr1)));
        // 原数组：[1, 2, 5, 21, 7, 9, 10]
        // 前缀和数组：[1, 3, 8, 29, 36, 45, 55]

        System.out.println("====================求指定范围的和=====================");
        System.out.println("index(1, 4)：" + getSumUseIndex(getPrefixArrayClone(arr1), 1, 4));
        // index(1, 4)：35

        System.out.println("index(0, 4)：" + getSumUseIndex(getPrefixArrayClone(arr1), 0, 4));
        // index(0, 4)：36

        System.out.println("number(1, 5)：" + getSumUseNumber(getPrefixArrayClone(arr1), 1, 5));
        // number(1, 5)：36
    }
}