package job_interview.alg_basic_know.array.array_sort.ext.quick_sort_ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.sort.ext.quick_sort_ext
 * @ClassName: FindKthLargest
 * @Author: 丛虹羽
 * @Date: 2025/4/2 22:34
 * @Description: 数组中的第K个最大元素
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
 */
public class FindKthLargest {

    /**
     * 快排改写
     *  包含重复值，直接计算
     *
     * @param nums 原始数组
     * @param k    第 k 个数组
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        if (nums.length == 1 && k > 1) {
            return -1;
        }
        return process(nums, 0, nums.length - 1, k - 1);
    }

    /**
     * 快排的基本过程
     *
     * @param arr   原始数组
     * @param l     l index
     * @param r     r index
     * @param index
     * @return
     */
    private static int process(int[] arr, int l, int r, int index) {
        swap(arr, l + (int)(Math.random() * (r - l + 1)), r);
        int[] p = partition(arr, l, r);
        if(index >= p[0] && index <= p[1]) {
            return arr[index];
        } else if (index < p[0]) {
            return process(arr, l, p[0] - 1, index);
        } else {
            return process(arr, p[1] + 1, r, index);
        }
    }

    /**
     * 经典荷兰国旗问题
     *
     * @param nums 原始数组
     * @param l    l index
     * @param r    r index
     * @return
     */
    private static int[] partition(int[] nums, int l, int r) {
        int more = l, less = r, index = r, target = nums[r];
        while(more <= index) {
            if(nums[index] < target) {
                swap(nums, index--, less--);
            } else if (nums[index] > target) {
                swap(nums, index, more++);
            } else {
                index--;
            }
        }
        return new int[]{more, less};
    }

    /**
     * 交换两个数
     *
     * @param nums 原始数组
     * @param i    i index
     * @param j    j index
     */
    private static void swap(int[] nums, int i, int j) {
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
        int[] arr = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(arr, 4));
        // 4
    }
}
