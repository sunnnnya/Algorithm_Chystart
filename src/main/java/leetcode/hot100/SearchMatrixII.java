package leetcode.hot100;

/**
 * @BelongsPackage: leetcode.hot100
 * @ClassName: searchMatrixII
 * @Author: 丛虹羽
 * @Date: 2025/3/17 22:51
 * @Description: 搜索二维矩阵 II
 *
 * leetcode: https://leetcode.cn/problems/search-a-2d-matrix-ii/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class SearchMatrixII {

    /**
     * 右上角进行判断
     *
     * @param matrix 原始数组
     * @param target 目标值
     * @return true | false
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int t = 0, r = matrix[0].length - 1, l = 0, b = matrix.length - 1;
        while(t <= b && l <= r) {
            // 先去除右边
            if(matrix[t][r] > target) {
                r--;
                continue;
            }
            // 再去除左边
            if(matrix[t][r] < target) {
                t++;
                continue;
            }
            if(matrix[t][r] == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 4, 7, 11, 15},
                                  {2, 5, 8, 12, 19},
                                  {3, 6, 9, 16, 22},
                                  {10, 13, 14, 17, 24},
                                  {18, 21, 23, 26, 30}};
        System.out.println("Result: " + searchMatrix(arr, 20));
        // Result: false

        int[][] arr1 = new int[][]{{1, 4, 7, 11, 15},
                                   {2, 5, 8, 12, 19},
                                   {3, 6, 9, 16, 22},
                                   {10, 13, 14, 17, 24}};
        System.out.println("Result: " + searchMatrix(arr1, 5));
        // Result: true
    }
}
