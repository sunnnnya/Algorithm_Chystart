package job_interview.alg_basic_know.array.slide_window.ext.not_fixed_length.max_length;

import java.util.HashMap;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.slide_window.ext.not_fixed_length.max_length
 * @ClassName: TotalFruit
 * @Author: 丛虹羽
 * @Date: 2025/4/16 17:02
 * @Description: 水果成篮
 * https://leetcode.cn/problems/fruit-into-baskets/description/
 */
public class TotalFruit {

    /**
     * 滑动窗口，使用 哈希表 进行频率统计
     *
     * @param fruits 原始数组
     * @return
     */
    public static int totalFruit(int[] fruits) {
        int ans = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0, left = 0; i < fruits.length; i++) {
            mp.put(fruits[i], mp.getOrDefault(fruits[i], 0) + 1);
            while(mp.size() == 3) {
                if(mp.get(fruits[left]) == 1) {
                    mp.remove(fruits[left]);
                } else {
                    mp.put(fruits[left], mp.get(fruits[left]) - 1);
                }
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] fruits = new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println("totalFruit is: " + totalFruit(fruits));
        // totalFruit is: 5
    }
}
