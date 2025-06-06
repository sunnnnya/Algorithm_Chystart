package job_interview.design_pattern.structural_pattern.proxy_pattern.dynamic_pattern.jdk_dynamic_pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @BelongsPackage: job_interview.design_pattern.structural_pattern.proxy_pattern.dynamic_pattern
 * @ClassName: DebugInvocationHandler
 * @Author: 丛虹羽
 * @Date: 2025/6/6 10:37
 * @Description: 实现 InvocationHandler 接口
 */
public class DebugInvocationHandler implements InvocationHandler {

    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after method " + method.getName());
        return result;
    }
}
