package job_interview.design_principle_plus.open_close_principle.scene_two.test;

import job_interview.design_principle_plus.open_close_principle.scene_two.impl.CalculationArea;
import job_interview.design_principle_plus.open_close_principle.scene_two.impl.CalculationAreaExt;

/**
 * @BelongsPackage: job_interview.design_principle_plus.open_close_principle.scene_two.test
 * @ClassName: ApiTest
 * @Author: 丛虹羽
 * @Date: 2025/7/2 12:23
 * @Description: 测试类
 */
public class ApiTest {

    /**
     * 测试方法
     * 
     * @param args 参数
     */
    public static void main(String[] args) {
        CalculationArea calculationArea = new CalculationAreaExt();
        System.out.println("圆形面积：" + calculationArea.circular(10.0));
    }
}
