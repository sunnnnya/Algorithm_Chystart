package job_interview.java_base_syntax_keyword.private_keyword_extends;

import lombok.*;

/**
 * @BelongsPackage: job_interview.java_base_syntax_keyword.private_keyword_extends
 * @ClassName: AbstractStrategyHandler
 * @Author: 丛虹羽
 * @Date: 2025/7/2 14:31
 * @Description: 抽象策略处理类，含有 value 属性，并提供 getter 和 setter 方法
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractStrategyHandler {

    private String value;

}
