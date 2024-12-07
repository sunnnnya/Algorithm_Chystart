package practice_questions.string;

/**
 * @BelongsPackage: practice_questions.string
 * @ClassName: MaxScore
 * @Author: 丛虹羽
 * @Date: 2024/12/7 下午1:30
 * @Description: 分割字符串的最大得分
 *
 * 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
 *
 * 分割字符串的得分为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
 *
 * leetcode： https://leetcode.cn/problems/maximum-score-after-splitting-a-string/?envType=study-plan-v2&envId=primers-list
 */
public class MaxScore {

    /**
     * 模拟实现求解最大值
     *
     * @param s
     * @return
     */
    public static int maxScore(String s) {
        char[] sc = s.toCharArray();
        int rightOne = 0, leftZero = 0, max = -1;
        for(char ss : sc) {
            if(ss - '0' == 1) {
                rightOne++;
            }
        }
        leftZero = (sc[0] - '0' == 0) ? 1 : 0;
        rightOne -= (sc[0] - '0' == 1) ? 1 : 0;
        max = Math.max(max, leftZero + rightOne);
        for(int i = 1; i < sc.length - 1; i++) {
            rightOne -= ((sc[i] - '0' == 1) ? 1 : 0);
            leftZero += ((sc[i] - '0' == 0) ? 1 : 0);
            max = Math.max(max, leftZero + rightOne);
        }
        return max;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(maxScore("0010"));
        // 3

        System.out.println(maxScore("011101"));
        // 5
    }
}