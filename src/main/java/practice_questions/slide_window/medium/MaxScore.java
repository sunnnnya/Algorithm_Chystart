package practice_questions.slide_window.medium;

import java.util.Arrays;
import java.util.Map;

/**
 * @BelongsPackage: practice_questions.slide_window.medium
 * @ClassName: MaxScore
 * @Author: 丛虹羽
 * @Date: 2024/12/8 上午11:25
 * @Description: 可获得的最大点数
 */
public class MaxScore {
    /**
     * 对问题进行转换
     *
     * @param cardPoints
     * @param k
     * @return
     */
    public static int maxScore(int[] cardPoints, int k) {
        // 问题转换!!!：求 k 的最大值，等价 n - k 的最小值
        int N = cardPoints.length;
        int K = N - k, sum = 0, min = Integer.MAX_VALUE, total = 0;
        if(K == 0) {
            return Arrays.stream(cardPoints).sum();
        }
        for(int i = 0; i < N; i++) {
            sum += cardPoints[i];
            total += cardPoints[i];
            if(i < K - 1) {
                continue;
            }
            min = Math.min(min, sum);
            sum -= cardPoints[i - K + 1];
        }
        return total - min;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 1};
        System.out.println("可以拿到的最大的牌的数量是：" + maxScore(arr, 3));

        int[] arr2 = new int[]{2, 2, 2};
        System.out.println("可以拿到的最大的牌的数量是：" + maxScore(arr2, 2));

        int[] arr3 = new int[]{9, 7, 7, 9, 7, 7, 9};
        System.out.println("可以拿到的最大的牌的数量是：" + maxScore(arr3, 7));

        int[] arr4 = new int[]{1, 1000, 1};
        System.out.println("可以拿到的最大的牌的数量是：" + maxScore(arr4, 1));

        int[] arr5 = new int[]{1,79,80,1,1,1,200,1};
        System.out.println("可以拿到的最大的牌的数量是：" + maxScore(arr5, 3));
    }
}