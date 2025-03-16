package leetcode.hot100;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-16 21:57
 * @description: 搜索二维矩阵
 *
 * leetcode: https://leetcode.cn/problems/search-a-2d-matrix/description/?envType=study-plan-v2&envId=top-100-liked
 **/
public class SearchMatrix {

    /**
     * 暴力
     *
     * @param matrix 数组
     * @param target 目标值
     * @return 返回是否存在元素
     */
    public static boolean searchMatrix1(int[][] matrix, int target) {
        for(int[] arr : matrix) {
            for(int num : arr) {
                if (target == num) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 使用二分搜索
     *
     * @param matrix 数组
     * @param target 目标值
     * @return 返回是否存在元素
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1;
        // <= target 的最大值的 row
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if(matrix[mid][0] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if(r == -1) {
            return false;
        }
        if(matrix[r][0] == target) {
            return true;
        }
        int ll = 0, rr = matrix[r].length - 1;
        while(ll <= rr) {
            int mid = ll + ((rr - ll) >> 1);
            if (matrix[r][mid] > target) {
                rr = mid - 1;
            } else if (matrix[r][mid] < target) {
                ll = mid + 1;
            } else {
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
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println("result: " + searchMatrix(matrix, 13));
        // result: false

        int[][] matrix1 = {
                {1, 3, 5, 7},
                {10, 11, 13, 20},
                {23, 30, 34, 60}
        };
        System.out.println("result: " + searchMatrix(matrix1, 13));
        // result: true
    }
}
