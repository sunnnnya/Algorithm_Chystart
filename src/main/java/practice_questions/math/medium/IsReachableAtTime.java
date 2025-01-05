package practice_questions.math.medium;

/**
 * @BelongsPackage: practice_questions.math.medium
 * @ClassName: IsReachableAtTime
 * @Author: 丛虹羽
 * @Date: 2025/1/4 下午10:20
 * @Description: 判断能否在给定时间到达单元格
 *
 * leetcode: https://leetcode.cn/problems/determine-if-a-cell-is-reachable-at-a-given-time
 */
public class IsReachableAtTime {

    /**
     * 根据数据量猜解法，10 ^ 9 说明一定是数学公式解决的问题，因为会出现 TLE 的限制是 10 ^ 8，所以一定使用公式方法进行求解
     * 求从一个点到一个点可以距离：曼哈顿记录
     *
     * @param sx 起始点 x
     * @param sy 起始点 y
     * @param fx 终止点 x
     * @param fy 终止点 y
     * @param t  允许的步数
     * @return
     */
    public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy) {
            return t != 1;
        }
        return Math.max(Math.abs(sx - fx), Math.abs(sy - fy)) <= t;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int sx = 2, sy = 4, fx = 7, fy = 7, t = 6;
        System.out.println(isReachableAtTime(sx, sy, fx, fy, t));
        // true
    }
}