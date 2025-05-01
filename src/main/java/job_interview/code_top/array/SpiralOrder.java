package job_interview.code_top.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: job_interview.code_top.array
 * @ClassName: SpiralOrder
 * @Author: 丛虹羽
 * @Date: 2025/5/1 17:44
 * @Description: 螺旋矩阵
 * https://leetcode.cn/problems/spiral-matrix/description/
 */
public class SpiralOrder {

    /**
     * 重点：条件判断
     *
     * @param matrix 原始数组
     * @return List<Integer>
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix == null || matrix[0].length == 0) {
            return ans;
        }
        int m = matrix.length, n = matrix[0].length;
        int t = 0, b = m - 1, l = 0, r = n - 1;
        while(ans.size() != m * n) {
            for(int i = l; i <= r; i++) {
                ans.add(matrix[t][i]);
            }
            t++;
            for(int i = t; i <= b; i++) {
                ans.add(matrix[i][r]);
            }
            r--;
            if(t <= b) {
                for(int i = r; i >= l; i--) {
                    ans.add(matrix[b][i]);
                }
                b--;
            }
            if(l <= r) {
                for(int i = b; i >= t; i--) {
                    ans.add(matrix[i][l]);
                }
                l++;
            }
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(arr));
        // [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}
