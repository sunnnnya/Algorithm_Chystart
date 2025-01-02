package practice_questions.bfs.hard;

import java.util.ArrayDeque;

/**
 * @BelongsPackage: practice_questions.bfs.hard
 * @ClassName: MinCost
 * @Author: 丛虹羽
 * @Date: 2025/1/2 下午2:37
 * @Description: 使网格图至少有一条有效路径的最小代价
 *
 * leetcode: https://leetcode.cn/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid
 */
public class MinCost {

    /**
     * 01bfs 把方向相同的 权重设置 为 0，反之设置为 1
     *
     * @param grid
     * @return
     */
    public static int minCost(int[][] grid) {
        int[][] move = {{}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
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
            for(int i = 1; i <= 4; i++) {
                int nx = x + move[i][0];
                int ny = y + move[i][1];
                int weight = grid[x][y] != i ? 1 : 0;
                if(nx >= 0 && nx < m && ny >= 0 && ny < n
                        && distance[x][y] + weight < distance[nx][ny]) {
                    distance[nx][ny] = distance[x][y] + weight;
                    if(weight == 0) {
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
        int[][] array = {
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {1, 1, 1, 1},
                {2, 2, 2, 2}
        };
        System.out.println(minCost(array));
        // 3
    }
}
