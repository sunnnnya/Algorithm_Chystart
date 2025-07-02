package job_interview.design_principle_plus.open_close_principle.scene_two.impl;

import job_interview.design_principle_plus.open_close_principle.scene_two.ICalculationArea;

/**
 * @BelongsPackage: job_interview.design_principle_plus.open_close_principle.scene_two.impl
 * @ClassName: CalculationArea
 * @Author: 丛虹羽
 * @Date: 2025/7/2 12:20
 * @Description: 面积计算实现
 */
public class CalculationArea implements ICalculationArea {

    /**
     * 圆周率
     */
    private final static double π = 3.14D;

    /**
     * 矩形面积计算
     * 
     * @param x 长
     * @param y 宽
     * @return 面积
     */
    public double rectangle(double x, double y) {
        return x * y;
    }

    /**
     * 三角形面积计算
     * 
     * @param x 边长1
     * @param y 边长2
     * @param z 边长3
     * @return 面积
     */
    public double triangle(double x, double y, double z) {
        double p = (x + y + z) / 2;
        return Math.sqrt(p * (p - x) * (p - y) * (p - z));
    }

    /**
     * 圆形面积计算
     * 
     * @param r 半径
     * @return 面积
     */
    public double circular(double r) {
        return π * r * r;
    }
}
