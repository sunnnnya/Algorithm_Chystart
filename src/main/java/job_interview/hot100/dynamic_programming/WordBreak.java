package job_interview.hot100.dynamic_programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @BelongsPackage: job_interview.hot100.dynamic_programming
 * @ClassName: WordBreak
 * @Author: 丛虹羽
 * @Date: 2025/8/3 22:09
 * @Description: 单词拆分
 * https://leetcode.cn/problems/word-break/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class WordBreak {

    /**
     * 动态规划的使用
     *
     * @param s 字符串
     * @param wordDict 字典
     * @return boolean
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        int maxLen = 0;
        for(String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }
        Set<String> words = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 1; i <= n; i++) {
            for(int j = i - 1; j >= Math.max(i - maxLen, 0); j--) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        String s1 = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s1, wordDict));
        // true
    }
}
