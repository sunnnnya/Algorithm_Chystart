package leetcode.hot100;

import java.util.HashSet;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-06 19:23
 * @description: 寻找重复数
 *
 * leetcode: https://leetcode.cn/problems/find-the-duplicate-number/?envType=study-plan-v2&envId=top-100-liked
 **/
public class FindDuplicate {

    /**
     * HashSet
     *
     * @param nums 原始数组
     * @return
     */
    public static int findDuplicate1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    /**
     * 快慢指针寻找入环节点 —— 和链表中的解法一样，寻找第一个入环节点
     *
     * @param nums 数组
     * @return
     */
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
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
        int[] arr = new int[]{1, 3, 4, 2, 2};
        System.out.println(findDuplicate(arr));
        // 2

        int[] arr1 = new int[]{3, 1, 3, 4, 2};
        System.out.println(findDuplicate(arr1));
        // 3

        int[] arr2 = new int[]{3, 3, 3, 3, 3};
        System.out.println(findDuplicate(arr2));
        // 3
    }
}
