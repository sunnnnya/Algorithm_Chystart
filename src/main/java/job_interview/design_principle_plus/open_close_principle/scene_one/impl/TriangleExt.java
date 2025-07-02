package job_interview.design_principle_plus.open_close_principle.scene_one.impl;

import job_interview.design_principle_plus.open_close_principle.scene_one.IShape;

/**
 * @BelongsPackage: job_interview.design_principle_plus.open_close_principle
 * @ClassName: Triangle
 * @Author: 丛虹羽
 * @Date: 2025/5/15 21:40
 * @Description: 三角形
 */
public class TriangleExt implements IShape {

    /**
     * 底边
     */
    private final Double base;

    /**
     * 高
     */
    private final Double height;

    /**
     * 构造函数
     * 
     * @param base 底边
     * @param height 高
     */
    public TriangleExt(Double base, Double height) {
        this.base = base;
        this.height = height;
    }

    /**
     * 计算面积
     * 
     * @return 面积
     */
    @Override
    public Double area() {
        return 0.5 * base * height;
    }
} 