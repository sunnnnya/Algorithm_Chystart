package basic_knowledge.random.easy;

/**
 * @BelongsPackage: basic_knowledge.random.easy
 * @ClassName: RandomBecomesNonRandom
 * @Author: 丛虹羽
 * @Date: 2024/7/26 下午4:14
 * @Description:
 * 非等概率返回等概率
 * f() 0  1
 *     p 1-p
 */
public class UnequalProbabilitiesReturnEqualProbabilities {

    /**
     * 不等概率返回 0 或 1
     * @return
     */
    public static int x() {
        return Math.random() < 0.854 ? 0 : 1;
    }

    /**
     * 排除了p * p 和 1 - p * 1 * p，不等概率
     * p * 1 - p、 1 - p * p等概率
     * 等概率返回 0和1
     *
     * @return
     */
    public static int f() {
        int ans = 0;
        do {
            ans = x(); // p 或者 1-p
        } while(ans == x());
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[2];
        for (int i = 0; i < 10000; i++) {
            arr[f()]++;
        }
        for (int i = 0; i <= 1; i++) {
            System.out.println(i + "出现了：" + arr[i] + "次");
        }
    }
}
