package basic_knowledge.array.skill;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.array.skill
 * @ClassName: PrefixSumArrayII
 * @Author: 丛虹羽
 * @Date: 2024/12/13 下午11:18
 * @Description: 二维前缀和
 *
 * 上 + 左 - 左上 + 自己
 * sum[i][j] += sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
 *
 * 从左上角 (a,b) 到 右下角 (c,d) 的累加范围和
 * sum[c][d] - sum[c][b - 1] - sum[a - 1][d] + sum[a - 1][b - 1];
 * --------------------------------------------------------------
 * |    0    1    2
 * | 0  3    1   -2
 * | 1  5   -3    4
 * | 2  3    6   -2
 * (1, 1) -> (2, 2)
 * sum = sum[2][2] - sum[2][0] - sum[0][2] + sum[0][0]
 */
public class PrefixSumArrayII {

    /**
     * 使用克隆数组的方式，求二维数组的前缀和，一般情况下可能需要补全处理，这样就省去了判断的逻辑
     *
     * @param arr 原始数组
     * @return    返回二维前缀和数组
     */
    public static int[][] getSumArray(int[][] arr) {
        int[][] nums = new int[arr.length][arr[0].length];
        // 处理 [0][0] 点
        nums[0][0] = arr[0][0];
        // 处理最上面一行
        for(int i = 1; i < arr[0].length; i++) {
            nums[0][i] = nums[0][i - 1] + arr[0][i];
        }
        // 处理最左一列
        for(int j = 1; j < arr.length; j++) {
            nums[j][0] = nums[j - 1][0] + arr[j][0];
        }
        // 按照规则处理通用部分
        for(int i = 1; i < arr.length; i++) {
            for(int j = 1; j < arr[i].length; j++) {
                nums[i][j] = arr[i][j] + nums[i - 1][j] + nums[i][j - 1] - nums[i - 1][j - 1];
            }
        }
        return nums;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = new int[][]{{3, 1, -2},
                                  {5, -3, 4},
                                  {3, 6, -2}};
        System.out.println(Arrays.deepToString(getSumArray(arr)));
        // [[3, 4, 2],
        //  [8, 6, 8],
        //  [11, 15, 15]]
    }
}