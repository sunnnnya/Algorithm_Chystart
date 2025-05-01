package job_interview.alg_basic_know.array.array_sort.ext.quick_sort_ext;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.sort.ext.quick_sort_partition
 * @ClassName: InventoryManagement
 * @Author: 丛虹羽
 * @Date: 2025/3/29 22:37
 * @Description: 库存管理 III
 * https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/description/
 */
public class InventoryManagement {

    /**
     * 使用 快速排序 进行排序
     *
     * @param stock 原始数组
     * @param cnt   前几个值
     * @return      int[]
     */
    public static int[] inventoryManagement(int[] stock, int cnt) {
        if(stock == null || stock.length == 0) {
            return stock;
        }
        quickSort(stock, 0, stock.length - 1);
        int[] ans = new int[cnt];
        for(int i = 0; i < cnt; i++) {
            ans[i] = stock[i];
        }
        return ans;
    }

    /**
     * 快速排序
     *
     * @param nums 原始数组
     * @param l    l index
     * @param r    r index
     */
    public static void quickSort(int[] nums, int l, int r) {
        if(l >= r) {
            return;
        }
        swap(nums, l + (int)(Math.random() * (r - l + 1)), r);
        int[] p = partition(nums, l, r);
        quickSort(nums, l, p[0] - 1);
        quickSort(nums, p[1] + 1, r);
    }

    /**
     * 数组的分区
     *
     * @param nums 原始数组
     * @return     int[]
     */
    public static int[] partition(int[] nums, int l, int r) {
        int less = l, more = r, index = l, target = nums[r];
        while(index <= more) {
            if(nums[index] < target) {
                swap(nums, index++, less++);
            } else if (nums[index] > target) {
                swap(nums, index, more--);
            } else {
                index++;
            }
        }
        return new int[]{less, more};
    }

    /**
     * 交换两个数
     *
     * @param nums 原始数组
     * @param i    i index
     * @param j    j index
     */
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 3, 6};
        int cnt = 2;
        System.out.println(Arrays.toString(inventoryManagement(arr, cnt)));
        // [0, 2]
    }
}
