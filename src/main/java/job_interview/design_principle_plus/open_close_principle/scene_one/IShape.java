package job_interview.design_principle_plus.open_close_principle.scene_one;

/**
 * @BelongsPackage: job_interview.design_principle_plus.open_close_principle
 * @ClassName: Shape
 * @Author: 丛虹羽
 * @Date: 2025/5/15 21:32
 * @Description: 图形接口，支持扩展，不修改原有代码，只扩展
 */
public interface IShape {

    /**
     * 计算面积
     * 
     * @return 面积
     */
    Double area();

}
