package practice_questions.array.easy;

import java.util.HashSet;

/**
 * @BelongsPackage: practice_questions.array.easy
 * @ClassName: UniqueMorseRepresentations
 * @Author: 丛虹羽
 * @Date: 2024/8/26 下午9:44
 * @Description: 唯一摩尔斯密码词
 *
 * https://leetcode.cn/problems/unique-morse-code-words
 */
public class UniqueMorseRepresentations {

    /**
     * 词频统计 + 哈希表 O(n2)
     *
     * @return
     */
    public static int uniqueMorseRepresentations(String[] words) {
        String[] str = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for (String s : words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                stringBuilder.append(str[s.charAt(i) - 'a']);
            }
            set.add(stringBuilder.toString());
        }
        return set.size();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] arr = new String[]{"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(arr));
        // 2

        String[] arr1 = new String[]{"a"};
        System.out.println(uniqueMorseRepresentations(arr1));
        // 1
    }
}
