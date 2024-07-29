package basic_knowledge.search.binary_search;

/**
 * @BelongsPackage: search
 * @ClassName: FindPeakElement
 * @Author: 丛虹羽
 * @Date: 2024/7/22 上午2:25
 * @Description: 获取山峰的峰值点
 * 知识点：无序数组使用二分
 * 分析得出是下坡还是上坡，来进行判断之间一定存在峰值点，然后进行二分
 *
 * leetcode：https://leetcode.cn/problems/find-peak-element/
 */
public class FindPeakElement {

    /**
     * 找到数组中的局部峰值
     *
     * @param arr
     * @return
     */
    public static int findPeakElement(int[] arr) {
        if(arr == null || arr.length == 0) {
            return -1;
        }
        // 左侧山峰
        if (arr.length == 1 || arr[0] > arr[1]) {
            return 0;
        }
        // 右侧山峰
        if (arr[arr.length - 1] > arr[arr.length - 2]) {
            return arr.length - 1;
        }
        // 二分判断山峰
        int l = 1;
        int r = arr.length - 2;
        int result = -1;
        while (l <= r) {
            int middleIndex = l + ((r - l) >> 1);
            //       / 斜右上山峰
            if (arr[middleIndex - 1] > arr[middleIndex]) {
                r = middleIndex - 1;
            }
            //      \ 斜右下山峰
            else if (arr[middleIndex] < arr[middleIndex + 1]) {
                l = middleIndex + 1;
            }
            // 上面两个条件都不满足，找到峰值点即返回；
            else {
                result = middleIndex;
                break;
            }
        }
        return result;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(arr));
        // 5

        int[] arr1 = new int[]{1, 2, 3, 1};
        System.out.println(findPeakElement(arr1));
        // 2
    }
}
