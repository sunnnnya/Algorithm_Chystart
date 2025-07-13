package job_interview.hot100.skill;

/**
 * @BelongsPackage: job_interview.hot100.skill
 * @ClassName: SingleNumber
 * @Author: 丛虹羽
 * @Date: 2025/7/13 08:53
 * @Description: 只出现一次的数字
 * https://leetcode.cn/problems/single-number/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class SingleNumber {

    /**
     * 异或运算符号的使用:
     *  N ^ N = 0 | 0 ^ N = N
     *
     * @param nums 原始数组
     * @return
     */
    public static int singleNumber(int[] nums) {
        int eor = 0;
        for(int num : nums) {
            eor ^= num;
        }
        return eor;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(arr));
        // 4
    }
}
