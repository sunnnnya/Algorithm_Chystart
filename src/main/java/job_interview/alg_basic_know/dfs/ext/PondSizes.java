package job_interview.alg_basic_know.dfs.ext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @BelongsPackage: job_interview.alg_basic_know.dfs.ext
 * @ClassName: PondSizes
 * @Author: 丛虹羽
 * @Date: 2025/3/27 15:23
 * @Description: 水域大小
 * https://leetcode.cn/problems/pond-sizes-lcci/description/
 */
public class PondSizes {

    /**
     * 简单的 dfs 遍历
     *
     * @param land 地图
     * @return 返回水域的排序大小
     */
    public static int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[0].length; j++) {
                if(land[i][j] == 0) {
                    list.add(dfs(land, i, j));
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
     * 以 (i, j) 节点可以扩充（八个方向）出来岛屿的数量
     *
     * @param land 地图
     * @param i    i index
     * @param j    j index
     * @return     返回以当前节点遍历得到的岛屿的大小
     */
    public static int dfs(int[][] land, int i, int j) {
        if(i < 0 || i == land.length || j < 0 ||j == land[0].length || land[i][j] > 0) {
            return 0;
        }
        land[i][j] += 1;
        return 1 + dfs(land, i - 1, j) +
                dfs(land, i - 1, j + 1) +
                dfs(land, i, j + 1) +
                dfs(land, i + 1, j + 1) +
                dfs(land, i + 1, j) +
                dfs(land, i + 1,  j - 1) +
                dfs(land, i, j - 1) +
                dfs(land, i - 1, j - 1);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = {{0, 2, 1, 0},
                        {0, 1, 0, 1},
                        {1, 1, 0, 1},
                        {0, 1, 0, 1}};
        System.out.println(Arrays.toString(pondSizes(grid)));
        // [1, 2, 4]
    }
}
