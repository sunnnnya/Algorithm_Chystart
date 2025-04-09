package job_interview.alg_basic_know.array.double_pointer.ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.double_pointer.ext
 * @ClassName: SsSubsequence
 * @Author: 丛虹羽
 * @Date: 2025/4/9 22:55
 * @Description: 判断子序列
 * https://leetcode.cn/problems/is-subsequence/description/
 */
public class IsSubsequence {

    /**
     * 双指针，
     *
     * @param s s string
     * @param t t string
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        if(s.isEmpty()) {
            return true;
        }
        if(t.isEmpty()) {
            return false;
        }
        int lenS = s.length(), lenT = t.length(), shortIndex = 0, langIndex = 0;
        while(langIndex < lenT) {
            if(s.charAt(shortIndex) == t.charAt(langIndex)) {
                shortIndex++;
                if(shortIndex == lenS) {
                    return true;
                }
            }
            langIndex++;
        }
        return false;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "ahbgdc";
        System.out.println(isSubsequence(str1, str2));
        // true

        String str3 = "axc";
        String str4 = "ahbgdc";
        System.out.println(isSubsequence(str3, str4));
        // false

        String str5 = "";
        String str6 = "abdgsf";
        System.out.println(isSubsequence(str5, str6));
        // true
    }
}
