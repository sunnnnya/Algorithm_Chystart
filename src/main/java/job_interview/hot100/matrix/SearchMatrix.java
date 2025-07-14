package job_interview.hot100.matrix;

/**
 * @BelongsPackage: job_interview.hot100.matrix
 * @ClassName: SearchMatrix
 * @Author: 丛虹羽
 * @Date: 2025/7/14 15:53
 * @Description: 搜索二维矩阵 II —— 技巧点，从右上角开始遍历
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class SearchMatrix {

    /**
     * 高效搜索二维矩阵
     *
     * @param matrix 原始数组
     * @param target 目标值
     * @return true | false
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while(i < m && j >= 0) {
            if(target > matrix[i][j]) {
                i++;
                continue;
            }
            if(target < matrix[i][j]) {
                j--;
                continue;
            }
            if(target == matrix[i][j]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(matrix, 20));
        // false
        System.out.println(searchMatrix(matrix, 16));
        // true
    }
}
