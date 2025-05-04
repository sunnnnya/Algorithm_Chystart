package practice_questions.monotonic_stack.medium;

/**
 * @BelongsPackage: practice_questions.monotonic_stack.medium
 * @ClassName: RemoveDuplicateLetters
 * @Author: 丛虹羽
 * @Date: 2024/8/25 下午10:26
 * @Description: 去除重复字母
 *
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * leetcode：https://leetcode.cn/problems/remove-duplicate-letters
 *
 */
public class RemoveDuplicateLetters {

    public static int MAXN = 26;

    public static int[] cnts = new int[MAXN];

    public static boolean[] enter = new boolean[MAXN];

    public static char[] stack = new char[MAXN];

    public static int r;

    /**
     * 单调栈
     *
     * @param s
     * @return
     */
    public static String removeDuplicateLetters(String s) {
        return null;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "bcabc";
        System.out.println(removeDuplicateLetters(str));
        //

        String str1 = "cbacdcbc";
        System.out.println(removeDuplicateLetters(str1));
        //
    }
}
