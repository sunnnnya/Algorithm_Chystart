package practice_questions.quick_sort.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.quick_sort.easy
 * @ClassName: InventoryManagement
 * @Author: 丛虹羽
 * @Date: 2024/8/14 下午8:52
 * @Description: 库存管理 III
 *
 * 仓库管理员以数组 stock 形式记录商品库存表，其中 stock[i] 表示对应商品库存余量。请返回库存余量最少的 cnt 个商品余量，返回 顺序不限。
 *
 * leetcode：https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof
 */
public class InventoryManagement {

    /**
     * 使用快速排序的思想然后返回，排序之后的结果
     *
     * @param stock
     * @param cnt
     * @return
     */
    public static int[] inventoryManagement(int[] stock, int cnt) {
        if (cnt > stock.length) {
            return new int[]{-1};
        }
        quickSort(stock, 0, stock.length - 1);
        int[] arr = new int[cnt];
        for(int i = 0; i < cnt; i++) {
            arr[i] = stock[i];
        }
        return arr;
    }

    /**
     * 快速排序
     *
     * @param nums
     * @param l
     * @param r
     */
    public static void quickSort(int[] nums, int l, int r) {
        if(l >= r) {
            return;
        }
        int randomNumber = nums[l + (int)(Math.random() * (r - l + 1))];
        int[] p = parition(nums, l, r, randomNumber);
        quickSort(nums, l, p[0] - 1);
        quickSort(nums, p[1] + 1, r);
    }

    /**
     * 做分组测试，一定注意边界的使用
     *
     * @param arr
     * @param l
     * @param r
     * @param N
     * @return
     */
    public static int[] parition(int[] arr, int l, int r, int N) {
        int less = l - 1;
        int more = r + 1;
        while (l < more) {
            if (arr[l] < N) {
                swap(arr, l++, ++less);
            } else if (arr[l] > N) {
                swap(arr, l, --more);
            } else {
                l++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    /**
     * 交换两个数
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("================测试parition函数================");
        int[] arr3 = new int[]{0,2,3,6};
        int[] parition = parition(arr3, 0, arr3.length - 1, 3);
        System.out.println(Arrays.toString(parition));

        System.out.println("======================测试数据======================");
        int[] arr = new int[]{2,5,7,4};
        System.out.println(Arrays.toString(inventoryManagement(arr, 1)));
        // [2]

        int[] arr1 = new int[]{0,2,3,6};
        System.out.println(Arrays.toString(inventoryManagement(arr1, 2)));
        // [0, 2]
    }
}
