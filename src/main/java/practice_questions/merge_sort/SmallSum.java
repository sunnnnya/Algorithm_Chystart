package practice_questions.merge_sort;

/**
 * @BelongsPackage: practice_questions.merge_sort
 * @ClassName: SmallSum
 * @Author: 丛虹羽
 * @Date: 2024/7/30 下午3:50
 * @Description:  小和问题
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。
 * 例子:[1,3,4,2,5] 1左边比1小的数，没有;3左边比3小的数，1;4左边比4小的数，1、3;2左边比2小的数，1;5左边比5小的数，1、3、4、2;
 * 小和: 1 + 1 + 3 + 1 + 1 + 3 + 4 + 2 = 16
 *
 * 方法转换：求一个数左边比自己小的数加起来 <=> 求一个数右边比自己大的数有几个，然后*当前数值
 */
public class SmallSum {

    /**
     * 进行递归排序，寻找最小和
     *
     * @param arr
     * @return
     */
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length == 1) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    /**
     * 递归调用的过程
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    public static int process(int[] arr, int l, int r) {
        if(l == r) {
            return 0;
        }
        int mid = r + ((l - r) >> 1);
        // merge表示的是当前拆分字段排序的结果，但是我们还需要由以前数组排序成现在数组形成的最小和数量
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    /**
     * 进行合并排序的过程
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     * @return
     */
    public static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int index = 0;
        int p1 = l;
        int sum = 0;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            sum += arr[p1] < arr[p2] ? (arr[p1] * (r - p2 + 1)) : 0;
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }
        while (p2 <= r) {
            help[index++] = arr[p2++];
        }
        for (int i = 0; i < index; i++) {
            arr[l + i] = help[i];
        }
        return sum;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        System.out.println(smallSum(arr));
        // 16
    }
}
