package job_interview.design_principle.law_of_demeter.right;

/**
 * @BelongsPackage: job_interview.design_principle.law_of_demeter.right
 * @ClassName: DepartmentManager
 * @Author: 丛虹羽
 * @Date: 2025/5/15 22:22
 * @Description: 部门经理类（封装员工管理逻辑）
 */
class DepartmentManager {
    private Employee employee = new Employee();

    /**
     * 不再暴露 Employee，而是提供任务分配方法
     */
    public void assignWork() {
        employee.work();  // 部门经理自己管理员工
    }
}
