package job_interview.design_principle_plus.open_close_principle.scene_one.test;

import job_interview.design_principle_plus.open_close_principle.scene_one.IShape;
import job_interview.design_principle_plus.open_close_principle.scene_one.impl.Circle;
import job_interview.design_principle_plus.open_close_principle.scene_one.impl.Rectangle;
import job_interview.design_principle_plus.open_close_principle.scene_one.impl.TriangleExt;
import job_interview.design_principle_plus.open_close_principle.scene_one.shape_area.ShapeAreaCalculator;

/**
 * @BelongsPackage: job_interview.design_principle_plus.open_close_principle.scene_one.test
 * @ClassName: ApiTest
 * @Author: 丛虹羽
 * @Date: 2025/7/2 12:09
 * @Description: 测试类
 */
public class ApiTest {

    /**
     * 测试方法
     * 
     * @param args 参数
     */
    public static void main(String[] args) {
        Circle circle = new Circle(10.0);
        Rectangle rectangle = new Rectangle(10.0, 20.0);
        TriangleExt triangleExt = new TriangleExt(10.0, 20.0);

        System.out.println("圆形的面积：" + circle.area());
        System.out.println("矩形的面积：" + rectangle.area());
        System.out.println("拓展三角形的面积：" + triangleExt.area());

        IShape[] shapes = new IShape[]{circle, rectangle, triangleExt};

        ShapeAreaCalculator shapeAreaCalculators = new ShapeAreaCalculator();
        Double totalShapesArea = shapeAreaCalculators.totalShapes(shapes);
        System.out.println("totalShapesArea = " + totalShapesArea);
    }
}
