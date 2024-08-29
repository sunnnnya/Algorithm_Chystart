package basic_knowledge.input_output;

import java.io.*;
import java.util.Scanner;

/**
 * @BelongsPackage: basic_knowledge.input_output
 * @ClassName: InputOutput
 * @Author: 丛虹羽
 * @Date: 2024/8/29 下午11:17
 * @Description: acm 模式的标准的输入输出
 */
public class InputOutput {

    // 全局静态变量的方式
    public static int MAXN = 201;

    public static int[][] mat = new int[MAXN][MAXN];

    // 全局维护，持续够用，不断的修改复制，但边界一定使用的是 n,m 否则就会出现问题
    public static int n, m;

    /**
     * 获取矩阵中的最大值
     *
     * @param arr
     * @return
     */
    public static int getMaxNumberInMatrix(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, arr[i][j]);
            }
        }
        return max;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        // 相当于依次把测试文件中的数据，一次性读到了内存托管区
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 忽略空格和回车
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            in.nextToken();
            m = (int) in.nval;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    in.nextToken();
                    mat[i][j] = (int) in.nval;
                }
            }
            System.out.println(getMaxNumberInMatrix(mat));
            // 同样使用内存托管使用
            // out.print(getMaxNumberInMatrix(mat));
        }
        out.flush();
        out.close();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main1(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = scanner.nextInt();
                }
            }
            System.out.println(getMaxNumberInMatrix(mat));
        }
    }
}