package job_interview.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @BelongsPackage: job_interview.linked_hash_map
 * @ClassName: LinkedHashMapT
 * @Author: 丛虹羽
 * @Date: 2024/8/10 上午10:35
 * @Description: linkedHashMap相关面试测试题（和遍历的方式有关系）
 */
public class LinkedHashMapT {

    /**
     * 在LinkedHashMap遍历过程中不能修改结构 -> 抛异常
     *
     * @param args
     */
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");

        // 增强for循环使用iterator进行遍历，同样抛错
        for (String str : map.keySet()) {
            if (str.equals("three")) {
                map.put("five", "5");
            }
            System.out.println("key: " + str + ", value: " + map.get(str));
        }

        // 增强for循环使用iterator进行遍历，同样抛错
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals("three")) {
                map.put("five", "5");
            }
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
