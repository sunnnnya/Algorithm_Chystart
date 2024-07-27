package basic_knowledge.compare;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.compare
 * @ClassName: Comparer
 * @Author: 丛虹羽
 * @Date: 2024/7/27 下午10:35
 * @Description: 比较器的使用
 */
public class Comparators {

    public static class Student {
        private String name;
        private Integer age;
        private Integer id;
        public Student(String name, Integer id, Integer age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", id=" + id +
                    '}';
        }
    }

    /**
     * 定义比较器
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 2, 1, 18, 21, 100, 82};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        Student jack = new Student("Jack", 5, 21);
        Student rose = new Student("Rose", 2, 18);
        Student mark = new Student("Mark", 1, 27);
        Student mary = new Student("Mary", 3, 34);

        Student[] students = {jack, rose, mark, mary};
        // 返回 负数 的时候，第一个参数放在前面。
        // 返回 正数 的时候，第二个参数放在前面。
        Arrays.sort(students, (o1, o2) -> o2.age - o1.age);
        System.out.println(Arrays.toString(students));
    }
}
