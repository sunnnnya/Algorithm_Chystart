package job_interview.design_principle.law_of_demeter.error;

/**
 * @BelongsPackage: job_interview.design_principle.law_of_demeter.error
 * @ClassName: DepartmentManager
 * @Author: 丛虹羽
 * @Date: 2025/5/15 22:19
 * @Description: 部门经理类
 */
class DepartmentManager {
    private Employee employee = new Employee();

    /**
     * 暴露了内部的 Employee 对象
     *
     * @return
     */
    public Employee getEmployee() {
        return employee;
    }
}
