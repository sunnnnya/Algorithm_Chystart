package leetcode.skill.double_pointer;

import java.util.Arrays;

/**
 * @package: leetcode.skill.double_pointer
 * @author: chystart
 * @create: 2025-03-08 15:41
 * @description: 供暖器
 *
 * leetcode: https://leetcode.cn/problems/heaters/description/
 **/
public class FindRadius {

    /**
     * 双指针解法
     *
     * @param houses  房屋数组
     * @param heaters 供暖器数组
     * @return
     */
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        for(int i = 0, j = 0; i < houses.length; i++) {
            // i 房屋, j 供暖器
            while(!best(houses, heaters, i, j)) {
                j++;
            }
            ans = Math.max(ans, Math.abs(heaters[j] - houses[i]));
        }
        return ans;
    }

    /**
     * 判断从 houses[i] 到 heaters[j] 是不是最优的
     *
     * @param houses  房屋数组
     * @param heaters 供暖器数组
     * @param i       房屋索引
     * @param j       供暖器索引
     * @return
     */
    public static boolean best(int[] houses, int[] heaters, int i, int j) {
        // j == heaters.length - 1 ：说明当前供暖期已经走到了最后，只能选择这个
        // Math.abs(heaters[j] - houses[i]) < Math.abs(heaters[j + 1] - houses[i]) ：判断当前 j 位置是不是最优的！！
        return j == heaters.length - 1 || Math.abs(heaters[j] - houses[i]) < Math.abs(heaters[j + 1] - houses[i]);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{2};
        System.out.println(findRadius(arr1, arr2));
        // 1
    }
}
