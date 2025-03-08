package leetcode.hot100;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-08 13:09
 * @description: 接雨水 - chystart
 *
 * leetcode: https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked
 **/
public class Trap {

    /**
     * 辅助数组
     *
     * @param height 原始数组
     * @return
     */
    public static int trap1(int[] height) {
        int n = height.length, sum = 0;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        lmax[0] = height[0];
        for(int i = 1; i < height.length; i++) {
            lmax[i] = Math.max(lmax[i - 1], height[i]);
        }
        rmax[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], height[i]);
        }
        for(int i = 1; i < n - 1; i++) {
            sum += Math.max(Math.min(lmax[i - 1], rmax[i + 1]) - height[i], 0);
        }
        return sum;
    }

    /**
     * 双指针：
     *      找到接住雨水的瓶颈是最短边，所以靠近左右侧最短边的值可以确定接住雨水数量，同时一定更新最大值！！
     *
     * @param height 原始数组
     * @return
     */
    public static int trap(int[] height) {
        int l = 1, r = height.length - 2, lmax = height[0], rmax = height[height.length - 1];
        int ans = 0;
        while(l <= r) {
            if(lmax <= rmax) {
                ans += Math.max(lmax - height[l], 0);
                lmax = Math.max(lmax, height[l++]);
            } else {
                ans += Math.max(rmax - height[r], 0);
                rmax = Math.max(rmax, height[r--]);
            }
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
