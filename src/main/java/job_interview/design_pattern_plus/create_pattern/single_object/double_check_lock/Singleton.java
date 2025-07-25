package job_interview.design_pattern_plus.create_pattern.single_object.double_check_lock;


/**
 * @BelongsPackage: job_interview.design_pattern_plus.create_pattern.single_object.double_check_lock
 * @ClassName: Singleton
 * @Author: 丛虹羽
 * @Date: 2025/7/25 21:24
 * @Description: DCL 实现单利模式
 */
public class Singleton {

    private static volatile Singleton instance = null;

    private Singleton() {

    }

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
