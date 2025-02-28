package leetcode.hot100;

import java.util.*;

/**
 * @BelongsPackage: leetcode.hot100
 * @ClassName: GroupAnagrams
 * @Author: 丛虹羽
 * @Date: 2025/2/28 22:21
 * @Description: 字母异位词分组
 *
 * leetcode: https://leetcode.cn/problems/group-anagrams/?envType=study-plan-v2&envId=top-100-liked
 */
public class GroupAnagrams {

    /**
     * 单词分组
     *   想法：通过对字符串转换成字符数组进行排序，作为统一的 key 进行存储，进行值的填充替换，然后最后直接返回
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String groupKey = new String(c);
            List<String> list = map.getOrDefault(groupKey, new ArrayList<>());
            list.add(s);
            map.put(groupKey, list);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs1));
        // [[eat, tea, ate], [bat], [tan, nat]]

        String[] strs2 = {""};
        System.out.println(groupAnagrams(strs2));
        // [[]]

        String[] strs3 = {"a"};
        System.out.println(groupAnagrams(strs3));
        // [[a]]
    }
}
