package practice_questions.dfs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @BelongsPackage: practice_questions.dfs.medium
 * @ClassName: PondSizes
 * @Author: 丛虹羽
 * @Date: 2025/1/8 上午12:39
 * @Description: 水域大小
 *
 * leetcode: https://leetcode.cn/problems/pond-sizes-lcci
 */
public class PondSizes {

    /**
     * 使用 ArrayList() -> int[] -> 排序 + dfs
     *
     * @param land 原始数组
     * @return
     */
    public static int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        int m = land.length, n = land[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(land[i][j] == 0) {
                    list.add(dfs(land, i, j, m, n));
                }
            }
        }
        Collections.sort(list);
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    /**
     * 函数含义：返回当前点(x, y)扩散出去点的个数
     *
     * @param land 原始数组
     * @param x    点 x
     * @param y    点 x
     * @param m    行数
     * @param n    列数
     * @return     返回当前点(x, y)扩散出去点的个数
     */
    public static int dfs(int[][] land, int x, int y, int m, int n) {
        if(x < 0 || x >= m || y < 0 || y >= n || land[x][y] > 0) {
            return 0;
        }
        land[x][y] = 1;
        return dfs(land, x - 1, y, m, n) +
                dfs(land, x - 1, y + 1, m, n) +
                dfs(land, x, y + 1, m, n) +
                dfs(land, x + 1, y + 1, m, n) +
                dfs(land, x + 1, y, m, n) +
                dfs(land, x + 1, y - 1, m, n) +
                dfs(land, x, y - 1, m, n) +
                dfs(land, x - 1, y - 1, m, n) + 1;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] land = {{0, 2, 1, 0},
                        {0, 1, 0, 1},
                        {1, 1, 0, 1},
                        {0, 1, 0, 1}};
        System.out.println(Arrays.toString(pondSizes(land)));
        // [1, 2, 4]
    }
}