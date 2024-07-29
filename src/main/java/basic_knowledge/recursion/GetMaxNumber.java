package basic_knowledge.recursion;

/**
 * @BelongsPackage: basic_knowledge.recursion
 * @ClassName: GetMaxNumber
 * @Author: 丛虹羽
 * @Date: 2024/7/29 下午11:31
 * @Description: 使用递归的方式获取数组中的最大的值
 */
public class GetMaxNumber {

    public static int getMaxNumber(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    /**
     * 采用递归的方式实现查询数组中的最大值
     *
     * @param arr   数组
     * @param l     左边界
     * @param r     右边界
     * @return
     */
    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = l + ((r - l) >> 1);
        int number1 = process(arr, l, mid);
        int number2 = process(arr, mid + 1, r);
        return Math.max(number1, number2);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 90, 100, 12, 21, 23, 99};
        System.out.println(getMaxNumber(arr));
        // 100
    }
}
