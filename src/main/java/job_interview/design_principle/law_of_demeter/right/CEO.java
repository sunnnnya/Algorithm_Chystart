package job_interview.design_principle.law_of_demeter.right;

/**
  * @BelongsPackage: job_interview.design_principle.law_of_demeter.right 
  * @ClassName: CEO   
  * @Author: 丛虹羽                 
  * @Date: 2025/5/15 22:23           
  * @Description: CEO 类
  */
class CEO {
    public void manageCompany(DepartmentManager manager) {
        manager.assignWork();  // CEO 只调用部门经理的方法
    }
}
