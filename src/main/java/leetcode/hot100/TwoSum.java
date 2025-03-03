package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @BelongsPackage: leetcode.hot100
 * @ClassName: TwoSum
 * @Author: 丛虹羽
 * @Date: 2025/2/28 22:09
 * @Description: 两数之和
 *
 * leetcode: https://leetcode.cn/problems/two-sum/?envType=study-plan-v2&envId=top-100-liked
 */
public class TwoSum {

    /**
     * 哈希表
     *
     * @param nums   原始数组
     * @param target 目标值
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target-nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * 双重 for 循环
     *
     * @param nums   原始数组
     * @param target 目标值
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 双指针
     *
     * @param nums   原始数组
     * @param target 目标值
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        int l = 0, r = nums.length - 1;
        while(l < r) {
            if(arr[l] + arr[r] < target) {
                l++;
            } else if (arr[l] + arr[r] > target) {
                r--;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = 0; i < nums.length; i++) {
                    if (nums[i] == arr[l] || nums[i] == arr[r]) {
                        list.add(i);
                    }
                }
                return new int[]{list.get(0), list.get(1)};
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        System.out.println("Result: " + Arrays.toString(twoSum(arr, 9)));
        // Result: [1, 0]

        int[] arr1 = new int[]{3, 2, 4};
        System.out.println("Result: " + Arrays.toString(twoSum(arr1, 6)));
        // Result: [2, 1]

        int[] arr2 = new int[]{3, 3};
        System.out.println("Result: " + Arrays.toString(twoSum(arr2, 6)));
        // Result: [1, 0]
    }
}
