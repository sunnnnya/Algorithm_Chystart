package job_interview.hot100.skill;

/**
 * @BelongsPackage: job_interview.hot100.skill
 * @ClassName: MajorityElement
 * @Author: 丛虹羽
 * @Date: 2025/7/13 09:36
 * @Description: 多数元素
 * https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class MajorityElement {

    /**
     * 摩尔投票
     *
     * @param nums 原始数组
     * @return 超过半数投票数
     */
    public static int majorityElement(int[] nums) {
        int votes = 0, ans = 0;
        for(int num : nums) {
            if(votes == 0) {
                ans = num;
            }
            votes += ans == num ? 1 : -1;
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
        // 2
    }
}
