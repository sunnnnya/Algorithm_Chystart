package job_interview.alg_basic_know.array.array_sort.advanced_sort;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.array_sort.advanced_sort
 * @ClassName: HeapSort
 * @Author: 丛虹羽
 * @Date: 2025/10/6 23:55
 * @Description: 堆排序的基本实现
 */
public class HeapSort {

    /**
     * 堆排序
     *
     * @param nums 原始数组
     */
    public static void heapSort(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            heapInsert(nums, i);
        }
        int size = n;
        while(size > 1) {
            swap(nums, 0, --size);
            heapify(nums, 0, size);
        }
    }

    /**
     * 元素下沉的过程
     *
     * @param nums 原始数组
     * @param i    i index
     * @param size 元素的个数
     */
    private static void heapify(int[] nums, int i, int size) {
        int l = 2 * i + 1;
        while(l < size) {
            int best = l + 1 < size && nums[l + 1] >= nums[l] ? l + 1 : l;
            best = nums[i] > nums[best] ? i : best;
            if(i == best) break;
            swap(nums, i, best);
            i = best;
            l = 2 * i + 1;
        }
    }

    /**
     * 元素上浮的过程
     *
     * @param nums 原始数组
     * @param i    i index
     */
    private static void heapInsert(int[] nums, int i) {
        while(nums[i] > nums[(i - 1) / 2]) {
            swap(nums, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    /**
     * 交换两个指定索引位置的数
     *
     * @param nums 原始数组
     * @param i    i index
     * @param j    j index
     */
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{25, -1, 100, 0, 200, 7, -50, 300, 1, 23, -10, 89, 6, 250, 0, 5, 30, 19, 2, -100};
        System.out.println("before heap_sort :" + Arrays.toString(nums));
        // before heap_sort :[25, -1, 100, 0, 200, 7, -50, 300, 1, 23, -10, 89, 6, 250, 0, 5, 30, 19, 2, -100]
        heapSort(nums);
        System.out.println("after heap_sort :" + Arrays.toString(nums));
        // after heap_sort :[-100, -50, -10, -1, 0, 0, 1, 2, 5, 6, 7, 19, 23, 25, 30, 89, 100, 200, 250, 300]
    }
}
