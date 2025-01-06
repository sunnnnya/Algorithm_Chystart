package basic_knowledge.dynamic_program.two_dimensional;

/**
 * @BelongsPackage: basic_knowledge.dynamic_program.two_dimensional
 * @ClassName: LongestCommonSubsequence
 * @Author: 丛虹羽
 * @Date: 2025/1/4 下午10:34
 * @Description: 最长公共子序列
 *
 * leetcode: https://leetcode.cn/problems/longest-common-subsequence/description/
 */
public class LongestCommonSubsequence {

    /**
     * 两个字符串的最长公共子序列
     *
     * @param text1 字符串1
     * @param text2 字符串2
     * @return      返回的最长公共子序列的长度
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null || text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        return process(str1, str2, str1.length - 1, str2.length - 1);
    }

    /**
     * 递归函数意义：str1[0 ... i] 与 str2[0 ... j] 的最长公共子序列多长？
     *
     * @param str1 字符数组
     * @param str2 字符数组
     * @param i    索引
     * @param j    索引
     * @return
     */
    public static int process(char[] str1, char[] str2, int i, int j) {
        if(i == 0 && j == 0) {
            return str1[i] == str2[j] ? 1 : 0;
        }
        else if(i == 0) {
            if(str1[i] == str2[j]) {
                return 1;
            } else {
                return process(str1, str2, i, j - 1);
            }
        } else if (j == 0){
            if(str1[i] == str2[j]) {
                return 1;
            } else {
                return process(str1, str2, i - 1, j);
            }
        } else { // i != 0 && j != 0
            int p1 = process(str1, str2, i - 1, j);
            int p2 = process(str1, str2, i, j - 1);
            int p3 = str1[i] == str2[j] ? (1 + process(str1, str2, i, j - 1)) : 0;
            return Math.max(p1, Math.max(p2, p3));
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        // 3

        System.out.println(longestCommonSubsequence("abc", "abc"));
        // 3
    }
}