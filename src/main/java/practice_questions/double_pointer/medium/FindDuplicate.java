package practice_questions.double_pointer.medium;

/**
 * @BelongsPackage: practice_questions.double_pointer
 * @ClassName: FindDuplicate
 * @Author: 丛虹羽
 * @Date: 2024/12/13 下午12:08
 * @Description: 寻找重复数 - 快慢指针
 *
 * leetcode：https://leetcode.cn/problems/find-the-duplicate-number
 */
public class FindDuplicate {

    /**
     * 寻找重复数，通过数组的下标和值之间是可以形成链表关系的
     * 1 3 4 2 2
     * 0 1 2 3 4
     * 1 -> 3 -> 2 -> 4 -> 2
     *
     * @param nums 原始数组
     * @return     返回重复的数字
     */
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,2,2};
        System.out.println(findDuplicate(arr));
        // 2

        int[] arr1 = new int[]{3,1,3,4,2};
        System.out.println(findDuplicate(arr1));
        // 3
    }
}