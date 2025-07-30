package job_interview.hot100.greed;

/**
 * @BelongsPackage: job_interview.hot100.greed
 * @ClassName: Jump
 * @Author: 丛虹羽
 * @Date: 2025/7/30 16:06
 * @Description: 跳跃游戏 II
 * https://leetcode.cn/problems/jump-game-ii/?envType=study-plan-v2&envId=top-100-liked
 */
public class Jump {

    /**
     * 贪心策略不断更新右边界
     *
     * @param nums 原始数组
     * @return int
     */
    public static int jump(int[] nums) {
        // curRight = 已经建造桥的右端点 | nextRight = 下一座要建造桥的右端点
        int ans = 0, nextRight = 0, curRight = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            nextRight = Math.max(nextRight, i + nums[i]);
            if(i == curRight) {
                curRight = nextRight;
                ans++;
            }
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(jump(nums));
        // 2

        int[] nums1 = new int[]{2, 1, 1, 1, 4};
        System.out.println(jump(nums1));
        // 3
    }
}
