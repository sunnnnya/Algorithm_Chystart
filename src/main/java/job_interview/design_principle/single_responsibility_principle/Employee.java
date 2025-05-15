package job_interview.design_principle.single_responsibility_principle;

/**
 * @BelongsPackage: job_interview.design_principle.single_responsibility_principle
 * @ClassName: Employe
 * @Author: 丛虹羽
 * @Date: 2025/5/15 21:26
 * @Description: Employee：只负责员工信息管理，不去做其他的事情
 */
public class Employee {
    private String id;
    private String name;
    private String department;

    public Employee(String id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getter 和 Setter 只涉及员工信息，不做其他的操作
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}