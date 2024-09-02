package practice_questions.prefix_sum_array.easy;

/**
 * @BelongsPackage: practice_questions.prefix_sum_array.easy
 * @ClassName: MaximumPopulation
 * @Author: 丛虹羽
 * @Date: 2024/9/2 下午10:43
 * @Description: 人口最多的年份
 *
 * 给你一个二维整数数组 logs ，其中每个 logs[i] = [birthi, deathi] 表示第 i 个人的出生和死亡年份。
 * 年份 x 的 人口 定义为这一年期间活着的人的数目。第 i 个人被计入年份 x 的人口需要满足：x 在闭区间 [birthi, deathi - 1] 内。注意，人不应当计入他们死亡当年的人口中。
 * 返回 人口最多 且 最早 的年份。
 *
 * leetcode: https://leetcode.cn/problems/maximum-population-year
 */
public class MaximumPopulation {

    /**
     * 差分数组 + 前缀和 + 数组偏移 的基本使用
     *
     * @param logs
     * @return
     */
    public static int maximumPopulation(int[][] logs) {
        int[] ages = new int[101];
        for (int[] arr : logs) {
            ages[arr[0] - 1950]++;
            ages[arr[1] - 1950]--;
        }
        int maxIndex = 0;
        maxIndex = ages[0] > maxIndex ? 0 : ages[0];
        for (int i = 1; i < ages.length; i++) {
            ages[i] = ages[i] + ages[i - 1];
            maxIndex = ages[i] > ages[maxIndex] ? i : maxIndex;
        }
        return maxIndex + 1950;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1993, 1999}, {2000, 2010}};
        System.out.println(maximumPopulation(arr));
        // 1993

        int[][] arr1 = new int[][]{{1950, 1961}, {1960, 1971}, {1970, 1981}};
        System.out.println(maximumPopulation(arr1));
        // 1960

        int[][] arr2 = new int[][]{{1982,1998}, {2013,2042},{2010,2035},{2022,2050},{2047,2048}};
        System.out.println(maximumPopulation(arr2));
        // 2022
    }
}
