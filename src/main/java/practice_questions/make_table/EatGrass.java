package practice_questions.make_table;

/**
 * @BelongsPackage: practice_questions.make_table
 * @ClassName: EatGrass
 * @Author: 丛虹羽
 * @Date: 2024/7/24 上午12:46
 * @Description:
 * 知识点：递归 + 打表 + 博弈论
 * 分"先手"和"后手"，一个人只能吃4 ^ n的草（不能不吃），现在给你一个草的数量，问谁先赢（先吃完草的人赢）
 */
public class EatGrass {

    /**
     * 笨方法解题
     *
     * @param n
     * @return
     */
    public static String winner1(int n) {
        // 0  1  2  3  4
        // 后 先 后 先 先
        if (n < 5) {
            return (n == 0 || n == 2) ? "后手" : "先手";
        }
        // n >= 5：先手吃 1 份看自己能不能赢，吃 4 份看自己能不能赢，吃 16 份看自己能不能赢
        int base = 1; // 先手决定开始吃的草
        while (base <= n) {
            // 当前一共n份草，先手吃掉的是base份，n-base 是留给后手的草
            // 母过程 先手 在子过程里是 后手
            if (winner1(n - base).equals("后手")) { // 关键点
                return "先手";
            }
            if (base > n / 4) { // 防止出现溢出问题
                break;
            }
            base *= 4;
        }
        return "后手";
    }

    /**
     * 打表技巧题，使用笨方式拿到规律，然后使用简单的枚举进行加速
     *
     * @param n
     * @return
     */
    public static String winner2(int n) {
        return (n % 5 == 1 || n % 5 == 3 || n % 5 == 4) ? "先手" : "后手";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 80; i++) {
            System.out.println("grass: " + i + ", winner" + winner1(i));
        }
    }
}
