package job_interview.code_top.array.array_statistics;

/**
 * @BelongsPackage: job_interview.code_top.array.array_statistics
 * @ClassName: MajorityElement
 * @Author: 丛虹羽
 * @Date: 2025/5/17 14:35
 * @Description: 多数元素
 * https://leetcode.cn/problems/majority-element/description/
 */
public class MajorityElement {

    /**
     * 摩尔投票：抵消的原理
     *
     * @param nums 原始数组
     * @return
     */
    static int majorityElement(int[] nums) {
        int votes = 0, ans = 0;
        for(int num : nums) {
            if (votes == 0) {
                ans = num;
            }
            votes += num == ans ? 1 : -1;
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println("MajorElement: " + majorityElement(nums));
        // MajorElement: 2
    }
}
