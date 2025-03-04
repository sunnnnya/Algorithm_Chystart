package leetcode.hot100;

/**
 * @BelongsPackage: leetcode.hot100
 * @ClassName: OrangesRotting
 * @Author: 丛虹羽
 * @Date: 2025/3/4 07:55
 * @Description: 腐烂的橘子
 *
 * leetcode: https://leetcode.cn/problems/rotting-oranges/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class OrangesRotting {

    public static int MAXN = 101;

    public static int[][] queue = new int[MAXN][2];

    public static int l, r = 0;

    public static int[] dir = new int[]{-1, 0, 1, 0, -1};

    /**
     * bfs 优化技巧
     *
     * @param grid
     * @return
     */
    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue[r][0] = i;
                    queue[r++][1] = j;
                }
            }
        }
        int step = -1;
        while(l < r) {
            int size = r - l;
            step++;
            for(int i = 0; i < size; i++) {
                int x = queue[l][0];
                int y = queue[l++][1];
                for(int k = 0; k < 4; k++) {
                    int nx = x + dir[k];
                    int ny = y + dir[k + 1];
                    if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1) {
                        queue[r][0] = nx;
                        queue[r++][1] = ny;
                        grid[nx][ny] = 2;
                    }
                }
            }
        }
        for(int[] arr : grid) {
            for(int num : arr) {
                if(num == 1) {
                    return -1;
                }
            }
        }
        return Math.max(step, 0);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] array = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(array));
        // 4

        int[][] array1 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(orangesRotting(array1));
        // -1

        int[][] array2 = {{0, 2}};
        System.out.println(orangesRotting(array2));
        // 0
    }
}
