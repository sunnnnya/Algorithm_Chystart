package job_interview.alg_basic_know.array.sort.ext.merge_sort_ext;

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
     * 使用 归并排序 进行排序
     *
     * @param stock 原始数组
     * @param cnt   前几个值
     * @return      int[]
     */
    public static int[] inventoryManagement(int[] stock, int cnt) {
        if(stock == null || stock.length == 0) {
            return stock;
        }
        process(stock, 0, stock.length - 1);
        int[] ans = new int[cnt];
        for(int i = 0; i < cnt; i++) {
            ans[i] = stock[i];
        }
        return ans;
    }

    /**
     * 归并排序模板
     *
     * @param nums  原始数组
     * @param left  left  index
     * @param right right index
     */
    public static void process(int[] nums, int left, int right) {
        if(left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(nums, left, mid);
        process(nums, mid + 1, right);
        mergeSort(nums, left, mid, right);
    }

    /**
     * 归并排序的过程
     *
     * @param nums  原始过程
     * @param left  left index
     * @param mid   mid index
     * @param right right index
     */
    public static void mergeSort(int[] nums, int left, int mid, int right) {
        int p1 = left, p2 = mid + 1, index = 0;
        int[] help = new int[right - left + 1];
        while(p1 <= mid && p2 <= right) {
            help[index++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while(p1 <= mid) {
            help[index++] = nums[p1++];
        }
        while(p2 <= right) {
            help[index++] = nums[p2++];
        }
        for(int i = 0; i < index; i++) {
            nums[left + i] = help[i];
        }
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
