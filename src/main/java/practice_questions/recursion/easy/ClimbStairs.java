package practice_questions.recursion.easy;

/**
 * @BelongsPackage: practice_questions.recursion.easy
 * @ClassName: ClimbStairs
 * @Author: 丛虹羽
 * @Date: 2024/8/15 下午11:47
 * @Description: 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * leetcode:https://leetcode.cn/problems/climbing-stairs
 */
public class ClimbStairs {

    /**
     * 使用递归解题，超时
     *
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    /**
     * 使用数组实现
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int[] arr = new int[46]; // arr[0]的位置一定要有，否则就会出现数组下标索引出现问题
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i <= 45; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        // 2

        System.out.println(climbStairs(3));
        // 3
    }
}
