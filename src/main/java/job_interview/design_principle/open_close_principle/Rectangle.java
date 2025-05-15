package job_interview.design_principle.open_close_principle;

/**
 * @BelongsPackage: job_interview.design_principle.open_close_principle
 * @ClassName: Rectangle
 * @Author: 丛虹羽
 * @Date: 2025/5/15 21:32
 * @Description: 矩形的计算类：有自己的宽和高
 */
public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double area() {
        return width * height;
    }
}