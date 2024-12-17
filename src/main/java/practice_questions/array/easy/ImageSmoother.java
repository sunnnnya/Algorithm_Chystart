package practice_questions.array.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.array.easy
 * @ClassName: ImageSmoother
 * @Author: 丛虹羽
 * @Date: 2024/12/18 上午12:44
 * @Description: 图片平滑器
 *
 * leetcode： https://leetcode.cn/problems/image-smoother
 */
public class ImageSmoother {

    /**
     * 尝试寻找通用解法，不要尝试使用特殊点特判，因为会越写越乱，要考虑的特殊数据情况太多了！！！
     *
     * @param img 原始数组
     * @return
     */
    public static int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;
        int[][] help = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // 测试完全可以理解为：拿到坐标(i, j)
                int count = 0, sum = 0;
                for(int x = i - 1; x <= i + 1; x++) {
                    for(int y = j - 1; y <= j + 1; y++) {
                        // 此时的循环是对每个点的周围八个点进行处理，包括自己
                        if(x >= 0 && x < n && y >= 0 && y < m) {
                            count++;
                            sum += img[x][y];
                        }
                    }
                }
                help[i][j] = sum / count;
            }
        }
        return help;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] array = {
                {100, 200, 100},
                {200, 50, 200},
                {100, 200, 100}
        };
        System.out.println(Arrays.deepToString(imageSmoother(array)));
        // [[137, 141, 137], [141, 138, 141], [137, 141, 137]]
    }
}