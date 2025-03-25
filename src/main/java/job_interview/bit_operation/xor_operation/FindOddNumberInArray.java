package job_interview.bit_operation.xor_operation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @BelongsPackage: job_interview.bit_operation.xor_operation
 * @ClassName: FindOddNumberInArray
 * @Author: 丛虹羽
 * @Date: 2025/3/25 09:56
 * @Description: 找出数组中只出现奇数次的数
 * leetcode: https://leetcode.cn/problems/single-number/
 */
public class FindOddNumberInArray {

    /**
     * 数组中只有一个出现奇数次的数，其他的所有数都出现了偶数次，找到这个数！！
     * 知识点：
     *      N ^ N = 0
     *      0 ^ N = N
     *
     * @return 数组中出现奇数次的数
     */
    public static int findOddNumberInArray(int[] nums) {
        int xor = 0;
        for (int number : nums) {
            xor ^= number;
        }
        return xor == 0 ? -1 : xor;
    }

    /**
     * 哈希表统计
     *
     * @param nums 原始数组
     */
    public static void showInfo(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for(Map.Entry<Integer, Integer> entry : entries) {
            System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue());
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 5, 5, 5, 4, 3, 3, 3, 2, 1, 1, 1, 7, 8, 8, 7, 7, 7};
        showInfo(nums);
        System.out.println("出现奇数次的个数的数是：" + findOddNumberInArray(nums));
        // 出现奇数次的个数的数是：-1

        int[] nums1 = {10, 2, 2, 3, 3, 3, 3};
        showInfo(nums1);
        System.out.println("出现奇数次的个数的数是：" + findOddNumberInArray(nums1));
        // 出现奇数次的个数的数是：10
    }
}
