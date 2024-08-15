package practice_questions.array.easy;

import java.util.HashSet;

/**
 * @BelongsPackage: practice_questions.array.easy
 * @ClassName: ContainsNearbyDuplicate
 * @Author: 丛虹羽
 * @Date: 2024/8/15 上午9:30
 * @Description: 存在重复元素 II
 *
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 *
 * leetcode：https://leetcode.cn/problems/contains-duplicate-ii
 */
public class ContainsNearbyDuplicate {

    /**
     * 滑动窗口 + 哈希表
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        int l = 0;
        int r = k;
        // 如果出现 K > nums.length - 1的情况，就需要把所有的数据全部进行set中
        for (int i = l; i <= Math.min(k, nums.length - 1); i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        // 为了防止数组的越界一定是， r < nums.length
        while (r < nums.length - 1) {
            set.remove(nums[l++]);
            if (set.contains(nums[r + 1])) {
                return true;
            } else {
                set.add(nums[++r]);
            }
        }
        return false;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1};
        System.out.println(containsNearbyDuplicate(arr, 3));
        // true

        int[] arr1 = new int[]{1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate(arr1, 1));
        // true

        int[] arr2 = new int[]{1, 2, 3, 1, 2, 3};
        System.out.println(containsNearbyDuplicate(arr2, 2));
        // false

        int[] arr3 = new int[]{1, 2, 3, 4, 5, 1};
        System.out.println(containsNearbyDuplicate(arr3, 8));
        // true
    }
}
