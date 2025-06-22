package job_interview.javase.keyword.transient_kw;

import com.alibaba.fastjson2.JSON;

/**
 * @BelongsPackage: job_interview.javase.keyword.transient_kw
 * @ClassName: TransientKeyword
 * @Author: 丛虹羽
 * @Date: 2025/6/22 20:50
 * @Description: 测试 transient 关键字
 */
public class TransientKeyword {

    /**
     * 测试 transient 关键字
     *
     * @param args 参数列表
     */
    public static void main(String[] args) {
        Person person = new Person("chystart", 21, "232332200045144478");
        String personJsonString = JSON.toJSONString(person);
        System.out.println("personJsonString = " + personJsonString);
        // personJsonString = {"age":21,"name":"chystart"}
    }

    public static class Person {
        private String name;
        private Integer age;
        private transient String idCard;

        public Person() {}

        public Person(String name, Integer age, String idCard) {
            this.name = name;
            this.age = age;
            this.idCard = idCard;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }
    }
}
