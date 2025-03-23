package leetcode.skill.array.common;

import java.util.Arrays;

/**
 * @package: leetcode.skill.array.common
 * @author: chystart
 * @create: 2025-03-22 18:42
 * @description: 一最多的行
 *
 * leetcode： https://leetcode.cn/problems/row-with-maximum-ones/?envType=daily-question&envId=2025-03-22
 **/
public class RowAndMaximumOnes {

    /**
     * 简单数组操作
     *
     * @param mat original array
     * @return int[]
     */
    public static int[] rowAndMaximumOnes(int[][] mat) {
        int minIndex = 0, maxCount = 0;
        for(int i = 0; i < mat.length; i++) {
            int count = 0;
            for(int j = 0; j < mat[i].length; j++) {
                count += mat[i][j] == 1 ? 1 : 0;
            }
            minIndex = count > maxCount ? i : minIndex;
            maxCount = count > maxCount ? count : maxCount;
        }
        return new int[]{minIndex, maxCount};
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 1}, {1, 0}};
        System.out.println("Result: " + Arrays.toString(rowAndMaximumOnes(arr)));
        // Result: [0, 1]
        int[][] arr1 = new int[][]{{0, 0, 0}, {0, 1, 1}};
        System.out.println("Result: " + Arrays.toString(rowAndMaximumOnes(arr1)));
        // Result: [1, 2]

        int[][] arr2 = new int[][]{{0, 0}, {1, 1}, {0, 0}};
        System.out.println("Result: " + Arrays.toString(rowAndMaximumOnes(arr1)));
        // Result: [1, 2]
    }
}
