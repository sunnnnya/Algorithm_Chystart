package job_interview.design_pattern.creational_pattern.singleton_pattern.hungry;

/**
 * @BelongsPackage: job_interview.design_pattern.creational_pattern.singleton_pattern.hungry
 * @ClassName: Singleton
 * @Author: 丛虹羽
 * @Date: 2025/5/22 14:32
 * @Description: 饿汉式单例设计模式
 */
public class Singleton {

    private Singleton() {}

    private static final Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
