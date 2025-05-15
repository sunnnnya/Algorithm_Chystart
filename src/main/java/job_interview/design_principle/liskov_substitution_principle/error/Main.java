package job_interview.design_principle.liskov_substitution_principle.error;

/**
 * @BelongsPackage: job_interview.design_principle.liskov_substitution_principle.error
 * @ClassName: Main
 * @Author: 丛虹羽
 * @Date: 2025/5/15 22:30
 * @Description: 违反里氏代换原则
 */
public class Main {
    public static void main(String[] args) {
        // 子类替换不了父类，出现了结果不一致！！！
        Rectangle rect = new Square();
        rect.setWidth(5);
        rect.setHeight(4); // 预期面积是 5*4=20，但实际是 4*4=16
        System.out.println(rect.getArea()); // 输出 16，而非预期的 20
    }
}
