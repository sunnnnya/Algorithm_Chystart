package leetcode.skill.double_pointer;

import java.util.Arrays;

/**
 * @package: leetcode.skill.double_pointer
 * @author: chystart
 * @create: 2025-03-08 14:09
 * @description: 救生艇 - chystart
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
     * 拓展题：要求组成的船的重量必须是偶数
     *   对于有奇偶行型的问题：解决方案一般都是从 奇数和偶数相加来考虑！！！
     *      思考点：偶数 + 偶数 = 偶数，奇数 + 奇数 = 偶数，奇数 + 偶数 ≠ 偶数。
     *      所以对原始数组进行拆分，拆分成 偶数的一个数组，奇数的一个数组，然后使用双指针进行求解
     *
     * @param people 原始数组
     * @param limit  限制
     * @return
     */
    public static int numRescueBoats1(int[] people, int limit) {
        // 过滤
        int[] even = Arrays.stream(people)
                .filter(p -> p % 2 == 0)
                .toArray();
        int[] odd = Arrays.stream(people)
                .filter(p -> p % 2 != 0)
                .toArray();
        // 排序
        Arrays.sort(even);
        Arrays.sort(odd);
        // 船只结果
        int boats = 0;
        // 偶数数组求最小船数
        int i = 0, j = even.length - 1;
        while (i <= j) {
            if (even[i] + even[j] <= limit) {
                i++;
            }
            j--;
            boats++;
        }
        // 奇数数组求最小船数
        i = 0;
        j = odd.length - 1;
        while (i <= j) {
            if (odd[i] + odd[j] <= limit) {
                i++;
            }
            j--;
            boats++;
        }
        return boats;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 2, 1};
        System.out.println("最少需要的船数: " + numRescueBoats(arr, 3));
        // 3

        int[] people = {2, 4, 6, 1, 3, 5};
        System.out.println("最少需要的船数: " + numRescueBoats1(people, 7));
        // 4
    }
}
