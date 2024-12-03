package basic_knowledge.hash;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @BelongsPackage: basic_knowledge.hash
 * @ClassName: HashMapAndSortHashMap
 * @Author: 丛虹羽
 * @Date: 2024/8/1 下午9:44
 * @Description: 测试使用哈希表和顺序表
 *
 * 算法中一般都是使用 Hash表 进行词频统计，然后进行程序判断，必要的时候可以使用数组进行替换！！
 */
public class HashMapAndSortHashMap {

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("----------------------- HashMap -----------------------");
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1000, "我是1000");
        hashMap.put(4, "我是4");
        hashMap.put(5, "我是5");
        hashMap.put(6, "我是6");
        hashMap.put(7, "我是7");
        hashMap.put(100, "我是100");
        System.out.println(hashMap.get(4));          // 我是4
        System.out.println(hashMap.get(100));        // 我是100
        System.out.println(hashMap.containsKey(4));  // true
        System.out.println(hashMap.containsKey(99)); // false
        System.out.println(hashMap.remove(4));  // 我是4
        System.out.println(hashMap.get(4));          // null
        hashMap.put(100, "他是101");                  // 对 100 的 key 的 value 进行了覆盖
        System.out.println(hashMap.get(100));        // 他是101

        System.out.println("----------------------- TreeMap -----------------------");
        // TreeMap -> Java 底层使用红黑树实现，不会存储重复值，且有序， 确保存储的类需要可以进行比较，否则比较不了
        TreeMap<Integer, String> treeMap = new TreeMap<>((o1, o2) -> o2 - o1);
        treeMap.put(3, "我是3");
        treeMap.put(4, "我是4");
        treeMap.put(8, "我是8");
        treeMap.put(5, "我是5");
        treeMap.put(7, "我是7");
        treeMap.put(1, "我是1");
        treeMap.put(2, "我是2");
        System.out.println(treeMap.containsKey(1));  // true
        System.out.println(treeMap.containsKey(10)); // false
        System.out.println(treeMap.get(4));          // 我是4
        System.out.println(treeMap.get(10));         // null
        treeMap.put(4, "他是4");
        System.out.println(treeMap.get(4));          // 他是4
        treeMap.remove(4);
        // 对 key 有序的组织，本题使用从大到小
        System.out.println(treeMap.firstKey());      // 8
        System.out.println(treeMap.lastKey());       // 1
        // <= 4 离 4 最近的 key 是谁，默认从小到大，但这里是从大到小 -> 所以返回 5
        System.out.println(treeMap.floorKey(4));     // 5
        // >= 4 离4最近的key是谁
        System.out.println(treeMap.ceilingKey(4));   // 3
        // O(logN)
    }
}