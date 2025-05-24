package basic_knowledge.keyword;

/**
 * @BelongsPackage: basic_knowledge.keyword
 * @ClassName: Finally
 * @Author: 丛虹羽
 * @Date: 2025/5/24 22:04
 * @Description: Finally 关键字相关测试
 */
public class FinallyKeyWordTest {

    /**
     * 测试 finally 关键字的使用
     *  在 finally 语句块中使用 return 会覆盖 try 和 catch 中的 return
     *
     * @return int
     */
    static int testFinallyKeyWord(){
        int x = 10;
        try {
            x = 20;
            System.out.println(5 / 0);
            return x;
        } catch (Exception e) {
            x = 30;
            return x;
        } finally {
            x = 40;
            return x;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(testFinallyKeyWord());
        // 40
    }
}
