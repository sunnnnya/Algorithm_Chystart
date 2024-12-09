package practice_questions.slide_window.medium.not_fixed_length;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @BelongsPackage: practice_questions.slide_window.medium
 * @ClassName: LengthOfLongestSubstring
 * @Author: 丛虹羽
 * @Date: 2024/12/8 下午5:33
 * @Description: 无重复字符的最长子串 - 模板题
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 * leetcode： https://leetcode.cn/problems/longest-substring-without-repeating-characters
 */
public class LengthOfLongestSubstring {

    /**
     * 不定长滑动窗口
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        int ans = 0;
        Set<Character> set = new CopyOnWriteArraySet<>();
        for(int i = 0, left = 0; i < c.length; i++) {
            while(set.contains(c[i])) {
                set.remove(c[left++]); // left: 不重复元素的第一个左边界
            }
            set.add(c[i]);
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));

        System.out.println(lengthOfLongestSubstring("bbbbb"));

        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
