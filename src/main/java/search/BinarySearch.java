package search;

/**
 * @BelongsPackage: search
 * @ClassName: BinarySearch
 * @Author: 丛虹羽
 * @Date: 2024/7/22 上午1:15
 * @Description: 二分搜索 + 拓展
 */
public class BinarySearch {

    /**
     * 二分搜索：找到数组中是否存在数字
     *
     * @param arr 数组
     * @param num 要找的值
     * @return 返回索引位置
     */
    public static boolean baseBinaruSearch(int[] arr,  int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int l = 0;
        int r = arr.length - 1;
        // 相等时也需要判断，只有出现错位时才停止循环
        while (l <= r) {
            int mid  = l + ((r - l) >> 1);
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // 循环判断结束
        return false;
    }


    /**
     * 找到数组中 >=num 的最左位置下标
     *
     * @param arr 数组
     * @param num 要找的值
     * @return 返回索引位置
     */
    public static int findTheLeftIndexOfTheSpecifiedValueInTheArray(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int result = -1;
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            // 位运算，防止溢出
            int middleIndex = l + ((r - l) >> 1);
            if (arr[middleIndex] >= num) {
                result = middleIndex;
                r = middleIndex - 1;
            } else if (arr[middleIndex] < num) {
                l = middleIndex + 1;
            }
        }
        return result;
    }

    /**
     * 找到数组中 <=num 的最右位置下标
     *
     * @param arr 数组
     * @param num 要找的值
     * @return 返回索引位置
     */
    public static int findTheRightIndexOfTheSpecifiedValueInTheArray(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        int result = -1;
        while (l <= r) {
            int middleIndex = l + ((r - l) >> 1);
            if (arr[middleIndex] <= num) {
                result = middleIndex;
                l = middleIndex + 1;
            } else {
                r = middleIndex - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 有序数组
        int[] arr = new int[]{1, 2, 5, 7, 9, 10, 12, 14, 15, 18};
        System.out.println(baseBinaruSearch(arr, 9));
        // true
        System.out.println(baseBinaruSearch(arr, 3));
        // false

        int[] arr1 = new int[]{3, 6, 6, 7, 9, 13, 13, 13, 13, 17, 24};
        System.out.println(findTheLeftIndexOfTheSpecifiedValueInTheArray(arr1, 5));
        // 1
        System.out.println(findTheLeftIndexOfTheSpecifiedValueInTheArray(arr1, 0));
        // 0
        System.out.println(findTheLeftIndexOfTheSpecifiedValueInTheArray(arr1, 7));
        // 3
        System.out.println(findTheLeftIndexOfTheSpecifiedValueInTheArray(arr1, 8));
        // 4
        System.out.println(findTheLeftIndexOfTheSpecifiedValueInTheArray(arr1, 9));
        // 4
        System.out.println(findTheLeftIndexOfTheSpecifiedValueInTheArray(arr1, 25));
        // -1

        System.out.println(findTheRightIndexOfTheSpecifiedValueInTheArray(arr1, 25));
        // 10
        System.out.println(findTheRightIndexOfTheSpecifiedValueInTheArray(arr1, 14));
        // 8
        System.out.println(findTheRightIndexOfTheSpecifiedValueInTheArray(arr1, 1));
        // -1
    }
}
