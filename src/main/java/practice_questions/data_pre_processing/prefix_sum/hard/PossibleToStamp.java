package practice_questions.data_pre_processing.prefix_sum.hard;

/**
 * @BelongsPackage: practice_questions.data_pre_processing.prefix_sum.hard
 * @ClassName: PossibleToStamp
 * @Author: 丛虹羽
 * @Date: 2024/12/16 下午12:13
 * @Description: 用邮票贴满网格图
 *
 * leetcode: https://leetcode.cn/problems/stamping-the-grid
 */
public class PossibleToStamp {

    /**
     * 使用前缀和进行判断是否可以贴，使用二维差分判断是否贴过邮票
     *
     * @param grid        原始数组
     * @param stampHeight 邮票的高度
     * @param stampWidth  邮票的宽度
     * @return true | false
     */
    public static boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] sum = new int[n + 1][m + 1];
        int[][] diff = new int[n + 2][m + 2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sum[i + 1][j + 1] = grid[i][j];
            }
        }
        buildPreArray(sum);
        // 这里的邮票理解为不是宽度 (1,0) -> (2,0) 宽度实际是2， 而不是1
        for(int a = 1, c = a + stampHeight - 1; c < sum.length; a++, c++) {
            for(int b = 1, d = b + stampWidth - 1; d < sum[0].length; b++, d++) {
                if(getSum(sum, a, b, c, d) == 0) {
                    add(diff, a, b, c, d, 1);
                }
            }
        }
        buildPreArray(diff);
        // 一般坐标偏移的时候，使用小的数组进行枚举，然后通过偏移直接枚举偏移之后的数组
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0 && diff[i + 1][j + 1] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 按照公式构建前缀和数组
     *
     * @param sum  原始数组
     */
    private static void buildPreArray(int[][] sum) {
        for(int i = 1; i < sum.length; i++) {
            for(int j = 1; j < sum[i].length; j++) {
                sum[i][j] += sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }
    }

    /**
     * 求(a, b) -> (c, d) 之间的矩阵中元素总和
     *
     * @param g 原始数组
     * @param a 左上角 x
     * @param b 左上角 y
     * @param c 右下角 x
     * @param d 右下角 y
     * @return
     */
    private static int getSum(int[][] g, int a, int b, int c, int d) {
        return g[c][d] - g[a - 1][d] - g[c][b - 1] + g[a - 1][b - 1];
    }

    /**
     * 二维差分数组的使用
     *
     * @param diff 初始化的差分数组
     * @param a    左上角 x
     * @param b    左上角 y
     * @param c    右下角 x
     * @param d    右下角 y
     */
    private static void add(int[][] diff, int a, int b, int c, int d, int v) {
        diff[a][b] += v;
        diff[a][d + 1] -= v;
        diff[c + 1][b] -= v;
        diff[c + 1][d + 1] += v;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,0,0,0}, {1,0,0,0}, {1,0,0,0}, {1,0,0,0}, {1,0,0,0}};
        int stampHeight = 4, stampWidth = 3;
        System.out.println(possibleToStamp(grid, stampHeight, stampWidth));
        // true
    }
}