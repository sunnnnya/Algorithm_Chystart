package practice_questions.slide_window.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsPackage: practice_questions.slide_window.easy
 * @ClassName: CountGoodSubstrings
 * @Author: 丛虹羽
 * @Date: 2024/12/8 下午12:16
 * @Description: 长度为三且各字符不同的子字符串
 *
 * 如果一个字符串不含有任何重复字符，则这个字符串为好字符串。给你一个字符串 s ，请你返回 s 中长度为 3 的好子字符串的数量。
 *
 * leetcode: https://leetcode.cn/problems/substrings-of-size-three-with-distinct-characters
 */
public class CountGoodSubstrings {
    /**
     *
     * @param s
     * @return
     */
    public static int countGoodSubstrings(String s) {
        char[] c = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int sum = 0, k = 3;
        for(int i = 0; i < c.length; i++) {
            map.put(c[i], map.getOrDefault(c[i], 0) + 1);
            if(i <  k - 1) {
                continue;
            }
            if(map.size() == k) {
                sum++;
            }
            if(map.get(c[i - k + 1]) != 1) {
                map.put(c[i - k + 1], map.get(c[i - k + 1]) - 1);
            } else {
                map.remove(c[i - k + 1]);
            }
        }
        return sum;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("xyzzaz"));
        // 1

        System.out.println(countGoodSubstrings("aababcabc"));
        // 4
    }
}