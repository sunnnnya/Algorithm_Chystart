package job_interview.hot100.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsPackage: job_interview.hot100.sliding_window
 * @ClassName: FindAnagrams
 * @Author: 丛虹羽
 * @Date: 2025/7/13 16:00
 * @Description: 找到字符串中所有字母异位词
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked
 */
public class FindAnagrams {

    /**
     * 定长滑动窗口
     *  通过 左边界的判断 先不让左边进来 continue
     *
     * @param s 原始串
     * @param p 子串
     * @return 索引的位置
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] pp = new int[26];
        int[] ss = new int[26];
        for(char c : p.toCharArray()) {
            pp[c - 'a']++;
        }
        for(int right = 0; right < s.length(); right++) {
            ss[s.charAt(right) - 'a']++;
            int left = right - p.length() + 1;
            if(left < 0) {
                continue;
            }
            if(Arrays.equals(pp, ss)) {
                ans.add(left);
            }
            ss[s.charAt(left) - 'a']--;
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
        // [0, 6]
    }
}
