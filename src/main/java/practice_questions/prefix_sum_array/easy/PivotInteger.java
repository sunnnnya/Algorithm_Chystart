package practice_questions.prefix_sum_array.easy;

import java.io.*;

/**
 * @BelongsPackage: practice_questions.array.easy
 * @ClassName: PivotInteger
 * @Author: 丛虹羽
 * @Date: 2024/9/2 上午12:20
 * @Description: 找出中枢整数
 *
 * 给你一个正整数 n ，找出满足下述条件的 中枢整数 x ：
 *          1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和。
 *
 * 返回中枢整数 x 。如果不存在中枢整数，则返回 -1 。题目保证对于给定的输入，至多存在一个中枢整数。
 *
 * leetcode：https://leetcode.cn/problems/find-the-pivot-integer
 */
public class PivotInteger {

    /**
     * 敏感度：看到数组的和大小问题，首先想到是否前缀和问题
     *
     * @param n
     * @return
     */
    public static int pivotInteger(int n) {
        if (n == 1) {
            return n;
        }
        int ans = -1;
        // 前缀和的使用
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i + arr[i - 1];
        }
        for (int i = 2; i <= n; i++) {
            if (arr[i] == arr[n] - arr[i - 1]) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(bufferedReader);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int)in.nval;
            System.out.println(pivotInteger(n));
            // out.println(pivotInteger(n));
        }
        out.flush();
        out.close();
    }
}