package basic_knowledge.recursion;

/**
 * @BelongsPackage: basic_knowledge.recursion
 * @ClassName: GetMaxNumber
 * @Author: 丛虹羽
 * @Date: 2024/7/29 下午11:31
 * @Description: 使用递归的方式获取数组中的最大的值
 *
 * 主要注意的就是递归函数抽象化
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
     * 获取最小值
     *
     * @param arr
     * @param n
     * @return
     */
    public static int getMinNumberInArray(int[] arr, int n) {
        if (n == 0) {
            return arr[0];
        }
        return Math.min(arr[n], getMinNumberInArray(arr, n - 1));
    }

    /**
     * 获取最小值
     *
     * @param arr
     * @param n  表示的是从 0 ~ n之间的最大值
     * @return
     */
    public static int getMaxNumberInArray(int[] arr, int n) {
        if (n == 0) {
            return arr[0];
        }
        return Math.max(arr[n], getMaxNumberInArray(arr, n - 1));
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
        System.out.println(getMinNumberInArray(arr, arr.length - 1));
        // 1
        System.out.println(getMaxNumberInArray(arr, arr.length - 1));
        // 100
    }
}
