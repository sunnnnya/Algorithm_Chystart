package job_interview.design_principle.open_close_principle;

/**
 * @BelongsPackage: job_interview.design_principle.open_close_principle
 * @ClassName: ShapeAreaCalculator
 * @Author: 丛虹羽
 * @Date: 2025/5/15 21:34
 * @Description: 拓展类，依赖于具体的实现
 */
public class ShapeAreaCalculator {

    /**
     * 依赖于抽象
     *
     * @param shapes 图形数组
     * @return double
     */
    static double totalArea(Shape[] shapes) {
        double total = 0;
        for (Shape shape : shapes) {
            total += shape.area();
        }
        return total;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(12.0, 5.0);
        Circle circle = new Circle(2);
        Shape[] shapes = new Shape[2];
        shapes[0] = rectangle;
        shapes[1] = circle;
        System.out.println(totalArea(shapes));
        // 72.56637061435917
    }
}