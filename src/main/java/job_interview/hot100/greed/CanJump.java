package job_interview.hot100.greed;

/**
 * @BelongsPackage: job_interview.hot100.greed
 * @ClassName: CanJump
 * @Author: 丛虹羽
 * @Date: 2025/7/30 10:16
 * @Description: 跳跃游戏
 * https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class CanJump {

    /**
     * 贪心算法
     *
     * @param nums 原始数组
     * @return boolean
     */
    public static boolean canJump(int[] nums) {
        int mx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > mx) {
                return false;
            }
            mx = Math.max(mx, i + nums[i]);
        }
        return true;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
        // true

        int[] nums1 = new int[]{3,2,1,0,4};
        System.out.println(canJump(nums1));
        // false
    }
}
