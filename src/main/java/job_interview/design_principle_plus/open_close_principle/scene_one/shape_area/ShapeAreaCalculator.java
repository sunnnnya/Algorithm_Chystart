package job_interview.design_principle_plus.open_close_principle.scene_one.shape_area;

import job_interview.design_principle_plus.open_close_principle.scene_one.IShape;
import job_interview.design_principle_plus.open_close_principle.scene_one.IShapeService;

/**
 * @BelongsPackage: job_interview.design_principle_plus.open_close_principle
 * @ClassName: ShapeAreaCalculator
 * @Author: 丛虹羽
 * @Date: 2025/5/15 21:34
 * @Description: 拓展类，依赖于具体的实现
 */
public class ShapeAreaCalculator implements IShapeService {

    /**
     * 计算面积
     * 
     * @param shapes 图形数组
     * @return 面积
     */ 
    @Override
    public Double totalShapes(IShape[] shapes) {
        double total = 0;
        for (IShape shape : shapes) {
            total += shape.area();
        }
        return total;
    }
}