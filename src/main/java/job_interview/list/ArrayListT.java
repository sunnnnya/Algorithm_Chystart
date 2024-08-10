package job_interview.list;

import java.util.ArrayList;

/**
 * @BelongsPackage: job_interview.list
 * @ClassName: ArrayListT
 * @Author: 丛虹羽
 * @Date: 2024/8/10 上午10:53
 * @Description: 测试ArrayList在遍历的时候插入值会不会产生错误（和遍历的方式有关系）
 */
public class ArrayListT {

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // 使用普通for循环： Index 索引的方式进行遍历不会出现问题
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 3) {
                list.add(7);
            }
            System.out.println("list(" + i + "): " + list.get(i));
        }

        // 使用增强for循环：使用迭代器的方式就会出现ConcurrentModificationException异常
        for (int number : list) {
            if (number == 3) {
                list.add(7);
            }
            System.out.println("number: " + number);
        }
    }
}
