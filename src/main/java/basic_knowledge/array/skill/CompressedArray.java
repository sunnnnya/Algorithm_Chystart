package basic_knowledge.array.skill;

/**
 * @BelongsPackage: basic_knowledge.array.skill
 * @ClassName: CompressedArray
 * @Author: 丛虹羽
 * @Date: 2024/8/26 上午11:44
 * @Description: 数组压缩 技巧
 */
public class CompressedArray {

    public static int MAXN = 10001;

    public static int[] nums = new int[MAXN];

    /**
     * 数组压缩
     *
     * @param arr
     */
    public static void compressedArray(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                nums[j] = arr[i][j] == 0 ? 0 : nums[j] + 1;
            }
        }
        for (int i = 0; i < M; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 1, 0, 1, 1},
                                  {1, 0, 1, 0, 0},
                                  {1, 1, 1, 1, 1},
                                  {1, 1, 1, 1, 0}};
        compressedArray(arr);
        // 4 2 3 2 0
    }
}
