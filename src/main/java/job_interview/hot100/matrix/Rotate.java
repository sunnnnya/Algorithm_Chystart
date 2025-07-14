package job_interview.hot100.matrix;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.hot100.matrix
 * @ClassName: Rotate
 * @Author: 丛虹羽
 * @Date: 2025/7/14 17:00
 * @Description: 旋转图像
 * https://leetcode.cn/problems/rotate-image/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Rotate {

    /**
     * 坐标直接旋转操作 - 记忆
     *
     * @param matrix 原始数组
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n / 2; i++) {
            for(int j = 0; j < (n + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(nums));
        // [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    }
}
