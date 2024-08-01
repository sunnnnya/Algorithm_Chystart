package basic_knowledge.kmp;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.kmp
 * @ClassName: KMP
 * @Author: 丛虹羽
 * @Date: 2024/8/1 下午10:39
 * @Description: kmp字符串匹配算法
 *
 * 非常重要！！！！！！！！！！
 */
public class KMP {

    /**
     * 获取 s1 字符串中 s2 字符串的索引位置
     *
     * @param s1  母字符串
     * @param s2  子字符串
     * @return 母字符串中子字符串的索引的位置
     */
    public static int getIndexOf(String s1, String s2) {
        if(s1 == null || s2 == null || s2.length() < 1 || s2.length() > s1.length()) {
            return -1;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        // s1 index
        int x = 0;
        // s2 index
        int y = 0;
        int[] next = getNextArray(str2);
        while (x < str1.length && y < str1.length) {
            if (str1[x] == str2[y]) {
                x++;
                y++;
            } else if (next[y] == -1) {
                // x 字符串移动++从开头匹配y
                x++;
            } else {
                y = next[y];
            }
        }
        // y 已经过了一边了，出现y越界的情况
        return y == str2.length ? x - y : -1;
    }

    /**
     * 获取字符串对应的next数组做加速
     *
     * 需要求的是 最长前缀匹配
     * @param str2
     * @return
     */
    private static int[] getNextArray(char[] str2) {
        if(str2.length == 1) {
            return new int[]{-1};
        }
        // 只能长度 >= 2的才会到达此位置，故next[0]、next[1]初始化
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        // 目前在哪个位置求next数组值
        int index = 2;
        // 哪个位置的字符和 index - 1的位置比较
        int cn = 0;
        while(index < next.length) {
            if (str2[index - 1] == str2[cn]) {
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
        String str1 = "acdbstacdtxeacdbstacdbk";
        String str2 = "acdbstacdbk";
        System.out.println(Arrays.toString(getNextArray(str2.toCharArray())));
        System.out.println(getIndexOf(str1, str2));
    }
}
