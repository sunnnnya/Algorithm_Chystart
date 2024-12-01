package basic_knowledge.sort.base_sort;

/**
 * @BelongsPackage: basic_knowledge.sort.base_sort
 * @ClassName: CountSort
 * @Author: 丛虹羽
 * @Date: 2024/8/7 上午9:19
 * @Description: 计数排序
 */
public class CountSort {

    /**
     * 计数排序，对数据量的规模有一定的要求
     *
     * @param arr
     */
    public static void countSort(int[] arr) {
       // MAXN 表示数据的范围
       int MAXN = 201;
       int[] count = new int[MAXN];
       for (int number : arr) {
           count[number]++;
       }
       for (int i = 0; i < MAXN; i++) {
           for(int j = 0; j < count[i]; j++) {
               System.out.print(i + " ");
           }
       }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {10, 2, 4, 5 ,2 ,1 ,7, 100, 2, 10, 21};
        countSort(arr);
        // 1 2 2 2 4 5 7 8 10 10
    }
}