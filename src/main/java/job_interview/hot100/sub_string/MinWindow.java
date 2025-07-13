package job_interview.hot100.sub_string;

/**
 * @BelongsPackage: job_interview.hot100.sub_string
 * @ClassName: MinWindow
 * @Author: 丛虹羽
 * @Date: 2025/7/13 17:06
 * @Description: 最小覆盖子串
 * https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class MinWindow {

    /**
     * 不定长滑动窗口
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        int[] cntS = new int[128];
        int[] cntT = new int[128];
        for(char c : t.toCharArray()) {
            cntT[c]++;
        }

        int m = s.length();
        int ansLeft = -1;
        int ansRight = m;
        int left = 0;
        for(int right = 0; right < m; right++) {
            cntS[s.charAt(right)]++;
            while(isCovered(cntS, cntT)) {
                if(right - left < ansRight - ansLeft) {
                    ansRight = right;
                    ansLeft = left;
                }
                cntS[s.charAt(left++)]--;
            }
        }
        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);
    }

    /**
     * 判断两个数组是否相互覆盖
     *
     * @param cntS 原始数组一
     * @param cntT 原始数组二
     * @return true | false
     */
    private static boolean isCovered(int[] cntS, int[] cntT) {
        for(int i = 'A'; i <= 'Z'; i++) {
            if(cntS[i] < cntT[i]) {
                return false;
            }
        }
        for(int i = 'a'; i <= 'z'; i++) {
            if(cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
        // BANC
    }
}
