package leetcode.hot100;

import java.util.HashSet;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-08 17:24
 * @description: 无重复字符的最长子串
 *
 * leetcode: https://leetcode.cn/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-100-liked
 **/
public class LengthOfLongestSubstring {

    /**
     * 滑动窗口
     *
     * @param s 原始字符串
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        int ans = 0;
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
    }
}
