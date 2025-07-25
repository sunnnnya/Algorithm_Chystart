package job_interview.hot100.graph;

/**
 * @BelongsPackage: job_interview.hot100.graph
 * @ClassName: OrangesRotting
 * @Author: 丛虹羽
 * @Date: 2025/7/25 16:39
 * @Description: 腐烂的橘子
 * https://leetcode.cn/problems/rotting-oranges/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class OrangesRotting {

    private static int MAXN = 100;

    private static int[][] queue = new int[MAXN][2];

    private static int l, r = 0;

    private static int[] dir = new int[]{-1, 0, 1, 0, -1};

    /**
     * bfs 优化使用
     *
     * @param grid 地图
     * @return int 感染的数量
     */
    public static int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue[r][0] = i;
                    queue[r++][1] = j;
                }
            }
        }
        int ans = -1;
        while(l < r) {
            int size = r - l;
            ans++;
            for(int i = 0; i < size; i++) {
                int x = queue[l][0];
                int y = queue[l++][1];
                for(int d = 0; d < 4; d++) {
                    int xx = x + dir[d];
                    int yy = y + dir[d + 1];
                    if(xx >= 0 && xx < m && yy >= 0 && yy < n && grid[xx][yy] == 1) {
                        queue[r][0] = xx;
                        queue[r++][1] = yy;
                        grid[xx][yy] = 2; // 添加进队列后，需要进行感染调整
                    }
                 }
            }
        }
        for(int[] nums : grid) {
            for(int number : nums) {
                if(number == 1) {
                    return -1;
                }
            }
        }
        return Math.max(ans, 0);
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
        //
    }
}
