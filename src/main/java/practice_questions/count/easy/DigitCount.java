package practice_questions.count.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @BelongsPackage: practice_questions.count.easy
 * @ClassName: DigitCount
 * @Author: 丛虹羽
 * @Date: 2024/8/9 下午9:05
 * @Description: 判断一个数的数字计数是否等于数位的值
 *
 * 给你一个下标从 0 开始长度为 n 的字符串 num ，它只包含数字。
 * 如果对于 每个 0 <= i < n 的下标 i ，都满足数位 i 在 num 中出现了 num[i]次，那么请你返回 true ，否则返回 false 。
 *
 * leetcode：https://leetcode.cn/problems/check-if-number-has-equal-digit-count-and-digit-value/description/
 */
public class DigitCount {

    /**
     * 使用bucket进行统计
     *
     * @param num
     * @return
     */
    public static boolean digitCount(String num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (char ch : num.toCharArray()) {
            map.put(ch - '0', map.getOrDefault(ch - '0', 0) + 1);
        }
        map.forEach((key, value) -> System.out.println("key: " + key + ", value: " + value));
        for (int i = 0; i < num.length(); i++) {
            if (map.getOrDefault(i, 0) != num.charAt(i) - '0') {
                return false;
            }
        }
        return true;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "1210";
        System.out.println(digitCount(str));

        System.out.println(digitCount(""));
    }
}
