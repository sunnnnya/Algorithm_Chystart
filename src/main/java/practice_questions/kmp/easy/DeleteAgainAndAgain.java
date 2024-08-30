package practice_questions.kmp.easy;

import java.io.*;

/**
 * @BelongsPackage: practice_questions.kmp.easy
 * @ClassName: DeleteAgainAndAgain
 * @Author: 丛虹羽
 * @Date: 2024/8/31 0:36
 * @Description: 循环匹配删除
 *
 * 不停删除之后剩下的字符串给定一个字符串s1，如果其中含有s2字符串，就删除最左出现的那个删除之后s1剩下的字符重新拼接在一起，
 * 再删除最左出现的那个如此周而复始，返回最终剩下的字符串测试链接 :
 *
 * luogu : https://www.luogu.com.cn/problem/P4824
 */
public class DeleteAgainAndAgain {

    public static char[] s1, s2;

    public static int MAXN = 1000001;

    public static int[] next = new int[MAXN];

    public static int[] stack1 = new int[MAXN];

    public static int[] stack2 = new int[MAXN];

    public static int r;

    /**
     * 进行计算
     *
     * @param s1
     * @param s2
     * @return
     */
    public static String computed(char[] s1, char[] s2) {
        r = 0;
        int x = 0, y = 0, n = s1.length, m = s2.length;
        getNextArray(m);
        while (x < n) {
            if (s1[x] == s2[y]) {
                stack1[r++] = x++;
                stack2[r - 1] = y++;
                if (y == m) {
                    r -= m;
                    y = (r > 0) ? stack2[r - 1] + 1 : 0;
                }
            } else {
                if (y == 0) {
                    stack1[r++] = x;
                    x++;
                } else {
                    y = next[y];
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < r; i++) {
            stringBuilder.append(s1[stack1[i]]);
        }
        return stringBuilder.toString();
    }

    /**
     * 获取 next 数组
     *
     * @param m 一定要维持固定 常数信息 ，不要位置数组 长度信息
     */
    public static void getNextArray(int m) {
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int index = 2;
        while (index < m) {
            if (s2[index - 1] == s2[cn]) {
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        System.out.println("请一次输入两个字符串：第一个字符串 大于 第二个字符串");
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            s1 = in.sval.toCharArray();
            in.nextToken();
            s2 = in.sval.toCharArray();
            // out.print(computed(s1, s2));
            System.out.println(computed(s1, s2));
            // xzbdef abc
            // xzbdef
            // xaabcbcababccabc abc
            // x
        }
        out.flush();
        out.close();
        br.close();
    }
}