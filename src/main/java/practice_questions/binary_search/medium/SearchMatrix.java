package practice_questions.binary_search.medium;

/**
 * @BelongsPackage: practice_questions.binary_search.medium
 * @ClassName: SearchMatrix
 * @Author: 丛虹羽
 * @Date: 2024/12/14 下午8:43
 * @Description: 搜索二维矩阵
 *
 * leetcode: https://leetcode.cn/problems/search-a-2d-matrix
 */
public class SearchMatrix {

    /**
     * 使用普通遍历的方式实现元素的查找
     *
     * @param matrix 原始数组
     * @param target 目标值
     * @return       false | true
     */
    public static boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix[0][0] > target) {
            return false;
        }
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 如果当前数组元素特别的大，需要使用二分搜索进行查找
     *
     * @param matrix 原始数组
     * @param target 目标值
     * @return       true | false
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length - 1;
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            // <= target 的右位置
            if(matrix[mid][0] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // 即使 l 越界 r 不变，符合条件，依然二分查找
        if (r == -1) {
            return false;
        } else {
            int ll = 0;
            int rr = matrix[r].length - 1;
            while(ll <= rr) {
                int mid = ll + ((rr - ll) >> 1);
                if(matrix[r][mid] == target) {
                    return true;
                } else if (matrix[r][mid] > target) {
                    rr = mid - 1;
                } else {
                    ll = mid + 1;
                }
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
        int[][] arr = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        System.out.println(searchMatrix(arr, target));
        // true

        int target1 =13;
        System.out.println(searchMatrix(arr,  target1));
        // false

        int[][] arr2 = new int[][]{{1}};
        int target2 = 2;
        System.out.println(searchMatrix(arr2, target2));
        // false
    }
}