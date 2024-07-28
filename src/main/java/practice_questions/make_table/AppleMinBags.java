package practice_questions.make_table;

/**
 * @BelongsPackage: practice_questions.middle
 * @ClassName: AppleMinBags
 * @Author: 丛虹羽
 * @Date: 2024/7/24 上午12:11
 * @Description:
 * 描述：
 *      小虎去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装包装不可拆分。
 *      可是小虎现在只想购买恰好n个苹果，小虎想购买尽量少的袋数方便携带。
 *      如果不能购买恰好n个苹果，小虎将不会购买。输入一个整数n，表示小虎想购买的个苹果，返回最小使用多少袋子。
 *      如果无论如何都不能正好装下，返回 -1。
 */
public class AppleMinBags {

    /**
     * 初始解法：
     *     先用8的袋子进行装，如果装不满，看看剩余的数量用6的袋子装得满补，
     *     如果6的袋子装不满，8的袋子数 - 1， 看剩余的用 6袋子能不能装满
     *
     * @param apple
     * @return
     */
    public static int minBags(int apple) {
        if (apple < 0) {
            return -1;
        }
        int bag6 = -1;
        int bag8 = apple / 8;
        int rest = apple - bag8 * 8;
        // 加速点：24的确定
        // 24 既可以用 3 * 8 搞定 也可以用 4 * 6搞定，那为什么不用8袋子解决而用6袋子解决，故判定24
        while(bag8 >= 0 && rest < 24) {
            int restUse6 = minBagBase6(rest);
            if (restUse6 != -1) {
                bag6 = restUse6;
                break;
            }
            rest = apple - (--bag8 * 8);
        }
        return bag6 == -1 ? -1 : bag6 + bag8;
    }

    /**
     * 如果剩余苹果rest可以被装6个苹果的袋子搞定，返回袋子数量
     * 不能搞定返回 -1
     *
     * @param rest
     * @return
     */
    public static int minBagBase6(int rest) {
        return rest % 6 == 0 ? rest / 6 : -1;
    }

    /**
     * 技巧: 《打表》，针对一个值输入一个值，输出的题，先用暴力解题，然后找规律
     * 总结结果
     *
     * @param apple
     * @return
     */
    public static int minBagAwesome(int apple) {
        if ((apple & 1) != 0) { // 如果是奇数，返回-1
            return -1;
        }
        if (apple < 18) {
            return apple == 0 ? 0 : (apple == 6 || apple == 8) ? 1
                    : (apple == 12 || apple == 14 || apple == 16) ? 2 : -1;
        }
        return (apple - 18) / 8 + 3;
    }

    public static void main(String[] args) {
        for(int i = 1; i < 100; i++) {
            System.out.println("apple:" + i + ", bags: " + minBags(i));
        }
    }
}
