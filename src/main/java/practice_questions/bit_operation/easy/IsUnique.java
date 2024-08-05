package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: IsUnique
 * @Author: 丛虹羽
 * @Date: 2024/8/5 下午4:47
 * @Description: 判定字符是否唯一
 *
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * leetcode:https://leetcode.cn/problems/is-unique-lcci/description/
 */
public class IsUnique {

    /**
     * 思路使用ans进行状态信息记录，ans |= (1 << X)表示 1 左移动偏移量个单位，并且进行累加
     *
     * @param astr
     * @return
     */
    public static boolean isUnique(String astr) {
        if (astr.length() < 2) {
            return true;
        }
        for(int i = 0, ans = 0; i < astr.length(); i++) {
            if ((ans & (1 << (astr.charAt(i) - 'a'))) > 0) {
                return false;
            }
            ans |= (1 << astr.charAt(i) - 'a');
        }
        return true;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(isUnique(str));
        // false

        String str1 = "abc";
        System.out.println(isUnique(str1));
        // true
    }
}
