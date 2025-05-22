package job_interview.design_pattern.creational_pattern.singleton_pattern.lazy;

/**
 * @BelongsPackage: job_interview.design_pattern.creational_pattern.singleton_pattern.lazy
 * @ClassName: Singleton
 * @Author: 丛虹羽
 * @Date: 2025/5/8 22:57
 * @Description: 懒汉式单例模式
 * https://blog.csdn.net/weixin_38983929/article/details/103006376
 */
public class Singleton {

    private Singleton() {}

    private static volatile Singleton instance;

    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
