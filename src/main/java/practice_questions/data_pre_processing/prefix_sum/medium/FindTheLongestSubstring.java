package practice_questions.data_pre_processing.prefix_sum.medium;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.data_pre_processing.prefix_sum.medium
 * @ClassName: FindTheLongestSubstring
 * @Author: 丛虹羽
 * @Date: 2024/12/30 下午3:20
 * @Description: 每个元音包含偶数次的最长子字符串
 *
 * 提取信息：（1）偶数次：利用 奇偶性 可以做文章
 *          （2）最长：利用 滑动窗口 或 最早出现 前缀和 做文章
 *          （3）元音：利用 有限个数状态压缩 做文章
 *
 * leetcode: https://leetcode.cn/problems/find-the-longest-substring-containing-vowels-in-even-counts
 */
public class FindTheLongestSubstring {

    /**
     * 前缀和最早出现位置 + 状态压缩
     *
     * @param s 原始字符串
     * @return
     */
    public static int findTheLongestSubstring(String s) {
        int n = s.length();
        // 只有 5 个元音字符，状态 5 位，0000 ~ 11111
        int[] map = new int[32];
        // 状态初始化，全部设置为 -2
        Arrays.fill(map, -2);
        map[0] = -1;
        int ans = 0;
        for(int i = 0, status = 0, m; i < n; i++) {
            // s[i] = 当前字符
            m = move(s.charAt(i));
            if(m != -1) {
                status ^= 1 << m;
            }
            if(map[status] != -2) {
                ans = Math.max(ans, i - map[status]);
            } else {
                map[status] = i;
            }
        }
        return ans;
    }

    /**
     * a ~ u -> 0 ~ 4
     *
     * @param cha 当前字符
     * @return
     */
    public static int move(char cha) {
        switch (cha) {
            case 'a': return 0;
            case 'e': return 1;
            case 'i': return 2;
            case 'o': return 3;
            case 'u': return 4;
            default: return -1;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(findTheLongestSubstring("eleetminicoworoep"));
        // 13

        System.out.println(findTheLongestSubstring("leetcodeisgreat"));
        // 5

        System.out.println(findTheLongestSubstring("bcbcbc"));
        // 6
    }
}