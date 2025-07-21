package job_interview.hot100.binary_search;

/**
 * @BelongsPackage: job_interview.hot100.binary_search
 * @ClassName: SearchMatrix
 * @Author: 丛虹羽
 * @Date: 2025/7/16 21:51
 * @Description: 搜索二维矩阵
 * https://leetcode.cn/problems/search-a-2d-matrix/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class SearchMatrix {

    /**
     * <= target 最右位置的值
     *
     * @param matrix 二维矩阵
     * @param target 目标值
     * @return true | false
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1;
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if(matrix[mid][0] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // 需要特殊处理一下，防止 r < 0 的情况，说明当前矩阵中所有元素的第一行值都 < target
        if(r < 0) {
            return false;
        }
        int ll = 0;
        int rr = matrix[r].length - 1;
        while(ll <= rr) {
            int mid = ll + ((rr - ll) >> 1);
            if(matrix[r][mid] > target) {
                rr = mid - 1;
            } else if(matrix[r][mid] < target) {
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
     * @param args 参数
     */
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(nums, 3));
        // true
    }
}
