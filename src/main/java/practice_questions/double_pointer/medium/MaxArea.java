package practice_questions.double_pointer.medium;

/**
 * @BelongsPackage: practice_questions.double_pointer.medium
 * @ClassName: MaxArea
 * @Author: 丛虹羽
 * @Date: 2024/12/13 下午5:47
 * @Description: 盛最多水的容器
 *
 * leetcode: https://leetcode.cn/problems/container-with-most-water/
 */
public class MaxArea {

    /**
     * 针对自己设计的双指针策略，需要进行验证查看是否会错过最优解，如果所有情况都会考虑到，说明策略正确！！
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while(l < r) {
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            if(height[l] <= height[r]) {
                l++;
            } else {
                r--;
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
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
        // 49
    }
}