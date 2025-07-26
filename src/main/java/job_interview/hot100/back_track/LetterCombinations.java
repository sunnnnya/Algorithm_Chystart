package job_interview.hot100.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: job_interview.hot100.back_track
 * @ClassName: LetterCombinations
 * @Author: 丛虹羽
 * @Date: 2025/7/26 20:58
 * @Description: 电话号码的字母组合
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?envType=study-plan-v2&envId=top-100-liked
 */
public class LetterCombinations {

    private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * 字母的组合处理
     *
     * @param digits 原始数组
     * @return List<String>
     */
    public static List<String> letterCombinations(String digits) {
        int n = digits.length();
        if(n == 0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        char[] path = new char[n];
        dfs(0, ans, path, digits.toCharArray());
        return ans;
    }

    /**
     * 递归进行处理
     *
     * @param pos  位置
     * @param ans  结果
     * @param path 路径
     * @param nums 原始数组
     */
    private static void dfs(int pos, List<String> ans, char[] path, char[] nums) {
        if(pos == nums.length) {
            ans.add(new String(path));
            return;
        }
        for(char c : MAPPING[nums[pos] - '0'].toCharArray()) {
            // 会直接进行覆盖的
            path[pos] = c;
            dfs(pos + 1, ans, path, nums);
        }
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
        // [ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}
