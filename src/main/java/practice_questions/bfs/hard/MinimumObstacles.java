package practice_questions.bfs.hard;

import java.util.ArrayDeque;

/**
 * @BelongsPackage: practice_questions.bfs.hard
 * @ClassName: MinimumObstacles
 * @Author: 丛虹羽
 * @Date: 2025/1/2 下午1:11
 * @Description: 到达角落需要移除障碍物的最小数目
 *
 * leetcode: https://leetcode.cn/problems/minimum-obstacle-removal-to-reach-corner
 */
public class MinimumObstacles {

    /**
     * 01bfs 模板，当前的位置有障碍物的时候，证明从当前点到障碍物位置的权重为 1，反之为 0
     *
     * @param grid 原始矩阵数组
     * @return
     */
    public static int minimumObstacles(int[][] grid) {
        int[] move = new int[]{-1, 0, 1, 0, -1};
        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.addFirst(new int[]{0, 0});
        distance[0][0] = 0;
        while(!deque.isEmpty()) {
            int[] record = deque.pollFirst();
            int x = record[0];
            int y = record[1];
            if(x == m - 1 && y == n - 1) {
                return distance[x][y];
            }
            for(int i = 0; i < 4; i++) {
                int nx = x + move[i];
                int ny = y + move[i + 1];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n &&
                        distance[x][y] + grid[nx][ny] < distance[nx][ny]) {
                    distance[nx][ny] = distance[x][y] + grid[nx][ny];
                    if(grid[nx][ny] == 0) {
                        deque.addFirst(new int[]{nx, ny});
                    } else {
                        deque.addLast(new int[]{nx, ny});
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
        int[][] grid = new int[][]{{0,1,1}, {1,1,0}, {1,1,0}};
        System.out.println(minimumObstacles(grid));
        // 2
    }
}