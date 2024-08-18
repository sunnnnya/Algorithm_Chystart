package basic_knowledge.greedy;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.greedy
 * @ClassName: Meeting
 * @Author: 丛虹羽
 * @Date: 2024/8/18 下午10:04
 * @Description: 贪心的典型题目
 *
 * 说明：一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲，
 *      给你每一个项目 开始的时间 和 结束的时间 你来安排宣讲的日程，
 *      要求会议室进行的宣讲的场次最多。返回最多的宣讲场次。
 *
 * 思路：
 *      （1）按会议的 开始时间 进行排序选择：
 *           反例：[1, 15], [2, 4], [5, 6], [8, 10], [12, 14]，如果只按照开始时间进行排序的话，就只能安排[1, 15]一个节目（x）
 *              但最优解是：[2, 4],[5, 6],[8,10],[12,14]
 *      （2）按会议的 间隔时间短 进行排序：
 *           反例：[1, 27],[24, 29], [28, 100]，如果按照间隔时间短选择的话[24, 29]（x）
 *              但最优解是：[1, 27],[28,100]
 *      （3）按会议的 结束时间 进行排序选择：
 *           |_|      （选择）
 *           1 2
 *           |____|  （不选择）
 *           1    5
 *             |___|  （选择）
 *             3   6
 *            |______| （不选择）
 *            2      8
 *             |________| （不选择）
 *             3        11
 */
public class BestArrangeMeeting {

    /**
     * 会议的实体
     */
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 安排会议函数
     *
     * @param programs
     * @return
     */
    public static int bestArrange(Program[] programs) {
        Arrays.sort(programs, (o1, o2) -> o1.end - o2.end);
        int timeLine = 0;
        int result = 0;
        for (Program program : programs) {
            // 如果当前节目的开始时间 > 上一个选中节目的结束时间 -> 统计
            if (program.start >= timeLine) {
                // 更新会议的结束时间为当前选中的会议的结束时间
                timeLine = program.end;
                ++result;
            }
        }
        return result;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        Program program1 = new Program(1, 2);
        Program program2 = new Program(1, 5);
        Program program3 = new Program(3, 6);
        Program program4 = new Program(2, 8);
        Program program5 = new Program(3, 11);
        Program[] programs = new Program[]{program1, program2, program3, program4, program5};
        System.out.println(bestArrange(programs));
        // 2

        Program program6 = new Program(1, 2);
        Program program7 = new Program(1, 4);
        Program program8 = new Program(2, 9);
        Program program9 = new Program(3, 10);
        Program program10 = new Program(9, 12);
        Program[] programs1 = new Program[]{program6, program7, program8, program9, program10};
        System.out.println(bestArrange(programs1));
        // 3
    }
}
