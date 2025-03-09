package leetcode.skill.string;

/**
 * @BelongsPackage: leetcode.skill.string
 * @ClassName: Manacher
 * @Author: 丛虹羽
 * @Date: 2025/3/8 22:34
 * @Description: Manacher 求最长回文子串
 *
 * 原始串：abaaba、拓展串：#a#b#a#a#b#a#
 * 1：暴力方法找寻最长回文字串，依次向左右扩充！！
 * 2：Manacher扩展串，完全方便寻找奇数、偶数长度的回文，拓展字符可以随意设置，不影响计算！！
 * 3：拓展字符串回文半径和真实回文长度对应，真实长度 = p[i] - 1；
 * 4：拓展回文串结尾下标和真实回文串终止位置的对应，真实回文串终止位置（到不了） = 拓展回文串结尾下标 / 2；
 * 5：理解回文半径数组 p、理解回文覆盖最右边界 r、理解回文中心 c；
 * 6：Manacher算法加速过程：当来到中心点 i，如何利用 p、r、c 来进行回文扩展
 *  流程：
 *      （1）如果当前 i 位置，没有被 r 罩住的话，暴力扩。
 *      （2）如果当前 i 位置，被 r 罩住了(c <= i <= r)，使用优化技巧。
 *           [1] i 点关于 c 的 对称点的回文字符串 完全包裹在 最右回文右边界 r 关于 c 的对称点 l中 -> 此时 i 的最长回文字串的长度和 i` 的最长回文长度一样
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
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}
