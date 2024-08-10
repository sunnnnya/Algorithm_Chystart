package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: RepeatedCharacter
 * @Author: 丛虹羽
 * @Date: 2024/8/9 下午8:49
 * @Description: 第一个出现两次的字母
 *
 * 给你一个由小写英文字母组成的字符串 s ，请你找出并返回第一个出现 两次 的字母。
 *
 * leetcode：https://leetcode.cn/problems/first-letter-to-appear-twice/description/
 */
public class RepeatedCharacter {

    /**
     * 使用位运算进行标记，可以理解为状态压缩；
     *
     * @param s
     * @return
     */
    public static char repeatedCharacter(String s) {
        char result = '\0';
        for (int i = 0, vis = 0; i < s.length(); i++) {
            if (((vis >> s.charAt(i) - 'a') & 1) == 1) {
                result = s.charAt(i);
                break;
            } else {
                vis |= 1 << s.charAt(i) - 'a';
            }
        }
        return result;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(repeatedCharacter("abccbaacz"));
        // c

        System.out.println(repeatedCharacter("abcdd"));
        // d
    }
}
