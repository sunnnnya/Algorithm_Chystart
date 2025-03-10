package leetcode.skill.array.binary_search;

/**
 * @package: leetcode.skill.array.binary_search
 * @author: chystart
 * @create: 2025-03-10 12:44
 * @description: 二分搜索 及其 拓展
 **/
public class BinarySearch {

    /**
     * 二分搜索基础算法 —— 查找某个数是否存在
     *
     * @param arr    原始数组
     * @param target 目标值
     * @return
     */
    public static int binarySearchEqualVal(int[] arr, int target) {
        if(arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0, r = arr.length - 1;
        // 一定要写 ==，否则会遗漏下来有些值没有判断！！
        while(l <= r) {
            int mid = r + ((l - r) >> 1);
            if(arr[mid] < target) {
                l = mid + 1;
            } else if(arr[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分搜索 —— 找到 >= target 最左的位置
     *
     * @param arr    原始数组
     * @param target 目标值
     * @return
     */
    public static int binarySearchMoreEqualVal(int[] arr, int target) {
        if(arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if(arr[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 二分搜索 —— 找到 <= target 最右的位置
     *
     * @param arr    原始数组
     * @param target 目标值
     * @return
     */
    public static int binarySearchLessEqualVal(int[] arr, int target) {
        if(arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if(arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 7, 10, 11, 13, 19, 20};
        System.out.println("index: " + binarySearchEqualVal(arr, 11));
        // index: 4

        int[] arr1 = new int[]{2, 5, 7, 10, 11, 13, 19, 20};
        System.out.println("index: " + binarySearchEqualVal(arr1, 14));
        // index: -1

        int[] arr2 = new int[]{2, 5, 7, 10, 10, 10, 19, 20};
        System.out.println("index: " + binarySearchMoreEqualVal(arr2, 10));
        // index: 3

        int[] arr3 = new int[]{2, 5, 7, 10, 10, 10, 19, 20};
        System.out.println("index: " + binarySearchMoreEqualVal(arr3, 19));
        // index: 6

        int[] arr4 = new int[]{2, 5, 7, 10, 10, 10, 19, 20};
        System.out.println("index: " + binarySearchLessEqualVal(arr4, 10));
        // index: 5
    }
}
