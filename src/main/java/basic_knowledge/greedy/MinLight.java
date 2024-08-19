package basic_knowledge.greedy;

/**
 * @BelongsPackage: basic_knowledge.greedy
 * @ClassName: Demo
 * @Author: 丛虹羽
 * @Date: 2024/8/19 上午9:57
 * @Description: 贪心策略基本题目
 *
 * 问题描述：给定一个字符串 str，只由 X 和 . 两种字符构成；
 *      （1）'X'：表示墙，不能放灯，可以 被照亮 或 不被照亮；
 *      （2）'.'：表示居民点，可以放灯或者不放灯，但一定需要被点亮；
 *      （3）如果灯放在 i 位置，可以让 i-1，i 和 i+1 三个位置被点亮
 *      返回如果点亮 str 中所有需要点亮的位置，至少需要几盏灯？？？
 *  例子：
 *      X...X..X...X 需要三盏灯就可以点亮所有的.   X.{.}.X{.}.X.{.}.X
 */
public class MinLight {

    /**
     * 使用贪心策略
     *
     * @param road
     * @return
     */
    public static int minLight(String road) {
        char[] str = road.toCharArray();
        int index = 0;
        int light = 0;
        while (index < road.length()) {
            if (str[index] == 'X') {
                index++;
            } else {
                light++;
                if (index + 1 == road.length()) {
                    break;
                } else {
                    // 出现 .X 直接设置一个灯，然后走两步就可以了
                    if (str[index + 1] == 'X') {
                        index += 2;
                    } else {
                        // 出现 ..x 或 ...设置一个灯{.}.x 或 .{.}.，然后走三步就可以了
                        index += 3;
                    }
                }
            }
        }
        return light;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "X....X..X.X..X"; // -> X.{.}.{.}X{.}.X{.}X{.}.X
        System.out.println(minLight(str));
        // 5
    }
}
