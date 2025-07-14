package job_interview.hot100.matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsPackage: job_interview.hot100.matrix
 * @ClassName: SetZeroes
 * @Author: 丛虹羽
 * @Date: 2025/7/14 15:20
 * @Description: 矩阵置零
 * https://leetcode.cn/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class SetZeroes {

    /**
     * 矩阵的常规操作:
     *  空间复杂度O(mn)
     *
     * @param matrix 原始数组
     */
    public static void setZeroes1(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(row.contains(i) || col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 使用常量的空间复杂度
     *
     * @param matrix 原始数组
     */
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flag = false;
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) {
                flag = true;
            }
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 1; j--) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if(flag) {
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[][] nums = new int[][] {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes(nums);
        System.out.println(Arrays.deepToString(nums));
        // [[1, 0, 1], [0, 0, 0], [1, 0, 1]]
    }
}
