package job_interview.alg_basic_know.array.sort.ext.merge_sort_ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.sort.sort_extend
 * @ClassName: SmallSum
 * @Author: 丛虹羽
 * @Date: 2025/3/25 16:00
 * @Description: 小和问题
 * 在数组中，每个数左边比当前数小的数累加起来，叫做这个数组的小和；
 *   例子：[1, 3, 4, 2, 5]
 *      1 左边比 1小的数，没有;
 *      3 左边比 3 小的数，1;
 *      4 左边比 4 小的数，1、3;
 *      2 左边比 2 小的数，1;
 *      5 左边比 5 小的数，1、3、4、2;
 *   小和：1 + 1 + 3 + 1 + 1 + 3 + 4 + 2 = 16
 *
 * 思考转换：求一个数左边比自己小的数加起来 <=> 当前数值 * 右边比自己大的数有几个
 */
public class SmallSum {

    /**
     * 小和问题
     *
     * @param nums 原始数组
     */
    public static int smallSum(int[] nums) {
        if(nums == null || nums.length == 1) {
            return 0;
        }
        return process(nums, 0, nums.length - 1);
    }

    /**
     * 在 [l, r] 之间进行排序
     *
     * @param nums 原始数组
     * @param l    l index
     * @param r    r index
     */
    public static int process(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(nums, l, mid) + // 左组小和的数量
                process(nums, mid + 1, r) + // 右组小和数量
                merge(nums, l, mid, r);
    }

    /**
     * 归并的过程中会产生小和
     *
     * @param nums 原始数组
     * @param L    L index
     * @param M    M index
     * @param R    R index
     * @return 小和个数
     */
    public static int merge(int[] nums, int L, int M, int R) {
        int index = 0, p1 = L, p2 = M + 1, res = 0;
        int[] help = new int[R - L +1 ];
        while(p1 <= M && p2 <= R) {
            // 只有右组的值大于左边的值的时候，才会产生小和，进行结果的累加
            res += nums[p1] < nums[p2] ? nums[p1] * (R - p2 + 1) : 0;
            // 一定先拷贝右边的
            help[index++] = nums[p2] <= nums[p1] ? nums[p2++] : nums[p1++];
        }
        while(p1 <= M) {
            help[index++] = nums[p1++];
        }
        while(p2 <= R){
            help[index++] = nums[p2++];
        }
        for(int i = 0; i < index; i++) {
            nums[L + i] = help[i];
        }
        return res;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 5};
        System.out.println("Result: " + smallSum(nums));
        // Result: 16
    }
}
