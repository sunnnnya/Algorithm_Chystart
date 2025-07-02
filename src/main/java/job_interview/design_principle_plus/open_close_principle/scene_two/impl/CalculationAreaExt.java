package job_interview.design_principle_plus.open_close_principle.scene_two.impl;

/**
 * @BelongsPackage: job_interview.design_principle_plus.open_close_principle.scene_two.impl
 * @ClassName: CalculationAreaExt
 * @Author: 丛虹羽
 * @Date: 2025/7/2 12:21
 * @Description: 扩展继承，实现自己的需求
 */
public class CalculationAreaExt extends CalculationArea{

    private final static double π = 3.141592653D;

    /**
     * 圆形面积计算
     *
     * @param r 半径
     * @return 面积
     */
    @Override
    public double circular(double r) {
        return π * r * r;
    }
}
