package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: SingleNumber
 * @Author: 丛虹羽
 * @Date: 2024/8/5 下午8:31
 * @Description: 只出现一次的数字
 *
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 */
public class SingleNumber {

    /**
     * 知识点：0 ^ N = N、N ^ N = 0
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int eor = 0;
        for (int number : nums) {
            eor ^= number;
        }
        return eor;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(arr));
        // 4
        int[] arr1 = new int[]{2,2,1};
        System.out.println(singleNumber(arr1));
        // 1
    }
}
