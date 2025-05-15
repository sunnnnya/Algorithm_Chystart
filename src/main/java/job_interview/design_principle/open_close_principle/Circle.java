package job_interview.design_principle.open_close_principle;

/**
 * @BelongsPackage: job_interview.design_principle.open_close_principle
 * @ClassName: Circle
 * @Author: 丛虹羽
 * @Date: 2025/5/15 21:33
 * @Description: 圆形的计算类：有自己的半径
 */
public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}