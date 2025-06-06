package job_interview.design_pattern.structural_pattern.proxy_pattern.dynamic_pattern.jdk_dynamic_pattern;

import java.lang.reflect.Proxy;

/**
 * @BelongsPackage: job_interview.design_pattern.structural_pattern.proxy_pattern.dynamic_pattern
 * @ClassName: Main
 * @Author: 丛虹羽
 * @Date: 2025/6/6 10:40
 * @Description: 测试类
 */
public class Main {
    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        // 被代理对象
        SmsServiceImpl smsService = new SmsServiceImpl();
        // 创建出来代理对象
        SmsService smsServiceProxy = (SmsService)Proxy.newProxyInstance(Main.class.getClassLoader(),
                smsService.getClass().getInterfaces(),
                new DebugInvocationHandler(smsService));
        // 执行代理对象
        String send = smsServiceProxy.send("hello,world");
        System.out.println("send = " + send);
    }
}
