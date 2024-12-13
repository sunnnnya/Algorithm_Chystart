package practice_questions.double_pointer.hard;

/**
 * @BelongsPackage: practice_questions.double_pointer.hard
 * @ClassName: Trap
 * @Author: 丛虹羽
 * @Date: 2024/12/13 下午1:28
 * @Description: 接雨水
 *
 * leetcode：https://leetcode.cn/problems/trapping-rain-water
 */
public class Trap {
    /**
     * 分析：
     *  当前方格可以容纳的雨水的个数 = min(max(左侧)，max(右侧)) - nums[i]
     *
     * @param height 原始数组
     * @return       可以容纳的雨水的个数
     */
    public static int trap(int[] height) {
        int n = height.length;
        // 数据预处理：
        //      lmax[i] 表示：0 ~ i 之间的最大值
        //      rmax[i] 表示：i ~ n - 1 之间的最大值
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        lmax[0] = height[0];
        rmax[n - 1] = height[n - 1];
        for(int i = 1; i < height.length; i++) {
            // 0 ~ i - 1 之间的最大值，和当前值比较
            lmax[i] = Math.max(lmax[i - 1], height[i]);
        }
        for(int i = n - 2; i >= 0; i--) {
            // i + 1 ~ n 之间的最大值，和当前值比较
            rmax[i] = Math.max(rmax[i + 1], height[i]);
        }
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            // 左侧和右侧中的最大值中的最小值 - 当前值，表示当前可以容纳多少个水，但如果此位置的值比左右两侧都大，则返回0
            ans += Math.max((Math.min(lmax[i - 1], rmax[i + 1]) - height[i]), 0);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
        // 6

        int[] arr1 = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(trap(arr1));
        // 9
    }
}