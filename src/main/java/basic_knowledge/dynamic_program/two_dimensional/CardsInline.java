package basic_knowledge.dynamic_program.two_dimensional;

import java.util.Arrays;

/**
 * @package: basic_knowledge.dynamic_program.two_dimensional
 * @author: chystart
 * @create: 2024-12-28 23:35
 * @description: 拿卡牌
 *
 * 给定一个整型数组 arr，代表数值不同的纸牌排成一条线
 *      玩家 A 和玩家 B 依次拿走每张纸牌，规定玩家 A 先拿，玩家 B 后拿，但是每个玩家每次只能拿走最左或最右的纸牌。
 *    玩家 A 和玩家 B 都绝顶聪明请返回最后获胜者的分数。
 **/
public class CardsInline {

    /**
     * 根据规则返回，获胜者的分数
     *
     * @param arr
     * @return
     */
    public static int win1(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        // 玩家 A 先手的最大得分
        int first = offensive1(arr, 0, arr.length - 1);
        // 玩家 B 后手的最大得分
        int second = defensive1(arr, 0, arr.length - 1);
        // 最后获胜者的最大分数
        return Math.max(first, second);
    }

    /**
     * 先手函数：以先手的情况下，在 arr[left ... right] 可以获取到的最大分数
     *      先手玩家希望最大化自己的得分
     *
     * @param arr   牌的原始数组
     * @param left  左侧的下标
     * @param right 右侧的下标
     * @return
     */
    public static int offensive1(int[] arr, int left, int right) {
        // 先手且只有一张牌了，直接拿！！！
        if(left == right) {
            return arr[left];
        }
        // 先手可以拿左边的牌 arr[left]，然后在剩余牌中作为后手
        int p1 = arr[left] + defensive1(arr, left + 1, right);
        // 先手可以拿右边的牌 arr[right]，然后在剩余牌中作为后手
        int p2 = arr[right] + defensive1(arr, left, right - 1);
        return Math.max(p1, p2);
    }

    /**
     * 后手函数：以后手的情况下，在 arr[left ... right] 可以获取到的最大分数
     *      后手玩家则试图最小化先手玩家的得分
     *
     * @param arr   牌的原始数组
     * @param left  左侧的下标
     * @param right 右侧的下标
     * @return
     */
    public static int defensive1(int[] arr, int left, int right) {
        // 后手且只有一张牌了，拿不到！！！
        if(left == right) {
            return 0;
        }
        // 对手拿走左边的牌后，我在剩余牌中作为先手
        int p1 = offensive1(arr, left + 1, right);
        // 对手拿走右边的牌后，我在剩余牌中作为先手
        int p2 = offensive1(arr, left, right - 1);
        // offensive 函数的含义本身就是先手返回最大值，但是对手决定聪明，但是！对手是聪明的，会让我们得到最小的值
        return Math.min(p1, p2);
    }

    /**
     * 根据规则返回，获胜者的分数
     *
     * @param arr
     * @return
     */
    public static int win2(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] offensiveMap = new int[N][N];
        int[][] defensiveMap = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                offensiveMap[i][j] = -1;
                defensiveMap[i][j] = -1;
            }
        }
        int first = offensive2(arr, 0, arr.length - 1, offensiveMap, defensiveMap);
        int second = defensive2(arr, 0, arr.length - 1, offensiveMap, defensiveMap);
        return Math.max(first, second);
    }

    /**
     * 先手函数：以先手的情况下，在 arr[left ... right] 可以获取到的最大分数
     *      先手玩家希望最大化自己的得分
     *
     * @param arr   牌的原始数组
     * @param left  左侧的下标
     * @param right 右侧的下标
     * @return
     */
    public static int offensive2(int[] arr, int left, int right, int[][] offensiveMap, int[][] defensiveMap) {
        if(offensiveMap[left][right] != -1) {
            return offensiveMap[left][right];
        }
        int ans = 0;
        if(left == right) {
            ans = arr[left];
        } else {
            int p1 = arr[left] + defensive2(arr, left + 1, right, offensiveMap, defensiveMap);
            int p2 = arr[right] + defensive2(arr, left, right - 1, offensiveMap, defensiveMap);
            ans = Math.max(p1, p2);
        }
        offensiveMap[left][right] = ans;
        return ans;
    }

    /**
     * 后手函数：以后手的情况下，在 arr[left ... right] 可以获取到的最大分数
     *      后手玩家则试图最小化先手玩家的得分
     *
     * @param arr   牌的原始数组
     * @param left  左侧的下标
     * @param right 右侧的下标
     * @return
     */
    public static int defensive2(int[] arr, int left, int right, int[][] offensiveMap, int[][] defensiveMap) {
        if(defensiveMap[left][right] != -1) {
            return defensiveMap[left][right];
        }
        if(left == right) {
            return 0;
        }
        int p1 = offensive2(arr, left + 1, right, offensiveMap, defensiveMap);
        int p2 = offensive2(arr, left, right - 1, offensiveMap, defensiveMap);
        defensiveMap[left][right] = Math.min(p1, p2);
        return defensiveMap[left][right];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 测试用例1: 基础测试
        int[] arr1 = {4, 7, 9, 5};
        System.out.println("测试用例1: " + Arrays.toString(arr1));
        System.out.println("结果: " + win2(arr1));

        // 测试用例2: 只有两个数
        int[] arr2 = {1, 100};
        System.out.println("\n测试用例2: " + Arrays.toString(arr2));
        System.out.println("结果: " + win2(arr2));

        // 测试用例3: 单个数字
        int[] arr3 = {50};
        System.out.println("\n测试用例3: " + Arrays.toString(arr3));
        System.out.println("结果: " + win2(arr3));

        // 测试用例4: 所有数字相等
        int[] arr4 = {5, 5, 5, 5};
        System.out.println("\n测试用例4: " + Arrays.toString(arr4));
        System.out.println("结果: " + win2(arr4));

        // 测试用例5: 递增序列
        int[] arr5 = {1, 2, 3, 4, 5};
        System.out.println("\n测试用例5: " + Arrays.toString(arr5));
        System.out.println("结果: " + win2(arr5));

        // 测试用例6: 递减序列
        int[] arr6 = {5, 4, 3, 2, 1};
        System.out.println("\n测试用例6: " + Arrays.toString(arr6));
        System.out.println("结果: " + win2(arr6));

        // 测试用例7: 较大数组
        int[] arr7 = {10, 20, 30, 40, 50, 60, 70};
        System.out.println("\n测试用例7: " + Arrays.toString(arr7));
        System.out.println("结果: " + win2(arr7));

        // 测试用例8: 空数组
        int[] arr8 = {};
        System.out.println("\n测试用例8: 空数组");
        System.out.println("结果: " + win2(arr8));

        // 测试用例9: null
        System.out.println("\n测试用例9: null");
        System.out.println("结果: " + win2(null));
    }
}