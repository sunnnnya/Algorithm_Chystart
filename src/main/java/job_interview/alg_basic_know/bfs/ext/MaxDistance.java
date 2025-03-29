package job_interview.alg_basic_know.bfs.ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.bfs.ext
 * @ClassName: MaxDistance
 * @Author: 丛虹羽
 * @Date: 2025/3/30 00:28
 * @Description: 地图分析
 * https://leetcode.cn/problems/as-far-from-land-as-possible/description/
 */
public class MaxDistance {

    public static int MAXM = 101;

    public static int MAXN = 101;

    // 队列数组
    public static int[][] queue = new int[MAXN * MAXM][2];

    // 标记数组
    public static boolean[][] vis = new boolean[MAXM][MAXN];

    // 方向数组
    public static int[] move = new int[]{-1, 0, 1, 0, -1};

    public static int l, r;

    /**
     * 普通 bfs 优化
     *
     * @param grid 地图
     * @return 最长距离
     */
    public static int maxDistance(int[][] grid) {
        l = r = 0;
        int m = grid.length, n = grid[0].length, sea = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    vis[i][j] = true;
                    queue[r][0] = i;
                    queue[r++][1] = j;
                } else {
                    vis[i][j] = false;
                    sea++;
                }
            }
        }
        if(sea == m * n || sea == 0) {
            return -1;
        }
        int level = 0;
        while(l < r) {
            level++;
            int size = r - l;
            for(int i = 0, x, y, nx, ny; i < size; i++) {
                x = queue[l][0];
                y = queue[l++][1];
                for(int d = 0; d < 4; d++) {
                    nx = x + move[d];
                    ny = y + move[d + 1];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0 && !vis[nx][ny]) {
                        vis[nx][ny] = true;
                        queue[r][0] = nx;
                        queue[r++][1] = ny;
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
        int[][] arr = new int[][]{{1,0,1},{0,0,0},{1,0,1}};
        System.out.println(maxDistance(arr));
        // 2
    }
}
