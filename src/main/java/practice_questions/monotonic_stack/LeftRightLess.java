package practice_questions.monotonic_stack;

import java.io.*;

/**
 * @BelongsPackage: practice_questions.monotonic_stack
 * @ClassName: Demo
 * @Author: 丛虹羽
 * @Date: 2024/8/25 上午10:37
 * @Description: 单调栈
 *
 * nowcode：https://www.nowcoder.com/practice/2a2c00e7a88a498693568cef63a4b7bb
 */
public class LeftRightLess {

    public static int MAXN = 1000001;

    public static int[] arr = new int[MAXN];

    /**
     * 技巧：数组充当栈
     */
    public static int[] stack = new int[MAXN];

    public static int[][] ans = new int[MAXN][2];

    public static int n, r;

    public static void computed() {
        r = 0;
        int cur;
        // stack中存储的是下标
        for (int i = 0; i < n; i++) {
            while(r > 0 && arr[stack[r - 1]] >= arr[i]) {
                // 栈顶元素对应的下标
                cur = stack[--r];
                ans[cur][0] = r > 0 ? stack[r - 1] : -1;
                ans[cur][1] = i;
            }
            stack[r++] = i;
        }
        while (r > 0) {
            cur = stack[--r];
            ans[cur][0] = r > 0 ? stack[r - 1] : -1;
            ans[cur][1] = -1;
        }
        // 修正阶段
        for (int i = n - 2; i >= 0; i--) {
            if (ans[i][1] != -1 && arr[ans[i][1]] == arr[i]) {
                ans[i][1] = ans[ans[i][1]][1];
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
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            computed();
            for (int i = 0; i < n; i++) {
                out.println(ans[i][0] + " " + ans[i][1]);
            }
        }
        out.flush();
        out.close();
        br.close();
    }
}
