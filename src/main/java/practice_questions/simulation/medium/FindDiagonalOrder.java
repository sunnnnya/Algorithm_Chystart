package practice_questions.simulation.medium;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.simulation.medium
 * @ClassName: FindDiagonalOrder
 * @Author: 丛虹羽
 * @Date: 2024/12/18 下午9:47
 * @Description: 对角线遍历
 *
 * leetcode： https://leetcode.cn/problems/diagonal-traverse
 */
public class FindDiagonalOrder {
    /**
     * 数组模拟
     *
     * @param mat 原始数组
     * @return
     */
    public static int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length, index = 0;
        int[] res = new int[n * m];
        for(int j = 0; j < m + n - 1; j++) {
            if((j & 1) == 1) {
                int x = j < m ? 0 : j - m + 1;
                int y = j < m ? j : m - 1;
                while(x < n && y >= 0) {
                    res[index++] = mat[x++][y--];
                }
            } else {
                int x = j < n ? j : n - 1;
                int y = j < n ? 0 : j - n + 1;
                while(x >= 0 && y < m) {
                    res[index++] = mat[x--][y++];
                }
            }
        }
        return res;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.toString(findDiagonalOrder(array)));
        // [1, 2, 4, 7, 5, 3, 6, 8, 9]
    }
}