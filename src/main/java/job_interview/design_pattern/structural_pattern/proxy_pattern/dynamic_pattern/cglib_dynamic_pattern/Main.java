package job_interview.design_pattern.structural_pattern.proxy_pattern.dynamic_pattern.cglib_dynamic_pattern;

import net.sf.cglib.proxy.Enhancer;

/**
 * @BelongsPackage: job_interview.design_pattern.structural_pattern.proxy_pattern.dynamic_pattern.cglib_dynamic_pattern
 * @ClassName: Main
 * @Author: 丛虹羽
 * @Date: 2025/6/6 10:53
 * @Description: 测试类
 */
public class Main {
    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(Main.class.getClassLoader());
        enhancer.setSuperclass(AliSmsService.class);
        enhancer.setCallback(new DebugInterceptor());

        AliSmsService smsService = (AliSmsService) enhancer.create();
        smsService.sendMessage("hello, chystart!");
    }
}
