package practice_questions.kmp.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.kmp
 * @ClassName: RotatedString
 * @Author: 丛虹羽
 * @Date: 2024/8/2 下午3:29
 * @Description: 旋转字符串：原始字符串 和 旋转串 互为旋转串
 * 原始字符串    旋转串
 * 12345   ->   12345
 * 12345   ->   23451
 * 12345   ->   34512
 * 12345   ->   45123
 *
 * 123456 <=>  456123
 * 123456 !<=> 465123
 *
 * 问题：判断两个串str1、str2互不互为旋转串？？
 * 方案：str1 -> str1 + str1，然后找拼接后的str1中是否包含字串 str2
 */
public class RotatedString {

    /**
     * kmp 查找字符串的中的字串index 位置，找不到就返回-1
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int kmp(String str1, String str2) {
        if (str2 == null || str1 == null) {
            return -1;
        }
        String oriStr = str1 + str1;
        char[] s1 = oriStr.toCharArray();
        char[] s2 = str2.toCharArray();
        int[] next = getNextArray(s2);
        int x = 0;
        int y = 0;
        while (x < s1.length && y < s2.length) {
            if (s1[x] == s2[y]) {
                x++;
                y++;
            } else if (next[y] == -1) { // 说明子字串已经重置为从开始节点比较了
                x++;
                // 为什么此时x需要移动呢?
                // 因为当上一步y = next[y] -> y == 0时，重新while循环，已经比较完了x = ? 和 y = 0 的值才会走入到当前条件分支中，所以x直接++
            } else {
                y = next[y];
            }
        }
        // y 走到最后就是数组的长度
        return y == s2.length ? x - y : -1;
    }

    /**
     * kmp关键技术，next数组
     *
     * @param s2
     * @return
     */
    private static int[] getNextArray(char[] s2) {
        if(s2.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[s2.length];
        next[0] = -1;
        next[1] = 0;
        int index = 2;
        int cn = 0;
        while (index < s2.length) {
            if (s2[index - 1] == s2[cn]) {
                next[index++] = ++cn;
            } else if (cn > 0) {
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
        // 原始串
        String str1 = "123456";
        // 正确的旋转串
        String str2 = "456123";
        String str3 = "561234";
        // 不正确的旋转串
        String str4 = "465123";
        // 测试next数组
        System.out.println(Arrays.toString(getNextArray("aabaacad".toCharArray())));
        // [-1, 0, 1, 0, 1, 2, 0, 1]

        System.out.println(kmp(str1, str2) == -1 ? str2 + "不是" + str1 + "的旋转串！！" : str2 + "是" + str1 + "的旋转串~~");
        // 456123是123456的旋转串~~
        System.out.println(kmp(str1, str3) == -1 ? str3 + "不是" + str1 + "的旋转串！！" : str3 + "是" + str1 + "的旋转串~~");
        // 561234是123456的旋转串~~
        System.out.println(kmp(str1, str4) == -1 ? str4 + "不是" + str1 + "的旋转串！！" : str4 + "是" + str1 + "的旋转串~~");
        // 465123不是123456的旋转串！！
    }
}
