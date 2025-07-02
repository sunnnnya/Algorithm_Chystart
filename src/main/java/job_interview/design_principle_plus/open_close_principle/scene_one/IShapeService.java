package job_interview.design_principle_plus.open_close_principle.scene_one;

/**
 * @BelongsPackage: job_interview.design_principle_plus.open_close_principle.scene_one
 * @ClassName: IShapeService
 * @Author: 丛虹羽
 * @Date: 2025/7/2 12:04
 * @Description: 计算面积接口
 */
public interface IShapeService {

    /**
     * 计算面积
     * 
     * @param shapes 图形数组
     * @return 面积
     */ 
    Double totalShapes(IShape[] shapes);
}
