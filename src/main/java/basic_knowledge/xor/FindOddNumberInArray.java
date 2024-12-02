package basic_knowledge.xor;

/**
 * @BelongsPackage: basic_knowledge.xor
 * @ClassName: FindOddNumberInArray
 * @Author: 丛虹羽
 * @Date: 2024/12/2 下午11:51
 * @Description: 数组中只有一个出现奇数次的数，其他的所有数都出现了偶数次，找到这个数！！
 *
 * leetcode: https://leetcode.cn/problems/single-number/
 */
public class FindOddNumberInArray {

    /**
     * 数组中只有一个出现奇数次的数，其他的所有数都出现了偶数次，找到这个数！！
     * 知识点：
     *      N ^ N = 0
     *      0 ^ N = N
     *
     * @return
     */
    public static int findOddNumberInArray(int[] arr) {
        int xor = 0;
        for (int number : arr) {
            xor ^= number;
        }
        return xor == 0 ? -1 : xor;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 5, 5, 5, 4, 3, 3, 3, 2, 1, 1, 1, 7, 8, 8, 7, 7, 7};
        System.out.println("出现奇数次的个数的数是：" + findOddNumberInArray(arr));
    }
}
