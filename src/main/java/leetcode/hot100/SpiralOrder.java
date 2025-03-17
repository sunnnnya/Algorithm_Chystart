package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: leetcode.hot100
 * @ClassName: SpiralOrder
 * @Author: 丛虹羽
 * @Date: 2025/3/17 21:43
 * @Description: 螺旋矩阵
 *
 * leetcode: https://leetcode.cn/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class SpiralOrder {

    /**
     * 定义四个边界
     *
     * @param matrix 二维数组
     * @return 链表
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new ArrayList<Integer>();
        }
        List<Integer> list = new ArrayList<>();
        int l = 0, t = 0, r = matrix[0].length - 1, b = matrix.length - 1;
        // 左边界 <= 右边界 && 上边界 <= 下边界
        while(l <= r && t <= b) {
            for(int i = l; i <= r; i++) {
                list.add(matrix[t][i]);
            }
            t++;
            for(int i = t; i <= b; i++) {
                list.add(matrix[i][r]);
            }
            r--;
            if(t <= b) {
                for(int i = r; i >= l; i--) {
                    list.add(matrix[b][i]);
                }
                b--;
            }
            if(l <= r) {
                for(int i = b; i >= t; i--) {
                    list.add(matrix[i][l]);
                }
                l++;
            }
        }
        return list;
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
        System.out.println("result: " + spiralOrder(matrix));
    }
}
