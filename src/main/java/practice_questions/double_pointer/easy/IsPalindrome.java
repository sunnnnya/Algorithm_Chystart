package practice_questions.double_pointer.easy;

/**
 * @BelongsPackage: practice_questions.double_pointer.easy
 * @ClassName: IsPalindrome
 * @Author: 丛虹羽
 * @Date: 2025/1/13 下午8:50
 * @Description: 回文数
 *
 * leetcode: https://leetcode.cn/problems/palindrome-number
 */
public class IsPalindrome {
    /**
     * 双指针进行比较
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome1(int x) {
        if(x < 0) {
            return false;
        }
        char[] c = String.valueOf(x).toCharArray();
        int i = 0, j = c.length - 1;
        while(i < j) {
            if(c[i] != c[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 数位反转，常用技巧
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int cur = x;
        int rev = 0;
        for(; x != 0; x /= 10) {
            rev = rev * 10 + x % 10;
        }
        return cur == rev;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        // true

        System.out.println(isPalindrome(-121));
        // false
    }
}