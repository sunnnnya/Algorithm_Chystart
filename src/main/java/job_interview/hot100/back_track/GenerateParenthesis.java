package job_interview.hot100.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: job_interview.hot100.back_track
 * @ClassName: GenerateParenthesis
 * @Author: 丛虹羽
 * @Date: 2025/7/26 21:59
 * @Description:  括号生成
 * https://leetcode.cn/problems/generate-parentheses/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class GenerateParenthesis {

    /**
     * 使用记录路径进行处理
     *
     * @param n 括号的长度
     * @return List<String>
     */
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] path = new char[2 * n];
        dfs(0, 0, n, path, ans);
        return ans;
    }

    /**
     * 使用深度优先搜索算法实现
     *
     * @param left 左括号的数量
     * @param right 右括号的数量
     * @param n 括号的个数
     * @param path 路径记录
     * @param ans 答案
     */
    private static void dfs(int left, int right, int n, char[] path, List<String> ans) {
        if(right == n) {
            ans.add(new String(path));
            return ;
        }
        if(left < n) {
            path[left + right] = '(';
            dfs(left + 1, right, n, path, ans);
        }
        if(right < left) {
            path[right + left] = ')';
            dfs(left, right + 1, n , path, ans);
        }
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
        // [((())), (()()), (())(), ()(()), ()()()]
    }
}
