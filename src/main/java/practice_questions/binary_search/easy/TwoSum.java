package practice_questions.binary_search.easy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @BelongsPackage: practice_questions.binary_search
 * @ClassName: TwoSum
 * @Author: 丛虹羽
 * @Date: 2024/7/29 下午9:14
 * @Description: 查找总价格为目标值的两个商品
 *
 * 购物车内的商品价格按照升序记录于数组 price。请在购物车中找到两个商品的价格总和刚好是 target。
 * 若存在多种情况，返回任一结果即可。
 */
public class TwoSum {

    /**
     * 自己的解法
     *
     * @param price
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] price, int target) {
        if (price.length == 0) {
            return new int[]{};
        }
        for (int i = 0; i < price.length; i++) {
            int existsIndex = isExists(price, target - price[i]);
            if (existsIndex != -1 && existsIndex != i) {
                return new int[]{price[existsIndex], price[i]};
            }
        }
        return new int[]{};
    }

    /**
     * 自己的解法，采用二分搜索查找指定的值
     *
     * @param arr
     * @param target
     * @return
     */
    public static int isExists(int[] arr, int target) {
        int ans = -1;
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (r + ((l - r) >> 1));
            if (arr[mid] == target) {
                ans = mid;
                return ans;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 自己的解法，使用缓存或者打表的方式加速，少数据量可以，大数量直接时间超限
     *
     * @param price
     * @param target
     */
    private static int[] twoSum2(int[] price, int target) {
        // init
        LinkedList<Integer> cached = new LinkedList<>();
        for (int number : price) {
            // hit cache
            if (cached.contains(target - number)) {
                return new int[]{number, target - number};
            }
            cached.add(number);
        }
        return new int[]{};
    }

    /**
     * 优化双指针但是不快，还是很慢：因为是有序的，所以从 l = 0, r = arr.length - 1进行遍历
     * 如果 两者之和 > sum 则 r 进行变小
     * 如果 两者之和 < sum 则 l 进行变大
     * O（n）
     *
     * @param price
     * @param target
     * @return
     */
    public static int[] twoSum(int[] price, int target) {
        int l = 0;
        int r = price.length - 1;
        // l < r 不能出现 当前值 * 2  = target 的情况
        while (l < r) {
            int sum = price[l] + price[r];
            if (sum == target) {
                return new int[]{price[l], price[r]};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{};
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {3, 9, 12, 15};
        int target = 18;
        System.out.println(Arrays.toString(twoSum(arr, target)));
        System.out.println(Arrays.toString(twoSum1(arr, target)));
        System.out.println(Arrays.toString(twoSum2(arr, target)));
    }
}
