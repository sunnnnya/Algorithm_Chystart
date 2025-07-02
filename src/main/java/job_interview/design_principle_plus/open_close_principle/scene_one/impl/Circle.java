package job_interview.design_principle_plus.open_close_principle.scene_one.impl;

import job_interview.design_principle_plus.open_close_principle.scene_one.IShape;

/**
 * @BelongsPackage: job_interview.design_principle_plus.open_close_principle
 * @ClassName: Circle
 * @Author: 丛虹羽
 * @Date: 2025/5/15 21:33
 * @Description: 圆形
 */
public class Circle implements IShape {

    /**
     * 半径
     */
    private final Double radius;

    /**
     * 构造函数
     * 
     * @param radius 半径
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * 计算面积
     * 
     * @return 面积
     */
    public Double area() {
        return Math.PI * radius * radius;
    }
}