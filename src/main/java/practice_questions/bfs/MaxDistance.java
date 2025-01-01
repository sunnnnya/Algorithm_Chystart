package practice_questions.bfs;

/**
 * @BelongsPackage: practice_questions.bfs
 * @ClassName: MaxDistance
 * @Author: 丛虹羽
 * @Date: 2025/1/1 下午3:35
 * @Description: 地图分析 —— 多源 bfs
 *
 * leetcode: https://leetcode.cn/problems/as-far-from-land-as-possible/
 */
public class MaxDistance {

    public static int MAXN = 101;

    public static int MAXM = 101;

    public static int[][] queue = new int[MAXN * MAXM][2];

    public static boolean[][] vis = new boolean[MAXN][MAXM];

    // 方向数组：0: 上 1: 右 2: 下 3: 左
    // 记住这种写法
    public static int[] move = new int[]{-1, 0, 1, 0, -1};

    public static int l, r;

    /**
     * 多源点 bfs
     *
     * @param grid 原始矩阵
     * @return
     */
    public static int maxDistance(int[][] grid) {
        l = r = 0;
        int n = grid.length;
        int m = grid[0].length;
        int seas = 0, level = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // 多个源点进入队列
                if(grid[i][j] == 1) {
                    vis[i][j] = true;
                    queue[r][0] = i;
                    queue[r++][1] = j;
                } else {
                    vis[i][j] = false;
                    seas++;
                }
            }
        }
        if(seas == 0 || seas == n * m) {
            return -1;
        }
        while(l < r) {
            int size = r - l;
            level++;
            for(int i = 0, x, y, nx, ny; i < size; i++) {
                x = queue[l][0];
                y = queue[l++][1];
                for(int j = 0; j < 4; j++) {
                    nx = x + move[j];
                    ny = y + move[j + 1];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 0 && !vis[nx][ny]) {
                        queue[r][0] = nx;
                        queue[r++][1] = ny;
                        // 一定要更新状态
                        vis[nx][ny] = true;
                    }
                }
            }
        }
        return level - 1;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        System.out.println(maxDistance(arr));
        // 2

        int[][] arr1 = new int[][]{{1,0,0}, {0,0,0}, {0,0,0}};
        System.out.println(maxDistance(arr1));
        // 4
    }
}