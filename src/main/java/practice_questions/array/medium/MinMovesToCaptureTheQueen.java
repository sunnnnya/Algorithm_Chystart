package practice_questions.array.medium;

/**
 * @BelongsPackage: practice_questions.array.medium
 * @ClassName: MinMovesToCaptureTheQueen
 * @Author: 丛虹羽
 * @Date: 2024/12/6 下午4:17
 * @Description: 捕获黑皇后需要的最少移动次数
 *
 * leetcode: https://leetcode.cn/problems/minimum-moves-to-capture-the-queen
 */
public class MinMovesToCaptureTheQueen {

    /**
     * 分类讨论
     * (a, b) 表示白色车的位置。
     * (c, d) 表示白色象的位置。
     * (e, f) 表示黑皇后的位置。
     * @return
     */
    public static int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        if ((a == e && (c != e || !isBetween(b, d, f))) || // row
            (b == f && (d != f || !isBetween(a, c, e))) || // column
            (c + d == e + f && (a + b != e + f || !isBetween(d, b, f))) || // /
            (c - d == e - f && (a - b != e - f || !isBetween(c, a, e)))) { // \
            return 1;
        }
        return 2;
    }

    /**
     * 判断一个坐标是否再 l 到 r 中间
     * @param l  坐标1
     * @param m  坐标2
     * @param r  坐标3
     * @return   true | false
     */
    private static boolean isBetween(int l, int m, int r) {
        return Math.min(l, r) < m && m < Math.max(l, r);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int a = 5, b = 3, c = 3, d = 4, e = 5, f = 2;
        System.out.println(minMovesToCaptureTheQueen(a, b, c, d, e, f));
        // 1

        int a1 = 1, b1 = 1, c1 = 8, d1 = 8, e1 = 2, f1 = 3;
        System.out.println(minMovesToCaptureTheQueen(a1, b1, c1, d1, e1, f1));
        // 2
    }
}