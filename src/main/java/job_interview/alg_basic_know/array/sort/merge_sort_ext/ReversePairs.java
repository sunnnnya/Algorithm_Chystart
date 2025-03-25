package job_interview.alg_basic_know.array.sort.merge_sort_ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.sort.merge_sort_ext
 * @ClassName: ReversePairs
 * @Author: 丛虹羽
 * @Date: 2025/3/25 21:13
 * @Description: 交易逆序对的总数
 * https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/description/
 */
public class ReversePairs {

    /**
     * 求逆序对的个数 O(n^2) TLE
     *      50000 数据直接爆
     *
     * @param record 原始数组
     * @return 逆序对个数
     */
    public static int reversePairs1(int[] record) {
        int ans = 0;
        for(int i = 0 ; i < record.length - 1; i++) {
            for(int j = i + 1; j < record.length; j++) {
                ans += record[i] > record[j] ? 1 : 0;
            }
        }
        return ans;
    }

    /**
     * 归并排序的改写 —— 从大到小 O(NlogN)
     *
     * @param record 原始数组
     * @return 逆序对个数
     */
    public static int reversePairs(int[] record) {
        if(record == null || record.length == 1 || record.length == 0) {
            return 0;
        }
        return process(record, 0, record.length - 1);
    }

    /**
     * 归并过程
     *
     * @param nums 原始数组
     * @param l    l index
     * @param r    r index
     * @return 返回逆序对的个数
     */
    public static int process(int[] nums, int l, int r) {
        if(l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(nums, l, mid) + process(nums, mid + 1, r) + merge(nums, l, mid, r);
    }

    /**
     * 合并的过程
     *
     * @param nums 原始数组
     * @param l    l index
     * @param m    m index
     * @param r    r index
     * @return 逆序对的个数
     */
    public static int merge(int[] nums, int l, int m, int r) {
        int p1 = l, p2 = m + 1, ans = 0, index = 0;
        int[] help = new int[r - l + 1];
        while(p1 <= m && p2 <= r) {
            ans += nums[p1] > nums[p2] ? (r - p2 + 1) : 0;
            help[index++] = nums[p1] > nums[p2] ? nums[p1++] : nums[p2++];
        }
        while(p1 <= m) {
            help[index++] = nums[p1++];
        }
        while(p2 <= r) {
            help[index++] = nums[p2++];
        }
        for(int i = 0; i < index; i++) {
            nums[l + i] = help[i];
        }
        return ans;
    }


    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{9, 7, 5, 4, 6};
        System.out.println(reversePairs(nums));
    }
}
