package leetcode.hot100;

import java.util.Arrays;

/**
 * @BelongsPackage: leetcode.hot100
 * @ClassName: Rotate
 * @Author: 丛虹羽
 * @Date: 2025/3/17 22:21
 * @Description: 旋转图像
 *
 * leetcode: https://leetcode.cn/problems/rotate-image/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Rotate {

    /**
     * 使用辅助数组：
     *   针对坐标有规律的问题，首先要往规式方面想！！！
     *   arr[j][N - i - 1] = matrix[i][j];
     *
     * @param matrix 原始数组
     */
    public static void rotate(int[][] matrix) {
        int N = matrix.length;
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++){
                arr[j][N - i - 1] = matrix[i][j];
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                matrix[i][j] = arr[i][j];
            }
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
