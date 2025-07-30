package job_interview.hot100.greed;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: job_interview.hot100.greed
 * @ClassName: PartitionLabels
 * @Author: 丛虹羽
 * @Date: 2025/7/30 16:45
 * @Description: 划分字母区间
 * https://leetcode.cn/problems/partition-labels/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class PartitionLabels {

    /**
     * 贪心算法记录右边界统计
     *
     * @param S 字符串 String
     * @return List<Integer>
     */
    public static List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        int n = S.length();
        int[] last = new int[n];
        char[] c = S.toCharArray();
        for(int i = 0; i < n; i++) {
            last[c[i] - 'a'] = i;
        }
        int start = 0, end = 0;
        for(int i = 0; i < n; i++) {
            end = Math.max(end, last[c[i] - 'a']);
            if(i == end) {
                ans.add(end - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(str));
        // [9, 7, 8]
    }
}
