package practice_questions.bfs.medium;

/**
 * @BelongsPackage: practice_questions.bfs.medium
 * @ClassName: NearestExit
 * @Author: 丛虹羽
 * @Date: 2025/1/2 下午10:34
 * @Description: 迷宫中离入口最近的出口
 *
 * leetcode: https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze
 */
public class NearestExit {

    public static int MAXN = 101;

    // 表示一共最多有 MAXN * MAXN 个点进入队列中去，队列中的每个坐标是 (queue[i][0], queue[i][1])
    public static int[][] queue = new int[MAXN * MAXN][2];

    public static int[] move = new int[]{-1, 0, 1, 0, -1};

    public static boolean[][] vis = new boolean[MAXN][MAXN];

    public static int l, r;

    /**
     * 普通 bfs 优化
     *
     * @param maze     迷宫数组
     * @param entrance 入口数组
     * @return
     */
    public static int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int level = 0;
        l = r = 0;
        queue[r][0] = entrance[0];
        queue[r++][1] = entrance[1];
        vis[entrance[0]][entrance[1]] = true;
        while(l < r) {
            int size = r - l;
            level++;
            for(int i = 0; i < size; i++) {
                int x = queue[l][0];
                int y = queue[l++][1];
                for(int dir = 0; dir < 4; dir++) {
                    int nx = x + move[dir];
                    int ny = y + move[dir + 1];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny] && maze[nx][ny] == '.') {
                        // 是边界并且不是入口，直接返回
                        if((nx == 0 || nx == m - 1 || ny == 0 || ny == n - 1) &&
                                (nx != entrance[0] || ny != entrance[1])) {
                            return level;
                        }
                        queue[r][0] = nx;
                        queue[r++][1] = ny;
                        vis[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] maze = {
                {'+', '+', '.', '+'},
                {'.', '.', '.', '+'},
                {'+', '+', '+', '.'}
        };
        int[] entrance = {1, 2};
        System.out.println(nearestExit(maze, entrance));
        // 1
    }
}