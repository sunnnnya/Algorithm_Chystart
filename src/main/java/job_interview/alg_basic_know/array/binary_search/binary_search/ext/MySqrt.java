package job_interview.alg_basic_know.array.binary_search.binary_search.ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.search.binary_search.ext
 * @ClassName: MySqrt
 * @Author: 丛虹羽
 * @Date: 2025/4/2 17:02
 * @Description: x 的平方根
 * https://leetcode.cn/problems/sqrtx/description/
 */
public class MySqrt {

    /**
     * 二分搜索：
     *   <= target 最右
     *
     * @param x 数值
     * @return
     */
    public static int mySqrt(int x) {
        int l = 0;
        int r = x;
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if((long)mid * mid > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(mySqrt(8));
        // 2
    }
}
