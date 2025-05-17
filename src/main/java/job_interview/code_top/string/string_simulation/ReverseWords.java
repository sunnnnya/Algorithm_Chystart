package job_interview.code_top.string.string_simulation;

/**
 * @BelongsPackage: job_interview.code_top.string.string_simulation
 * @ClassName: ReverseWords
 * @Author: 丛虹羽
 * @Date: 2025/5/17 16:51
 * @Description: 反转字符串中的单词
 * https://leetcode.cn/problems/reverse-words-in-a-string/
 */
public class ReverseWords {

    /**
     * 字符串的反转
     *
     * @param s 字符串
     * @return String
     */
    static String reverseWords(String s) {
        s = s.trim();
        int i = s.length() - 1, j = i;
        StringBuilder sb = new StringBuilder();
        while(i >= 0) {
            for(; i >= 0 && s.charAt(i) != ' '; i--);
            sb.append(s.substring(i + 1, j + 1)).append(" ");
            for(; i >= 0 && s.charAt(i) == ' '; i--);
            j = i;
        }
        return sb.toString().trim();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "  hello world  ";
        System.out.println("Result: " + reverseWords(str));
        // Result: world hello
    }
}
