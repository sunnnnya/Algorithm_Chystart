package practice_questions.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @package: practice_questions.array.medium
 * @author: chystart
 * @create: 2024-12-27 13:10
 * @description: 查询数组中元素的出现位置
 *
 * leetcode: https://leetcode.cn/problems/find-occurrences-of-an-element-in-an-array/description/?envType=problem-list-v2&envId=oCGxsku3
 **/
public class OccurrencesOfElement {

    /**
     * 使用额外空间记录答案所处的位置
     *
     * @param nums     原始数组
     * @param queries  查询数组
     * @param x        要查询的值
     * @return
     */
    public static int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        // 不确定多少个 x 直接动态数组
        List<Integer> list = new ArrayList<>();
        int[] ans = new int[queries.length];
        for(int i = 0; i < nums.length; i++) {
            if(x == nums[i]) {
                list.add(i);
            }
        }
        for(int i = 0; i < queries.length; i++) {
            ans[i] = queries[i] > list.size() ? -1 : list.get(queries[i] - 1);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 7};
        int[] queries = {1, 3, 2, 4};
        int x = 1;
        System.out.println(Arrays.toString(occurrencesOfElement(nums, queries, x)));
    }
}