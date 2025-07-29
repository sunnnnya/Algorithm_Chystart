package job_interview.hot100.heap;

/**
 * @BelongsPackage: job_interview.hot100.heap
 * @ClassName: FindKthLargest
 * @Author: 丛虹羽
 * @Date: 2025/7/29 21:08
 * @Description: 数组中的第K个最大元素
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class FindKthLargest {

    /**
     * 使用随机快速排序解决 第 K 大的值
     *
     * @param nums 原始数组
     * @param k    k 大元素
     * @return int
     */
    public static int findKthLargest(int[] nums, int k) {
        return process(nums, 0, nums.length - 1, k - 1);
    }

    /**
     * 随机快排走一半
     *
     * @param nums 原始数组
     * @param l    l index
     * @param r    r index
     * @param k    k number
     * @return int
     */
    private static int process(int[] nums, int l, int r, int k) {
        swap(nums, l + (int)(Math.random() * (r - l + 1)), r);
        int[] p = partition(nums, l, r);
        if(k >= p[0] && k <= p[1]) {
            return nums[k];
        } else if(k < p[0]) {
            return process(nums, l, p[0] - 1, k);
        } else {
            return process(nums, p[1] + 1, r, k);
        }
    }

    /**
     * 经典荷兰国旗问题
     *
     * @param nums 原始数组
     * @param l    l index
     * @param r    r index
     * @return int[]
     */
    private static int[] partition(int[] nums, int l, int r) {
        int index = l, more = l, less = r, target = nums[r];
        while(index <= less) { // 需要相等处理，因为 less 表示的使下一个要交换的位置，但是此时当前位置的值还未比较呢，所以必须 <=
            if(nums[index] > target) {
                swap(nums, index++, more++);
            } else if(nums[index] < target) {
                swap(nums, index, less--);
            } else {
                index++;
            }
        }
        return new int[]{more, less};
    }

    /**
     * 交换指定索引位置的元素
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
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums, 4));
        // 4
    }
}
