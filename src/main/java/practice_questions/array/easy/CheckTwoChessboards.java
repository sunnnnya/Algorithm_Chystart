package practice_questions.array.easy;

/**
 * @BelongsPackage: practice_questions.array.easy
 * @ClassName: CheckTwoChessboards
 * @Author: 丛虹羽
 * @Date: 2024/12/6 下午9:37
 * @Description: 检查棋盘方格颜色是否相同
 *
 * 给你两个字符串 coordinate1 和 coordinate2，代表 8 x 8 国际象棋棋盘上的两个方格的坐标。
 *
 * leetcode： https://leetcode.cn/problems/check-if-two-chessboard-squares-have-the-same-color
 */
public class CheckTwoChessboards {
    /**
     * 检查棋盘方格颜色是否相同
     *
     * @param coordinate1
     * @param coordinate2
     * @return
     */
    public static boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        return ((coordinate1.charAt(0) + coordinate1.charAt(1)) & 1) == ((coordinate2.charAt(0) + coordinate2.charAt(1)) & 1);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(checkTwoChessboards("a1", "c3"));
        // true

        System.out.println(checkTwoChessboards("a1", "h3"));
        // false

        System.out.println(checkTwoChessboards("c2", "g4"));
        // true
    }
}