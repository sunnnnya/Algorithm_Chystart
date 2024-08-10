package practice_questions.bit_operation.medium;

import java.util.HashSet;

/**
 * @BelongsPackage: practice_questions.bit_operation.middle
 * @ClassName: FindDuplicate
 * @Author: 丛虹羽
 * @Date: 2024/8/10 下午11:38
 * @Description: 寻找重复数
 *
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 *
 * leetcode： https://leetcode.cn/problems/find-the-duplicate-number
 */
public class FindDuplicate {

    /**
     * 使用状态压缩的方式，额外空间复杂度O（1）
     * 小数据量范围写法！！！！！大数据量直接超了
     *
     * @param nums
     * @return
     */
    public static int findDuplicate1(int[] nums) {
        // 注意点：数据范围问题
        long vis = 0;
        int result = 0;
        for (int number : nums) {
            if (((vis >> number) & 1) == 1) {
                result = number;
                break;
            } else {
                // 状态压缩
                vis |= (1L << number);
            }
        }
        return result;
    }

    /**
     * 使用哈希表进行遍历寻找操作
     *
     * @param nums
     * @return
     */
    public static int findDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int number : nums) {
            if (set.contains(number)) {
                return number;
            }
            set.add(number);
        }
        return -1;
    }

    /**
     * 大数量的写法
     *
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        int n = nums.length, ans = 0;
        int bit_max = 31;
        while (((n - 1) >> bit_max) == 0) {
            bit_max -= 1;
        }
        for (int bit = 0; bit <= bit_max; ++bit) {
            int x = 0, y = 0;
            for (int i = 0; i < n; ++i) {
                if ((nums[i] & (1 << bit)) != 0) {
                    x += 1;
                }
                if (i >= 1 && ((i & (1 << bit)) != 0)) {
                    y += 1;
                }
            }
            if (x > y) {
                ans |= 1 << bit;
            }
        }
        return ans;
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

        int[] arr1 = new int[]{34,7,47,5,8,72,18,94,49,21,65,22,81,30,79,37,27,38,12,53,6,57,4,59,60,23,74,25,83,99,2,3,9,82,48,73,28,18,56,10,84,33,88,67,61,18,18,18,13,77,97,76,95,90,17,31,52,36,91,64,29,18,18,43,18,89,86,51,18,66,78,70,45,55,98,18,71,80,26,75,41,58,85,20,18,96,32,63,1,54,14,92,35,16,11,15,39,40,93,62};
        System.out.println(findDuplicate(arr1));
        // 18
    }
}
