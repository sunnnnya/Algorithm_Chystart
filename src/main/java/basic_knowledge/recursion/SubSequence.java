package basic_knowledge.recursion;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @BelongsPackage: basic_knowledge.recursion
 * @ClassName: GetSubStr
 * @Author: 丛虹羽
 * @Date: 2024/12/25 下午20:06
 * @Description: 给定一个字符串寻找字符串中的所有子集
 * 例如：abc字符串：
 *                    a
 *                √/       \x
 *                b         b
 *             √/  \x     √/  \x
 *            c     c     c    c
 *          √/ \x √/ \x √/ \x √/ \x
 *        abc  ab ac  a bc  b c  ""
 */
public class SubSequence {

    /**
     * 求一个字符串的所有子集
     *
     * @param s     字符数组
     * @param index 当前索引位置
     * @param path  记录的路径
     * @param set   去重后的答案
     */
    public static void process(char[] s, int index, StringBuilder path, HashSet<String> set) {
        if(index == s.length) {
            set.add(path.toString());
        } else {
            path.append(s[index]);
            process(s, index + 1, path, set);
            path.deleteCharAt(path.length() - 1);
            process(s, index + 1, path, set);
        }
    }

    /**
     * 返回字符串的子串信息
     *
     * @param str
     * @return
     */
    public static String[] subSequence(String str) {
        char[] charArray = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        HashSet<String> strings = new HashSet<>();
        process(charArray, 0, stringBuilder, strings);
        // set 集合转换成数组
        String[] strs = new String[strings.size()];
        int index = 0;
        for (String s : strings) {
            strs[index++] = s;
        }
        return strs;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(subSequence("abc")));
        // [, ab, a, bc, ac, b, abc, c]
    }
}