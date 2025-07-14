package job_interview.hot100.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: job_interview.hot100.matrix
 * @ClassName: SpiralOrder
 * @Author: 丛虹羽
 * @Date: 2025/7/14 15:48
 * @Description: 螺旋矩阵
 * https://leetcode.cn/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class SpiralOrder {

    /**
     * 螺旋矩阵，四边界技巧
     *
     * @param matrix 原始数组
     * @return List<Integer>
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        List<Integer> ans = new ArrayList<>();
        while(top <= bottom && left <= right) {
            for(int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if(top <= bottom) {
                for(int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left <= right) {
                for(int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(nums));
        // [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}
