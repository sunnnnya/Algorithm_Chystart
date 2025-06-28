package job_interview.juc.create_thread.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsPackage: job_interview.juc.create_thread.po
 * @ClassName: User
 * @Author: 丛虹羽
 * @Date: 2025/6/28 16:03
 * @Description: 用户信息实体
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userName;
    private Integer age;
}
