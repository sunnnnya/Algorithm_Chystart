package basic_knowledge.sort.advanced_sort;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.heap
 * @ClassName: HeapSortII
 * @Author: 丛虹羽
 * @Date: 2024/12/6 下午8:59
 * @Description: 创建小根堆，实现从大到小进行排序
 */
public class HeapSortII {

    /**
     * 堆排序
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return ;
        }
        for(int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        while(heapSize > 0) {
            swap(arr, 0, --heapSize);
            heapify(arr, 0, heapSize);
        }
    }

    /**
     * heapify 操作
     * @param arr      原始数组
     * @param index    指定的索引
     * @param heapSize 堆的大小
     */
    public static void heapify(int[] arr, int index, int heapSize) {
        int leftIndex = 2 * index + 1;
        while(leftIndex < heapSize) {
            int minChildIndex = (leftIndex + 1 < heapSize && arr[leftIndex] > arr[leftIndex + 1]) ? leftIndex + 1 : leftIndex;
            minChildIndex = arr[index] < arr[minChildIndex] ? index : minChildIndex;
            if(index == minChildIndex) {
                break;
            }
            swap(arr, index, minChildIndex);
            index = minChildIndex;
            leftIndex = 2 * index + 1;
        }
    }

    /**
     * heapInsert 操作，生成小根堆
     *
     * @param arr   原始数组
     * @param index 索引
     */
    public static void heapInsert(int[] arr, int index) {
        while(arr[index] < arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 交换两个数值
     *
     * @param arr 原始数组
     * @param i   索引下标
     * @param j   索引下标
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{10, 2, 3, 4, 5, 3, 2, 1, 7, 21, 100};
        System.out.println("原始数组是：" + Arrays.toString(arr));
        // 原始数组是：[10, 2, 3, 4, 5, 3, 2, 1, 7, 21, 100]
        heapSort(arr);
        System.out.println("排序之后的数组是：" + Arrays.toString(arr));
        // 排序之后的数组是：[100, 21, 10, 7, 5, 4, 3, 3, 2, 2, 1]
    }
}