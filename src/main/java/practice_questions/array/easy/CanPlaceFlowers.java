package practice_questions.array.easy;

/**
 * @BelongsPackage: practice_questions.array.easy
 * @ClassName: CanPlaceFlowers
 * @Author: 丛虹羽
 * @Date: 2024/12/6 下午1:45
 * @Description: 种花问题
 *
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。
 * 可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。
 * 另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？
 * 能则返回 true ，不能则返回 false 。
 *
 * leetcode: https://leetcode.cn/problems/can-place-flowers
 */
public class CanPlaceFlowers {

    /**
     * 种花填充数组
     *
     * @param flowerbed 原始数组
     * @param n         可以种的花的数量
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] arr = new int[flowerbed.length + 2];
        arr[0] = arr[arr.length - 1] = 0;
        System.arraycopy(flowerbed, 0, arr, 1, flowerbed.length);
        for(int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] == 0 && arr[i] == 0 && arr[i + 1] == 0) {
                arr[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 0, 0, 1};
        System.out.println("能否种花：" + canPlaceFlowers(arr, 1));

        int[] arr2 = new int[]{1, 0, 0, 0, 1};
        System.out.println("能否种花：" + canPlaceFlowers(arr2, 2));
    }
}