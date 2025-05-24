package job_interview.code_top.string.manacher;

/**
 * @BelongsPackage: job_interview.code_top.string.manacher
 * @ClassName: LongestPalindrome
 * @Author: 丛虹羽
 * @Date: 2025/5/15 16:24
 * @Description: 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 */
public class LongestPalindrome {

    /**
     * 最长回文子串
     *
     * @param s 字符串
     * @return String
     */
    static String longestPalindrome(String s) {
        int max = 0, n = ((s.length() << 1) + 1);
        int[] p = new int[n];
        char[] ss = manacherss(s.toCharArray());
        int maxLen = 0;
        int maxCenter = 0;
        for(int i = 0, c = 0, r = 0, len; i < n; i++) {
            len = r > i ? Math.min(p[2 * c - i], r - i) : 1;
            while(i + len < n && i - len >= 0 && ss[i + len] == ss[i - len]) {
                len++;
            }
            if(i + len > r) {
                r = i + len;
                c = i;
            }
            if (len > maxLen) {
                maxLen = len;
                maxCenter = i;
            }
            max = Math.max(max, len);
            p[i] = len;
        }
        int start = (maxCenter - (maxLen - 1)) / 2;
        int end = (maxCenter + (maxLen - 1)) / 2;
        return s.substring(start, end);
    }

    /**
     * [1, 2, 3, 3, 2, 1]-> [#, 1, #, 2, #, 3, #, 3, #, 2, #, 1, #]
     *
     * @param c 字符串信息
     * @return char[]
     */
    static char[] manacherss(char[] c) {
        int n = (c.length << 1) + 1;
        char[] ss = new char[(n << 1) + 1];
        for(int i = 0, j = 0; i < n; i++) {
            ss[i] = (i & 1) == 0 ? '#' : c[j++];
        }
        return ss;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
        // bab
    }
}
