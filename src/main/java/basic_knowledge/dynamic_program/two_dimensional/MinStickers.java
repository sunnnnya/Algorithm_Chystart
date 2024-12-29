package basic_knowledge.dynamic_program.two_dimensional;

/**
 * @package: basic_knowledge.dynamic_program.two_dimensional
 * @author: chystart
 * @create: 2024-12-29 16:13
 * @description: 贴纸拼词
 *
 *  给定一个字符串 str，给定一个字符串类型的数组 arr，出现的字符都是小写英文；
 *  arr 每一个字符串，代表一张贴纸，你可以把单个字符剪开使用，目的是拼出 str；
 *  返回需要至少多少张贴纸可以完成这个任务。
 *
 *  例子: str= "babac", arr = {"ba","ci,"abcd"}
 *      至少需要两张贴纸 "ba" 和"abcd"，因为使用这两张贴纸，把每一个字符单独剪开，
 *      含有 2 个 a、2 个 b、1 个 c。是可以拼出 str 的。所以返回 2。、
 *
 * leetcode: https://leetcode.cn/problems/stickers-to-spell-word
 **/
public class MinStickers {

    /**
     * 暴力递归
     *
     * @param stickers  贴纸数组
     * @param target    目标字符串
     * @return
     */
    public static int minStickers(String[] stickers, String target) {
        int ans = process(stickers, target);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     * 暴力递归的尝试策略
     *
     * @param stickers  贴纸数组
     * @param target    目标字符串
     * @return
     */
    public static int process(String[] stickers, String target) {
        // target 不断变小，当 target 没有字符时，不再需要贴纸，返回 0 张
        if(target.isEmpty()) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(String first : stickers) {
            String rest = minus(target, first);
            if(rest.length() != target.length()) {
                min = Math.min(min, process(stickers, rest));
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    /**
     * 计算使用 s2 贴纸后剩余需要的字符
     *
     * @param s1
     * @param s2
     * @return
     */
    public static String minus(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[] count = new int[26];
        for(char cha : str1) {
            count[cha - 'a']++;
        }
        for(char cha : str2) {
            count[cha - 'a']--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(count[i] > 0) {
                for(int num = 0; num < count[i]; num++) {
                    stringBuilder.append((char) (i + 'a'));
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 暴力递归 - 使用词频表替换 原始字符串数组
     *
     * @param stickers  贴纸数组
     * @param target    目标字符串
     * @return
     */
    public static int minStickers2(String[] stickers, String target) {
        int N = stickers.length;
        // 关键优化(用词频表替代贴纸数组)
        int[][] counts = new int[N][26];
        for(int i = 0; i < N; i++) {
            char[] str = stickers[i].toCharArray();
            for (char cha : str) {
                counts[i][cha - 'a']++;
            }
        }
        int ans = process2(counts, target);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     * 优化
     *
     * @param stickers
     * @param t
     * @return
     */
    public static int process2(int[][] stickers, String t) {
        if (t.isEmpty()) {
            return 0;
        }
        char[] target = t.toCharArray();
        int[] tcounts = new int[26];
        for (char cha : target) {
            tcounts[cha - 'a']++;
        }
        int N = stickers.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            // 最关键的优化(重要的剪枝！！这一步也是贪心！！)
            int[] sticker = stickers[i];
            if (sticker[target[0] - 'a'] > 0) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    if (tcounts[j] > 0) {
                        int nums = tcounts[j] - sticker[j];
                        for (int k = 0; k < nums; k++) {
                            builder.append((char) (j + 'a'));
                        }
                    }
                }
                String rest = builder.toString();
                min = Math.min(min, process2(stickers, rest));
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 测试用例 1：简单测试
        String[] stickers1 = {"with", "example", "science"};
        String target1 = "thehat";
        System.out.println(minStickers2(stickers1, target1)); // 预期输出：3

        // 测试用例 2：目标字符串无法完成
        String[] stickers2 = {"a", "b", "c"};
        String target2 = "z";
        System.out.println(minStickers2(stickers2, target2)); // 预期输出：-1

        // 测试用例 3：目标字符串为空
        String[] stickers3 = {"hello", "world"};
        String target3 = "";
        System.out.println(minStickers2(stickers3, target3)); // 预期输出：0

        // 测试用例 4：贴纸中包含目标字符串的所有字符
        String[] stickers4 = {"abc", "def"};
        String target4 = "fed";
        System.out.println(minStickers2(stickers4, target4)); // 预期输出：1

        // 测试用例 5：复杂目标字符串
        String[] stickers5 = {"these", "guess", "about", "garden", "him"};
        String target5 = "atom";
        System.out.println(minStickers2(stickers5, target5)); // 预期输出：3

        // 测试用例 6：目标字符串与贴纸完全匹配
        String[] stickers6 = {"target"};
        String target6 = "target";
        System.out.println(minStickers2(stickers6, target6)); // 预期输出：1
    }
}