package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: FindTheDifference
 * @Author: 丛虹羽
 * @Date: 2024/8/7 下午10:55
 * @Description: 找不同
 *
 * leetcode：https://leetcode.cn/problems/find-the-difference/description/
 *
 * 给定两个字符串 s 和 t ，它们只包含小写字母。字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 */
public class FindTheDifference {

    /**
     * 返回添加的字符，使用异或找到对应的值
     *
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {
        int eor = 0;
        for (int i = 0; i < s.length(); i++) {
            eor ^= (s.charAt(i) - 'a');
        }
        for (int i = 0; i < t.length(); i++) {
            eor ^= (t.charAt(i) - 'a');
        }
        return (char) (eor + 97);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
        System.out.println(findTheDifference("", "y"));
    }
}
