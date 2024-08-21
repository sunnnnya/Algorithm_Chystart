package basic_knowledge.fast_power.matrix_fast_power;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.matrix_fast_power
 * @ClassName: Demo
 * @Author: 丛虹羽
 * @Date: 2024/8/20 下午5:15
 * @Description: 矩阵快速幂
 * 固定关系的1维k阶递推表达式，用矩阵快速幂求解时间复杂度0(1ogn *k的3次方);
 * 固定关系的k维1阶递推表达式，用矩阵快速幂求解时间复杂度0(logn *k的3次方);
 */
public class MatrixFasterPower {

    /**
     * 单位矩阵的初始化
     *
     * @param len
     * @return
     */
    public static int[][] init(int len) {
        if (len == 0) {
            return null;
        }
        int[][] arr = new int[len][len];
        for (int i = 0; i < len; i++) {
            arr[i][i] = 1;
        }
        return arr;
    }

    /**
     * 矩阵的乘法
     *
     * @param a
     * @param b
     * @return
     */
    public static int[][] matrixMultiply(int[][] a, int [][] b) {
        int N = a.length;
        int[][] ans = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return ans;
    }

    /**
     * 矩阵的快速幂，同样是利用幂次的二进制计算
     *
     * @param m
     * @param p
     * @return
     */
    public static int[][] matrixPower(int[][] m, int p) {
        int[][] arr = init(m.length);
        if (p == 0) {
            return arr;
        }
        while (p > 0) {
            if ((p & 1) == 1) {
                arr = matrixMultiply(arr, m);
            }
            m = matrixMultiply(m, m);
            p >>= 1;
        }
        return arr;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2},
                                  {2, 1}};
        int[][] result = matrixPower(arr, 3);
        System.out.println(Arrays.deepToString(result));
        // [[13, 14],
        //  [14, 13]]
    }
}
