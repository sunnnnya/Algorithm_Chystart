package practice_questions.bit_operation.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: FlipAndInvertImage
 * @Author: 丛虹羽
 * @Date: 2024/8/9 下午2:23
 * @Description: 翻转图像
 *
 * 给定一个 n x n 的二进制矩阵 image ，先 水平 翻转图像，然后 反转 图像并返回结果 。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。
 * 例如，水平翻转 [1,1,0] 的结果是 [0,1,1]。
 *
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。
 * 例如，反转 [0,1,1] 的结果是 [1,0,0]。
 *
 * leetcode：https://leetcode.cn/problems/flipping-an-image/description/
 */
public class FlipAndInvertImage {

    /**
     * 反转数组
     *
     * @param image
     * @return
     */
    public static int[][] flipAndInvertImage(int[][] image) {
        for (int[] arr : image) {
            int i = 0, j = arr.length - 1;
            while (i < j) {
                swap(arr, i++, j--);
            }
            for (int c = 0; c < arr.length; c++) {
                arr[c] ^= 1;
            }
        }
        return image;
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
        int[][] arr = new int[][]{{1, 1, 0},
                                  {1, 0, 1},
                                  {0, 0, 0}};
        System.out.println(Arrays.deepToString(flipAndInvertImage(arr)));
        // [[1, 0, 0], [0, 1, 0], [1, 1, 1]]

        int[][] arr1 = new int[][]{{1, 1, 0, 0},
                                   {1, 0, 0, 1},
                                   {0, 1, 1, 1},
                                   {1, 0, 1, 0}};
        System.out.println(Arrays.deepToString(flipAndInvertImage(arr1)));
        // [[1, 1, 0, 0], [0, 1, 1, 0], [0, 0, 0, 1], [1, 0, 1, 0]]
    }
}
