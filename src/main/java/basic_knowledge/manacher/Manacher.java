package basic_knowledge.manacher;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.manacher
 * @ClassName: Manacher
 * @Author: 丛虹羽
 * @Date: 2024/8/2 上午11:18
 * @Description: 最长回文字串
 *
 * 回文串：123321、12321
 * 求一个字符串的最长回文字串：abd123321def -> 123321
 *
 * 原始操作：
 *      12131232 -> 依次遍历 然后左右扩 03050030，但是会出现奇数可以扩充，偶数不能扩充的情况
 *
 * 改进：左边和右边加入特殊字符，然后每两个字符中间加上特殊字符
 *      121aaaa232aa -> #1#2#1#a#a#a#a#2#3#2#a#a# 同样是依次遍历，获取到长度后 / 2就是原始串的回文长度
 *      #1#2#1# -> 长度为 7，对应原始的长度是 7 / 2 = 3 -> 字符串：121
 *
 *  概念：
 *      （1）回文直径：指一个回文子串的总长度。例如：对于字符串"ababa"中的回文子串"aba"，其回文直径为3。
 *      （2）回文半径：指从回文中心向两侧扩展的长度。它等于回文直径除以2（对于奇数长度的回文，向下取整）。例如，对于回文子串"aba"，其回文半径为1。
 *      （3）回文半径数组arr：回文半径数组是一个与原字符串等长的数组，其中每个元素表示以该位置为中心的最长回文子串的回文半径。这个数组可以用来快速查找所有的回文子串。
 *      （4）最右回文右边界r：最右回文右边界是指当前已经确定的所有回文子串中，最靠右的边界位置。
 *      （5）最右回文右边界中心位置c：这是指对应着第一次到达最右回文右边界的回文子串的中心位置。
 *  流程：
 *      （1）如果当前 i 位置，没有被 R 罩住的话，暴力扩。
 *      （2）如果当前 i 位置，被 R 罩住了(c <= i <= r)，使用优化技巧。
 *           [1] i 点关于 c 的 对称点的回文字符串 完全包裹在 最右回文有边界 r 关于 c 的对称点 l中 -> 此时 i 的最长回文字串的长度和 i` 的最长回文长度一样
 *              [a b { c d c } k s t s k c d c b a] z
 *              l        i`        c       i        r
 *           [2] i 点关于 c 的对称点的回文字符串 出现在 l 的外面去了 -> i 到 r表示的就是 i的回文半径
 *              {a b [c d e d c b a} t s t a b c d e d c] f
 *                   l    i`           c           i      r
 *           [3] i 点关于 c 的对称点的回文字符串的左边界 和 l重合 -> 只会 i 的回文半径 >= i`的回文半径
 *              x [{a b c b a} s t s a b c b a] s
 *                  l   i`       c       i      r
 */
public class Manacher {

    /**
     * manacher 经典算法
     *
     * @param s 待查找最长回文字符串的字符串
     * @return
     */
    public static int manacher(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 123321 -> [#, 1, #, 2, #, 3, #, 3, #, 2, #, 1, #]
        char[] str = manacherString(s);
        // 回文半径的大小，和字符串的长度对应，最后的回文半径数组中的最大值 / 2 就是最长回文字串
        int[] pArr = new int[str.length];
        // 中心点
        int C = -1;
        // 最右的扩成功的位置的，再下一个位置
        int R = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length; i++) {
            // R > i 表示 i 在最长回文右边界内部
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            // 更新 R 和 C
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            // 记录最大的回文半径值
            max = Math.max(max, pArr[i]);
        }
        // 返回原始串的最大回文字串的长度
        return max - 1;
    }

    /**
     * 对字符串进行处理，123321 -> [#, 1, #, 2, #, 3, #, 3, #, 2, #, 1, #]
     *
     * @param str
     * @return
     */
    private static char[] manacherString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#");
        for (Character c : str.toCharArray()) {
            stringBuilder.append(c + "#");
        }
        return stringBuilder.toString().toCharArray();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // init manacher string
        String str = "123321";
        System.out.println(Arrays.toString(manacherString(str)));
        // [#, 1, #, 2, #, 3, #, 3, #, 2, #, 1, #]

        System.out.println(manacher(str));
        // 6
    }
}
