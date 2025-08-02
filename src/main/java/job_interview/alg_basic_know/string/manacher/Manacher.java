package job_interview.alg_basic_know.string.manacher;

/**
 * @BelongsPackage: basic_knowledge.manacher
 * @ClassName: Manacher
 * @Author: 丛虹羽
 * @Date: 2025/5/15 上午11:18
 * @Description: 最长回文字串长度
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
 *                 表示：原始数组的长度信息，2#1# 表示的长度是回文半径，字符串的长度：回文半径 - 1
 *
 * https://www.bilibili.com/video/BV1YH4y1h7MU/?spm_id_from=333.337.search-card.all.click&vd_source=9eeeab41783c1ac3e2c0bb2c5060f976
 *
 * 理解 Manacher 算法的重要步骤
 *      1：暴力方法如何寻找最长回文子串
 *      2：Manacher 扩展串，可以方便的寻找奇长度、偶长度的回文，扩展字符可以随意设置，不会影响计算
 *      3：回文半径和真实回文长度的对应，真实长度 = p[i] - 1
 *      4：扩展回文串结尾下标和真实回文串终止位置的对应，真实回文串终止位置 = 扩展回文串结尾下标 / 2
 *      5：理解"回文半径数组" p、理解"回文覆盖右边界" r、理解"回文中心" c
 *      6：Manacher 算法的加速过程，当来到的中心点 i，如何利用 p、r、c 来进行回文扩展
 *          a：i 没有被 r 包住，那么以 i 为中心直接扩展
 *          b：i 被 r 包住，对称点 2 * c - i 的回文半径，在大回文区域以内：直接确定 p[i] = p[2 * c - i]
 *          c：i 被 r 包住，对称点 2 * c - i 的回文半径，在大回文区域以外：直接确定 p[i] = r - i
 *          d：i 被 r 包住，对称点 2 * c - i 的回文半径，撞线大回文区域的边界，从 r 之外的位置进行扩展
 *      7：Manacher 算法的时间复杂度 O(n)
 */
public class Manacher {

    /**
     * manacher 经典算法
     *
     * @param s 待查找最长回文字符串的字符串
     * @return
     */
    static int manacher(String s) {
        int max = 0, n = ((s.length() << 1) + 1);
        int[] p = new int[n];
        char[] ss = manacherss(s.toCharArray());
        for(int i = 0, c = 0, r = 0, len; i < n; i++) {
            len = r > i ? Math.min(p[2 * c - i], r - i) : 1;
            while(i + len < n && i - len >= 0 && ss[i + len] == ss[i - len]) {
                len++;
            }
            if(i + len > r) {
                r = i + len;
                c = i;
            }
            max = Math.max(max, len);
            p[i] = len;
        }
        return max - 1;
    }

    /**
     * [1, 2, 3, 3, 2, 1]-> [#, 1, #, 2, #, 3, #, 3, #, 2, #, 1, #]
     *
     * @param c 字符串信息
     * @return char[]
     */
    static char[] manacherss(char[] c) {
        int n = (c.length << 1) + 1;
        char[] ss = new char[(n << 1) + 1];
        for(int i = 0, j = 0; i < n; i++) {
            ss[i] = (i & 1) == 0 ? '#' : c[j++];
        }
        return ss;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "123321";
        System.out.println(manacher(str));
        // 6
    }
}
