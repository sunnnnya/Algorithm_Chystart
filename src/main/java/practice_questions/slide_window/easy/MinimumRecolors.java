package practice_questions.slide_window.easy;

/**
 * @BelongsPackage: practice_questions.slide_window.easy
 * @ClassName: MinimumRecolors
 * @Author: 丛虹羽
 * @Date: 2024/12/7 下午11:42
 * @Description: 得到 K 个黑块的最少涂色次数
 *
 * 一个长度为 n 下标从 0 开始的字符串 blocks ，blocks[i] 要么是 'W' 要么是 'B' ，表示第 i 块的颜色。字符 'W' 和 'B' 分别表示白色和黑色。
 * 一个整数 k ，表示想要连续黑色块的数目。每次操作，可以选择一个白色块将它涂成黑色块。请你返回至少出现一次连续 k 个黑色块的最少操作次数。
 *
 * leetcode：https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks
 */
public class MinimumRecolors {

    /**
     * 字符串数组
     *
     * @param blocks 字符串
     * @param k      窗口的宽度
     * @return
     */
    public static int minimumRecolors(String blocks, int k) {
        int min = Integer.MAX_VALUE, w = 0;
        char[] c = blocks.toCharArray();
        for(int i = 0; i < c.length; i++) {
            if(c[i] == 'W') {
                w++;
            }
            if(i < k - 1) {
                continue;
            }
            min = Math.min(min, w);
            if(c[i - k + 1] == 'W') {
                w--;
            }
        }
        return min;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBBWWBBWBW", 7));
        // 3

        System.out.println(minimumRecolors("WBWBBBW", 2));
        // 0
    }
}