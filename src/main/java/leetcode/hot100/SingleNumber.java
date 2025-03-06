package leetcode.hot100;

/**
 * @BelongsPackage: leetcode.hot100
 * @ClassName: SingleNumber
 * @Author: 丛虹羽
 * @Date: 2025/3/3 22:55
 * @Description: 只出现一次的数字
 *
 * leetcode: https://leetcode.cn/problems/single-number/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class SingleNumber {

    /**
     * 异或技巧：
     *  0 ^ N = N
     *  N ^ N = 0
     *
     * @param nums 原始数组
     * @return
     */
    public static int singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums) {
            xor ^= num;
        }
        return xor;
    }

    /**
     * 测试
     * 
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2,2,1};
        System.out.println(singleNumber(arr));
        // 1

        int[] arr1 = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(arr1));
        // 4

        int[] arr2 = new int[]{2};
        System.out.println(singleNumber(arr2));
        // 2
    }
}
