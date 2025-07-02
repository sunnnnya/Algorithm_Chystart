package job_interview.javase.reflection_test.method;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @BelongsPackage: job_interview.javase.reflection.method
 * @ClassName: ReflectionMethod
 * @Author: 丛虹羽
 * @Date: 2025/6/22 22:36
 * @Description: 反射方法
 */
public class ReflectionMethod {

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) throws Exception{
        Class<?> studentClazz = Class.forName("job_interview.javase.reflection_test.method.ReflectionMethod$Student");

        Constructor<?> constructor = studentClazz.getConstructor(String.class, Integer.class, Double.class);
        Object student = constructor.newInstance("chystart", 18, 99.8);

        for (Method method : studentClazz.getDeclaredMethods()) {
            System.out.println("name: -> " + method.getName());
        }

        Method studyLanguage = studentClazz.getDeclaredMethod("studyLanguage", String.class);
        studyLanguage.setAccessible(true);
        Object res = studyLanguage.invoke(student, "English");
        System.out.println("english = " + res);

        // getMethods
        for (Method method : studentClazz.getMethods()) {
            System.out.println("name: => " + method.getName());
        }
    }

    /**
     * 内部类
     */
    public static class Student {
        private String name;
        private Integer age;
        private Double score;

        public Student() {}

        public Student(String name, Integer age, Double score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }

        private String studyLanguage(String language) {
            return this.name + " like study " + language;
        }

        public Double getScoreFromMath() {
            return this.score;
        }
    }
}
