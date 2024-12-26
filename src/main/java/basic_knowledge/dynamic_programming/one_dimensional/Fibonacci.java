package basic_knowledge.dynamic_programming.one_dimensional;

/**
 * @BelongsPackage: basic_knowledge.dynamic_programming.one_dimensional
 * @ClassName: Fibonacci
 * @Author: 丛虹羽
 * @Date: 2024/12/25 下午9:53
 * @Description: 一维动态规划 - 斐波那契数列
 */
public class Fibonacci {

    /**
     * 使用递归的方式实现
     *
     * @param n 待求解的第 n 个数
     * @return
     */
    public static int fib(int n) {
        if(n == 1 || n == 2){
            return 1;
        }
        return fib(n) + fib(n - 1);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}
