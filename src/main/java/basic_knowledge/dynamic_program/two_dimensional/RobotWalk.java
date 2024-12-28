package basic_knowledge.dynamic_program.two_dimensional;

/**
 * @BelongsPackage: basic_knowledge.dynamic_programming.two_dimensional
 * @ClassName: RobotWalk
 * @Author: 丛虹羽
 * @Date: 2024/12/25 下午10:04
 * @Description: 机器人走到目标的方法数
 *
 * 假设有排成一行的 N 个位置，记为 1 ~ N，N 一定大于或等于 2，开始时机器人在其中的 M 位置上(M 一定是 1~N 中的一个)
 *      如果机器人来到 1 位置，那么下一步只能往右来到 2 位置;
 *      如果机器人来到 N 位置，那么下一步只能往左来到 N-1 位置;
 *      如果机器人来到中间位置，那么下一步可以往左走或者往右走;
 *   规定机器人必须走 K 步，最终能来到 P 位置(P 也是 1~N 中的一个)的方法有多少种给定四个参数 N、M、K、P，返回方法数。
 */
public class RobotWalk {

    /**
     * 暴力递归
     *
     * @param N     一共的格子
     * @param start 开始的位置
     * @param aim   目标的位置
     * @param k     可以走多少步
     * @return
     */
    public static int ways1(int N, int start, int aim, int k) {
        if(N < 2 || start < 1 || start > N || aim < 1 || aim > N || k < 1) {
            return -1;
        }
        return process1(start, k, aim, N);
    }

    /**
     * 暴力递归 —— 首先明确函数的返回值，然后一定确定返回的参数，以及 base case 的正确设置
     *
     * @param cur  机器人当前来到的位置 cur
     * @param rest 还有 rest 步要走
     * @param aim  目标 aim 位置
     * @param N    一共 N 个格子
     * @return     机器人从 cur 出发走了 rest 步之后到达 aim 的方法数
     */
    private static int process1(int cur, int rest, int aim, int N) {
        if(rest == 0) {
            return cur == aim ? 1 : 0;
        }
        if(cur == 1) {
            return process1(cur + 1, rest - 1, aim, N);
        }
        if(cur == N) {
            return process1(cur - 1, rest - 1, aim, N);
        }
        return process1(cur - 1, rest - 1,  aim, N) + process1(cur + 1, rest - 1, aim, N);
    }

    /**
     * 暴力递归 + 缓存表 = 记忆化搜索
     *
     * @param N     一共的格子
     * @param start 开始的位置
     * @param aim   目标的位置
     * @param k     可以走多少步
     * @return
     */
    public static int ways2(int N, int start, int aim, int k) {
        if(N < 2 || start < 1 || start > N || aim < 1 || aim > N || k < 1) {
            return -1;
        }
        int[][] dp = new int[N + 1][k + 1];
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= k; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(start, k, aim, N, dp);
    }

    /**
     * 暴力递归 + 缓存表 —— 首先明确函数的返回值，然后一定确定返回的参数,
     *      不要想着理解整个递归的全部流程，分某个特定部分进行分情况讨论，然后输出回答案！！！！
     *
     * @param cur  机器人当前来到的位置 cur
     * @param rest 还有 rest 步要走
     * @param aim  目标 aim 位置
     * @param N    一共 N 个格子
     * @return     机器人从 cur 出发走了 rest 步之后到达 aim 的方法数
     */
    private static int process2(int cur, int rest, int aim, int N, int[][] dp) {
        if(dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        int ans = 0;
        if(rest == 0) {
            ans = cur == aim ? 1 : 0;
        } else if (cur == 1) {
            ans = process2(cur + 1, rest - 1, aim, N, dp);
        } else if (cur == N) {
            ans= process2(cur - 1, rest - 1, aim, N, dp);
        } else {
            ans = process2(cur - 1, rest - 1, aim, N, dp) + process2(cur + 1, rest - 1, aim, N, dp);
        }
        dp[cur][rest] = ans;
        return ans;
    }

    /**
     * 动态规划
     *
     * @param N     一共的格子
     * @param start 开始的位置
     * @param aim   目标的位置
     * @param k     可以走多少步
     * @return
     */
    public static int ways3(int N, int start, int aim, int k) {
        if(N < 2 || start < 1 || start > N || aim < 1 || aim > N || k < 1) {
            return -1;
        }
        int[][] dp = new int[N + 1][k + 1];
        dp[aim][0] = 1;
        for(int j = 1; j <= k; j++) {
            dp[1][j] = dp[2][j - 1];
            for(int i = 2; i < N; i++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i + 1][j - 1];
            }
            dp[N][j] = dp[N - 1][j - 1];
        }
        return dp[start][k];
    }

    /**
     * 测试: 尝试策略 = 状态转移方程
     *
     * @param args
     */
    public static void main(String[] args) {
        // 暴力递归：使用自然智慧进行尝试
        System.out.println(ways1(4, 2, 4, 4));
        // 3

        // 暴力递归 + 缓存表 = 记忆化搜索 <=> 自顶向下的动态规划
        System.out.println(ways2(4, 2, 4, 4));
        // 3

        // 动态规划：按照尝试策略总结状态转移方程 <=> 自底向上
        System.out.println(ways3(4, 2, 4, 4));
        // 3
    }
}