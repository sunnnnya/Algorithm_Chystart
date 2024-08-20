package basic_knowledge.fast_power.matrix_fast_power;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.fast_power.matrix_fast_power
 * @ClassName: MatrixMult
 * @Author: 丛虹羽
 * @Date: 2024/8/20 下午5:48
 * @Description: 矩阵乘法的实现
 */
public class MatrixMultiply {

    /**
     * 矩阵的乘法实现
     *
     * @param a
     * @param b
     * @return
     */
    public static int[][] matrixMultiply(int[][] a, int [][] b) {
        if (a == null || b == null) {
            return null;
        }
        int N = a.length;
        int K = a[0].length;
        int M = b[0].length;
        int[][] result = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < K; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int[][] b = new int[][]{{1, 4}, {2, 5}, {3, 6}};
        int[][] result = matrixMultiply(a, b);
        System.out.println(Arrays.deepToString(result));
        // [[14, 32],
        //  [32, 77]]
    }
}
