package job_interview.code_top.array;

import java.util.HashSet;

/**
 * @BelongsPackage: job_interview.code_top.array
 * @ClassName: LengthOfLongestSubstring
 * @Author: 丛虹羽
 * @Date: 2025/5/1 18:07
 * @Description: 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 */
public class LengthOfLongestSubstring {

    /**
     * 滑动窗口问题
     *
     * @param s 原始字符串
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) {
            return 0;
        }
        int ans = 0;
        char[] c = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0, left = 0; i < c.length; i++) {
            while(set.contains(c[i])) {
                set.remove(c[left++]);
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
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
        // 3

        String str1 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str1));
        // 3
    }
}
