package job_interview.alg_basic_know.array.binary_search.binary_search.ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.search.binary_search.ext
 * @ClassName: IsPerfectSquare
 * @Author: 丛虹羽
 * @Date: 2025/4/5 23:01
 * @Description: 有效的完全平方数
 * https://leetcode.cn/problems/valid-perfect-square/description/
 */
public class IsPerfectSquare {

    /**
     * 标准二分转换
     *  但是要注意数据的溢出问题
     *
     * @param num 原始数组
     * @return
     */
    public static boolean isPerfectSquare(int num) {
        int l = 1, r = num;
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if((long)mid * mid == num) {
                return true;
            } else if ((long)mid * mid < num){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        // true
    }
}
