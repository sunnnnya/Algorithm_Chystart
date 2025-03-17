package leetcode.hot100;

import java.util.Arrays;

/**
 * @BelongsPackage: leetcode.hot100
 * @ClassName: SetZeroes
 * @Author: 丛虹羽
 * @Date: 2025/3/17 21:23
 * @Description: 矩阵置零
 *
 * leetcode: https://leetcode.cn/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class SetZeroes {

    /**
     * 使用标记数组：O(mn)
     *
     * @param matrix 二维数组
     */
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // TODO: 待优化

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(arr);
        System.out.println(Arrays.deepToString(arr));
        // [[1, 0, 1], [0, 0, 0], [1, 0, 1]]
    }
}
