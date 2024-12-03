package basic_knowledge.random.easy;

/**
 * @BelongsPackage: basic_knowledge.random.easy
 * @ClassName: RandomToRandom
 * @Author: 丛虹羽
 * @Date: 2024/12/3 下午3:53
 * @Description: 随机概率变成其他随机概率
 */
public class RandomToRandom {

    /**
     * Math.random()           -> 返回[0, 1)的所有小数，等概率返回一个
     * Math.random()* N        -> 返回[0, N)的所有小数，等概率返回一个
     * (int)(Math.random()* N) -> 返回[0, N-1]所有的整数，等概率返回一个
     */

    /**
     * 等概率随机返回 1 ~ 5，理解为系统提供的函数
     *
     * @return
     */
    public static int f() {
        return (int)(Math.random() * 5) + 1;
    }

    /**
     * 变成等概率0、1发生器，重点：构造出来等概率 0、1 发生器
     *
     * @return
     */
    public static int f2() {
        int ans = 0;
        do {
            ans = f();
        } while(ans == 3); // 表示等于 3 的时候重新生成，这样就变成1 2 -> 0 、4 5 -> 1的等概率发生器
        return ans <= 2 ? 0 : 1;
    }

    /**
     * 使用等概率0、1发生器拼成0 ~ 7 随机 000 ~ 111
     *
     * @return
     */
    public static int f3() {
        return (f2() << 2) + (f2() << 1) + (f2() << 0);
    }

    /**
     * 过滤掉 0 变成 1 ~ 7之间随机
     *
     * @return
     */
    public static int f4() {
        int ans = 0;
        do {
            ans = f3();
        } while(ans == 0);
        return ans;
    }

    /**
     * 测试是否等概率
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < 10000; i++) {
            arr[f4()]++;
        }
        for (int i = 1; i <= 7; i++) {
            System.out.println(i + "出现的次数是：" + arr[i]);
        }
    }
}