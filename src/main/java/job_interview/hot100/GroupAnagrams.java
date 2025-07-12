package job_interview.hot100;

import java.util.*;

/**
 * @BelongsPackage: job_interview.hot100
 * @ClassName: GroupAnagrams
 * @Author: 丛虹羽
 * @Date: 2025/7/12 21:21
 * @Description: 字母异位词分组
 * https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class GroupAnagrams {

    /**
     * 使用 HashMap 进行统计计算，以排序之后的字符串作为 key
     *
     * @param strs 字符串数组
     * @return 统计列表
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String groupString = new String(c);
            List<String> list = mp.getOrDefault(groupString, new ArrayList<>());
            list.add(s);
            mp.put(groupString, list);
        }
        return new ArrayList<>(mp.values());
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] ss = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(ss);
        System.out.println("lists = " + lists);
        // lists = [[eat, tea, ate], [bat], [tan, nat]]
    }
}
