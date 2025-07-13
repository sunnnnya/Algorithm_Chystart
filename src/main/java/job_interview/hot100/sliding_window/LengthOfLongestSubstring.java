package job_interview.hot100.sliding_window;

import java.util.HashSet;

/**
 * @BelongsPackage: job_interview.hot100.sliding_window
 * @ClassName: LengthOfLongestSubstring
 * @Author: 丛虹羽
 * @Date: 2025/7/13 15:31
 * @Description: 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class LengthOfLongestSubstring {

    /**
     * 哈希表 + 滑动窗口
     *  使用 HashSet 记录遍历过的位置，然后一次进行寻找，剔除最左边的元素。
     *
     * @param s 字符串
     * @return 最长无重复长度
     */
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        char[] c = s.toCharArray();
        int ans = 0;
        for(int i = 0, left = 0; i < c.length; i++) {
            while(set.contains(c[i])) {
                set.remove(c[left++]);
            }
            ans = Math.max(ans, i - left + 1);
            set.add(c[i]);
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

        String str1 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(str1));
        // 1
    }
}
