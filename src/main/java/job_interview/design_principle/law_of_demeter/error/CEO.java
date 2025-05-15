package job_interview.design_principle.law_of_demeter.error;

/**
 * @BelongsPackage: job_interview.design_principle.law_of_demeter.error
 * @ClassName: CEO
 * @Author: 丛虹羽
 * @Date: 2025/5/15 22:19
 * @Description: CEO 类
 */
public class CEO {

    /**
     * 出现了链式调用
     *
     * @param manager
     */
    public void manageCompany(DepartmentManager manager) {
        // 直接调用链：CEO → DepartmentManager → Employee
        manager.getEmployee().work();  // 违反迪米特原则！
    }
}
