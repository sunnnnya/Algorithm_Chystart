package practice_questions.double_pointer.medium;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.double_pointer.medium
 * @ClassName: NumRescueBoats
 * @Author: 丛虹羽
 * @Date: 2024/12/13 下午4:49
 * @Description: 救生艇
 *
 * leetcode：https://leetcode.cn/problems/boats-to-save-people
 */
public class NumRescueBoats {

    /**
     * 需要合理的分析双指针的问题，对问题进行分析。
     * 贪心
     *
     * @param people
     * @param limit
     * @return
     */
    public static int numRescueBoats(int[] people, int limit) {
        int l = 0, r = people.length - 1, ans = 0;
        Arrays.sort(people);
        while(l <= r) {
            if(people[r] + people[l] > limit) {
                r--;
            } else {
                l++;
                r--;
            }
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

        int[] arr1 = new int[]{3, 5, 3, 4};
        System.out.println(numRescueBoats(arr1, 5));
        // 4
    }
}