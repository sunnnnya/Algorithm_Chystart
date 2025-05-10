package job_interview.alg_basic_know.array.array_sort.base_sort;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.sort
 * @ClassName: CountSort
 * @Author: 丛虹羽
 * @Date: 2025/3/25 09:30
 * @Description: 基数排序 —— 数据范围有限
 */
public class CountSort {

    public static int MAXN = 2001;

    public static int[] count = new int[MAXN];

    /**
     * 计数排序：数据范围固定
     *
     * @param nums 原始数组
     */
    public static void countSort(int[] nums) {
        for(int num : nums) {
            count[num]++;
        }
        for(int i = 0; i < MAXN; i++) {
            for(int j = 0; j < count[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{8, 1, 2, 3, 1, 4, 2, 5, 8, 10};
        countSort(nums);
        // 1 1 2 2 3 4 5 8 8 10
    }
}
