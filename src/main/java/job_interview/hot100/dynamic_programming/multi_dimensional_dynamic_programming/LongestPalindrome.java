package job_interview.hot100.dynamic_programming.multi_dimensional_dynamic_programming;

/**
 * @BelongsPackage: job_interview.hot100.dynamic_programming.multi_dimensional_dynamic_programming
 * @ClassName: LongestPalindrome
 * @Author: 丛虹羽
 * @Date: 2025/8/2 10:02
 * @Description: 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class LongestPalindrome {

    /**
     * manacher 算法
     *
     * @param s 原始字符串
     * @return String
     */
    public static String longestPalindrome(String s) {
        int n = (s.length() << 1) + 1;
        int[] p = new int[n];
        char[] ss = manacherss(s.toCharArray(), n);
        int maxLen = 0, maxCenter = 0;
        for(int i = 0, c = 0, r = 0, len; i < n; i++) {
            len = i < r ? Math.min(p[2 * c - i], r - i) : 1;
            while(i - len >= 0 && i + len < n && ss[i - len] == ss[i + len]) {
                len++;
            }
            if(i + len > r) {
                r = i + len;
                c = i;
            }
            if(len > maxLen) {
                maxLen = len;
                maxCenter = i;
            }
            p[i] = len;
        }
        int startIndex = (maxCenter - (maxLen - 1)) / 2;
        int endIndex = (maxCenter + (maxLen - 1)) / 2;
        return s.substring(startIndex, endIndex);
    }

    /**
     * 进行字符串的处理，否则会出现错误偶数长度字符串的情况
     *
     * @param c char[] 字符数组
     * @param n 字符数组的长度信息
     * @return char[]
     */
    private static char[] manacherss(char[] c, int n) {
        char[] ss = new char[n];
        for(int i = 0, j = 0; i < n; i++) {
            ss[i] = (i & 1) == 0 ? '#' : c[j++];
        }
        return ss;
    }


    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindrome(str));
        // bab
    }
}
