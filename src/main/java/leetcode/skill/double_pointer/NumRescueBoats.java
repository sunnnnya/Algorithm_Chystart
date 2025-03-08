package leetcode.skill.double_pointer;

import java.util.Arrays;

/**
 * @package: leetcode.skill.double_pointer
 * @author: chystart
 * @create: 2025-03-08 14:09
 * @description: 救生艇
 *
 * leetcode: https://leetcode.cn/problems/boats-to-save-people/description/
 **/
public class NumRescueBoats {

    /**
     * 双指针:
     *      想好自己的装载策略，当两个指针之和 > limit 的时候，只能装载 people[r]，即使l == r，people[l] + people[r] > target 也只会装一个
     *
     * @param people 原始数组
     * @param limit  最多限制
     * @return
     */
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1, ans = 0;
        while(l <= r) {
            if(people[l] + people[r] <= limit) {
                l++;
            }
            r--;
            ans++;
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 2, 1};
        System.out.println(numRescueBoats(arr, 3));
        // 3
    }
}
