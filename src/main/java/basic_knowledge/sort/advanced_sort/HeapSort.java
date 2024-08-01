package basic_knowledge.sort.advanced_sort;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.sort.advanced_sort
 * @ClassName: Heap
 * @Author: 丛虹羽
 * @Date: 2024/7/31 上午9:22
 * @Description: 使用数组模拟堆结构 + 堆排序
 * i 父节点 -> 左孩子 = 2 * i + 1
 * i 父节点 -> 右孩子 = 2 * i + 2
 * i 左/右孩子 -> 父亲 (i - 1) / 2
 */
public class HeapSort {

    /**
     * 交换数组中指定两个下标位置的元素
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 现在某个数处在 index 下标索引的位置，需要向上进行替换，从而形成大根堆或者小根堆
     * 从 下 -> 上
     * 大根堆
     * @param arr    数组
     * @param index  下标 *
     */
    public static void heapInsert(int[]arr, int index) {
        // while 条件终止两个情况：（1）当前节点并不比父亲节点大、（2）index = 0时,arr[0] == arr[0]
        while(arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;  // 移动
        }
    }

    /**
     * 从 index = 0 的位置向下移动交换，形成大根堆或小根堆
     * 从 上 -> 下
     *
     * @param arr
     * @param index
     * @param heapSize
     */
    public static void heapIfy(int[] arr, int index, int heapSize) {
        int leftChild = 2 * index + 1;
        // 还有左孩子的时候
        while (leftChild < heapSize) {
            // 有右孩子，找到左右孩子中数组更大的那个索引下标
            int largeIndex = ((leftChild + 1 < heapSize) && (arr[leftChild] > arr[leftChild + 1]))
                    ? leftChild : leftChild + 1;
            // 找到父亲，左右孩子中数值大的索引下标
            largeIndex = arr[largeIndex] > arr[index] ? largeIndex : index;
            // 如果当前节点最大，则不进行交换
            if (largeIndex == index) {
                break;
            }
            swap(arr, index, largeIndex);
            // 节点改为 最大的节点下标索引
            index = largeIndex;
            // 移动后得到节点的左孩子
            leftChild = 2 * index + 1;
        }
    }

    /**
     * 堆排序
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return ;
        }
        // 初始化堆 形成大根堆或者小根堆
        // 本案例：初始化成大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        System.out.println("--------check---------");
        System.out.println(Arrays.toString(arr));
        System.out.println("--------check---------");
        // heapSize表示堆的大小
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            // 始终都是堆顶的元素做 heapIfy
            heapIfy(arr, 0, --heapSize);
            swap(arr, 0, heapSize);
        }
    }

    /**
     * 测试
     * 使用系统提供的优先队列（堆结构），不能进行值的修改，如果堆结构要重新调整，只能重新全部扫描一下。
     * 手写的可以对指定节点进行修改，看heapify或者heapinsert
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {10, 6, 2, 3, 4, 5, 1, 8, 9, 12, 21, 67};
        // heapSize = 12
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
