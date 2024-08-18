package basic_knowledge.greedy;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.greedy
 * @ClassName: Demo
 * @Author: 丛虹羽
 * @Date: 2024/8/18 下午9:08
 * @Description: 贪心的典型题目
 *
 * 说明：给定一个由字符串组成的数组 strs 必须把所有的字符串拼接起来，返回所有可能的拼接结果中，字典序最小的结果；
 *
 * 策略猜想：
 *      （1）按照字符串的字典序进行排序，字典序小的放在前面；if (a字典序 < b字典序) a 放前
 *          反例：["b", "ba"] -> 按照最小的字典序放在前面的结果是："bba"， 但实际的字典序最小的是："bab" 最小；
 *      （2）按照拼接之后的字符串进行字典序的排序；if(a拼接b < b拼接a) a 放前
 */
public class LowestString {

    /**
     * 字符串数组返回最小字典序的字符串信息
     *
     * @param str
     * @return
     */
    public static String lowestString(String[] str) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.sort(str, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        for (String s : str) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] strs = new String[]{"b", "ba"};
        System.out.println(lowestString(strs));
        // bab
    }
}
