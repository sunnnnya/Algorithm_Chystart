package practice_questions.hash_table.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @BelongsPackage: practice_questions.hash_table.easy
 * @ClassName: TwoSum
 * @Author: 丛虹羽
 * @Date: 2024/8/15 上午11:07
 * @Description: 两数之和
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 *
 * leetcode:https://leetcode.cn/problems/two-sum
 */
public class TwoSum {

    /**
     * 使用hash表返回两数之和，Hash的value记录的是索引值
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(arr, target)));
        // [0, 1]
    }
}
