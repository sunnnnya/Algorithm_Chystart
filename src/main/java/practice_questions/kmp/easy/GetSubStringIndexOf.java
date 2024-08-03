package practice_questions.kmp.easy;

/**
 * @BelongsPackage: practice_questions.kmp.easy
 * @ClassName: GetSubStringIndexOf
 * @Author: 丛虹羽
 * @Date: 2024/8/3 下午9:24
 * @Description: 找出字符串中第一个匹配项的下标
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标
 * （下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1
 *
 * leetcode: https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 *
 */
public class GetSubStringIndexOf {


    /**
     * 使用KMP算法进行加速处理
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return -1;
        }
        char[] c1 = haystack.toCharArray();
        char[] c2 = needle.toCharArray();
        int x = 0;
        int y = 0;
        int[] next = getNextArray(c2);
        while (x < c1.length && y < c2.length) {
            if (c1[x] == c2[y]) {
                x++;
                y++;
            } else if (next[y] == -1) {
                x++;
            } else {
                // 加速
                y = next[y];
            }
        }
        // 判断是不是走完了
        return y == c2.length ? x - c2.length : -1;
    }

    /**
     * 获取next数组
     *
     * @param str
     * @return
     */
    public static int[] getNextArray(char[] str) {
        if (str.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[str.length];
        next[0] = -1;
        next[1] = 0;
        int index = 2;
        int cn = 0;
        while (index < str.length) {
            if (str[index - 1] == str[cn]) {
                next[index++] = ++cn;
            } else if (cn > 0){
                cn = next[cn];
            } else {
                next[index++] = 0;
            }
        }
        return next;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "sadbutsad";
        String subStr = "sad";
        System.out.println(strStr(str, subStr));

        String str1 = "leetcode";
        String subStr1 = "leeto";
        System.out.println(strStr(str1, subStr1));
    }
}
