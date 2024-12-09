package practice_questions.slide_window.medium.fixed_length;

/**
 * @BelongsPackage: practice_questions.sliding_window
 * @ClassName: MaxVowels
 * @Author: 丛虹羽
 * @Date: 2024/12/7 下午4:03
 * @Description: 滑动窗口 - 定长子串中元音的最大数目
 *
 *  返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数；
 *
 *  leetcode：https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length
 */
public class MaxVowels {

    /**
     * 定长子串中元音的最大数目
     *
     * @param s 待求解的字符串
     * @param k 窗口的大小
     * @return  返回元音的个数信息
     */
    public static int maxVowels(String s, int k) {
        // a b c i i i d e f
        char[] c = s.toCharArray();
        int vowel = 0, ans = -1;
        for (int i = 0; i < c.length; i++) {
            if(isVowel(c[i])) {
                vowel++;
            }
            if(i < k - 1) {
                continue;
            }
            ans = Math.max(ans, vowel);
            if (isVowel(c[i - k + 1])) {
                vowel--;
            }
        }
        return ans;
    }

    /**
     * 判断是否是元音
     *
     * @param c 待判断的字符
     * @return  true | false
     */
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
    }
}