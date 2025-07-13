package job_interview.hot100.skill;

/**
 * @BelongsPackage: job_interview.hot100.skill
 * @ClassName: FindDuplicate
 * @Author: 丛虹羽
 * @Date: 2025/7/13 09:59
 * @Description: 寻找重复数
 */
public class FindDuplicate {

    /**
     * 快慢指针问题
     *
     * @param nums 原始数组
     * @return 找到重复的数
     */
    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,3,4,2};
        System.out.println(findDuplicate(nums));
        // 3
    }
}
