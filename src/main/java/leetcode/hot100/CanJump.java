package leetcode.hot100;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-23 17:50
 * @description: 跳跃游戏
 *
 * leetcode: https://leetcode.cn/problems/jump-game/?envType=study-plan-v2&envId=top-100-liked
 **/
public class CanJump {

    /**
     * 贪心的简单使用
     *
     * @param nums 原始数组
     * @return true | false
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
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 1, 4};
        System.out.println("Result: " + canJump(arr));
        // Result: true
    }
}
