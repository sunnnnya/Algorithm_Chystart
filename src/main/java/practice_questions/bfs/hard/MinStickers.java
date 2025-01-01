package practice_questions.bfs.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @BelongsPackage: practice_questions.bfs.hard
 * @ClassName: MinStickers
 * @Author: 丛虹羽
 * @Date: 2025/1/1 下午9:39
 * @Description: 贴纸拼词
 *
 * leetcode: https://leetcode.cn/problems/stickers-to-spell-word/description/
 */
public class MinStickers {

    public static int MAXN = 401;

    public static String[] queue = new String[MAXN];

    public static int l, r;

    // index 0 -> a
    // index 1 -> b
    // index 2 -> c
    // ...
    public static ArrayList<ArrayList<String>> graph = new ArrayList<>();

    public static HashSet<String> vis = new HashSet<>();

    static {
        for(int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }
    }

    /**
     * bfs + 剪枝
     *
     * @param stickers  贴纸数组
     * @param target    目标字符串
     * @return
     */
    public static int minStickers(String[] stickers, String target) {
        for(int i = 0; i < 26; i++) {
            graph.get(i).clear();
        }
        vis.clear();
        for(String str : stickers) {
            str = sort(str);
            for(int i = 0; i < str.length(); i++) {
                if(i == 0 || str.charAt(i) != str.charAt(i - 1)) {
                    graph.get(str.charAt(i) - 'a').add(str);
                }
            }
        }
        target = sort(target);
        vis.add(target);
        l = r = 0;
        queue[r++] = target;
        int level = 1;
        while(l < r) {
            int size = r - l;
            for(int i = 0; i < size; i++) {
                String cur = queue[l++];
                for(String s : graph.get(cur.charAt(0) - 'a')) {
                    String next = next(cur, s);
                    if(next.isEmpty()) {
                        return level;
                    } else if(!vis.contains(next)) {
                        vis.add(next);
                        queue[r++] = next;
                    }
                }
            }
            level++;
        }
        return -1;
    }

    /**
     * 对字符串进行排序
     *
     * @param s 原始字符串 -> 字符数组 -> 排序 -> 转换成字符串
     * @return  排序后的字符串
     */
    private static String sort(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }

    /**
     * target 中 去除掉 pattern 中存在的字符
     *
     * @param target  目标字符串
     * @param pattern 模式字符串
     * @return
     */
    private static String next(String target, String pattern) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0, j = 0; i < target.length();) {
            if(j == pattern.length()) {
                stringBuilder.append(target.charAt(i++));
            } else {
                if(target.charAt(i) < pattern.charAt(j)) {
                    stringBuilder.append(target.charAt(i++));
                } else if (target.charAt(i) > pattern.charAt(j)) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] stickers = new String[]{"with", "example", "science"};
        String target = "thehat";
        System.out.println(minStickers(stickers, target));
        // 3
    }
}
