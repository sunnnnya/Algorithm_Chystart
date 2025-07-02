package job_interview.design_principle_plus.open_close_principle.scene_one.impl;

import job_interview.design_principle_plus.open_close_principle.scene_one.IShape;

/**
 * @BelongsPackage: job_interview.design_principle_plus.open_close_principle
 * @ClassName: Rectangle
 * @Author: 丛虹羽
 * @Date: 2025/5/15 21:32
 * @Description: 矩形
 */
public class Rectangle implements IShape {

    /**
     * 宽
     */
    private final Double width;

    /**
     * 高
     */
    private final Double height;

    /**
     * 构造函数
     * 
     * @param width 宽
     * @param height 高
     */
    public Rectangle(Double width, Double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * 计算面积
     * 
     * @return 面积
     */
    public Double area() {
        return width * height;
    }
}