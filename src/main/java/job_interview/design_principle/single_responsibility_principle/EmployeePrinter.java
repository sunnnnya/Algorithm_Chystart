package job_interview.design_principle.single_responsibility_principle;

/**
 * @BelongsPackage: job_interview.design_principle.single_responsibility_principle
 * @ClassName: EmployeePrinter
 * @Author: 丛虹羽
 * @Date: 2025/5/15 21:29
 * @Description: 只负责打印员工信息，不做其他的操作
 */
public class EmployeePrinter {
    public void print(Employee employee) {
        System.out.println("员工ID: " + employee.getId());
        System.out.println("员工姓名: " + employee.getName());
        System.out.println("所属部门: " + employee.getDepartment());
    }
}
