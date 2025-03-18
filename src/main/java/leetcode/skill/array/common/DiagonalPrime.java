package leetcode.skill.array.common;

/**
 * @package: leetcode.skill.array.common
 * @author: chystart
 * @create: 2025-03-18 14:31
 * @description: 对角线上的质数
 *
 * leetcode: https://leetcode.cn/problems/prime-in-diagonal/description/?envType=daily-question&envId=2025-03-18
 **/
public class DiagonalPrime {

    /**
     * 坐标规律
     * 
     * @param nums 原始数组
     * @return     最大对角线数值
     */
    public static int diagonalPrime(int[][] nums) {
        int ans = 0, n = nums.length;
        for(int i = 0; i < n; i++) {
            int x = nums[i][i];
            // 耗时的任务放在逻辑操作符的右边
            if(x > ans && isPrime(x)) {
                ans = x;
            }
            x = nums[i][n - 1 - i];
            if(x > ans && isPrime(x)) {
                ans = x;
            }
        }
        return ans;
    }

    /**
     * 质数直接筛一半就可以了
     *
     * @param num 数值
     * @return 返回是否是质数
     */
    public static boolean isPrime(int num) {
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return num >= 2;
    }

    /**
     * 测试
     * 
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3}, {5, 7, 7}, {9, 11, 10}};
        System.out.println("Result: " + diagonalPrime(arr));
    }
}
