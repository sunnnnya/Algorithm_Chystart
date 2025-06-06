package job_interview.design_pattern.structural_pattern.proxy_pattern.dynamic_pattern.cglib_dynamic_pattern;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @BelongsPackage: job_interview.design_pattern.structural_pattern.proxy_pattern.dynamic_pattern.cglib_dynamic_pattern
 * @ClassName: DebugInterceptor
 * @Author: 丛虹羽
 * @Date: 2025/6/6 10:51
 * @Description: 实现 MethodInterceptor
 */
public class DebugInterceptor implements MethodInterceptor {

    /**
     * 增强逻辑
     *
     * @param o           被代理的对象（需要增强的对象）
     * @param method      被拦截的方法（需要增强的方法）
     * @param args        方法入参
     * @param methodProxy 用于调用原始方法
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method " + method.getName());
        Object result = methodProxy.invokeSuper(o, args);
        System.out.println("after method " + method.getName());
        return result;
    }
}
