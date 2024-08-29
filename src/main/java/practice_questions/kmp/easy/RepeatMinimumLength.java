package practice_questions.kmp.easy;

import java.io.*;

/**
 * @BelongsPackage: practice_questions.kmp.easy
 * @ClassName: Demo
 * @Author: 丛虹羽
 * @Date: 2024/8/29 下午9:11
 * @Description: 最短循环节得长度
 *
 * 最短循环节的长度给你一个字符串s，它一定是由某个循环节不断自我连接形成的题目，保证至少重复2次，但是最后一个循环节不一定完整。
 * 现在想知道s的最短循环节是多长？
 *
 * luogu：https://www.luogu.com.cn/problem/P4391
 *
 * 结论：
 *      abcabcabca：最长的公共前后缀的长度是：abcabca
 *      故最短循环节长度 <=> 字符串的长度 - 最长的公共前后缀长度 ：10 - 7 = 3；
 */
public class RepeatMinimumLength {

    public static int MAXN = 1000001;

    public static int[] next = new int[MAXN];

    public static int n;

    public static char[] s;

    /**
     * 计算最短的循环节长度
     *
     * @return
     */
    public static int computed() {
        getNextArray();
        return n - next[n];
    }

    /**
     * kmp中获取next数组的作用
     */
    public static void getNextArray() {
        next[0] = -1;
        next[1] = 0;
        int index = 2, cn = 0;
        while (index <= n) {
            if (s[index - 1] == s[cn]) {
                next[index++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[index++] = 0;
            }
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(in.readLine());
        s = in.readLine().toCharArray();
        out.println(computed());
        out.flush();
        out.close();
        in.close();
    }
}
