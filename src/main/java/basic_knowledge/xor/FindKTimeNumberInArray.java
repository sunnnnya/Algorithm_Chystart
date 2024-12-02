package basic_knowledge.xor;

/**
 * @BelongsPackage: basic_knowledge.xor
 * @ClassName: FindKTimeNumberINArray
 * @Author: 丛虹羽
 * @Date: 2024/12/2 下午3:23
 * @Description: 找到在数组中出现 k 次的数，其他的数出现 M 次，找到这个出现 K 次的数, k < m
 */
public class FindKTimeNumberInArray {

    /**
     * 找到出现 K 次的那个数
     *
     * @param arr
     * @return
     */
    public static int singleNumber(int[] arr, int k, int m) {
        int[] bits = new int[32];
        for (int number : arr) {
            for (int i = 0; i < 32; i++) {
                bits[i] += ((number >> i) & 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // 此处说明：有 k 位 bit 了 m + k % m -> k
            if(bits[i] % m != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 2, 2, 1, 1, 1, 1, 5, 5, 6, 7, 7, 5, 5, 7, 7, 6};
        System.out.println("出现 2 次的数是：" + singleNumber(arr, 2, 4));
    }
}