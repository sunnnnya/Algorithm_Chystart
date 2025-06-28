package job_interview.javase.datatime_test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @BelongsPackage: job_interview.javase.datatime_test
 * @ClassName: LocalDateTimeTest
 * @Author: 丛虹羽
 * @Date: 2025/6/28 16:16
 * @Description: LocalDateTime 类的使用
 */
public class LocalDateTimeTest {

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // firstDayOfMonth()
        LocalDateTime firstDayOfMonth = localDateTime.with(TemporalAdjusters.firstDayOfMonth());
        String firstDayOfMonthString = firstDayOfMonth.format(dateTimeFormatter);
        System.out.println("firstDayOfMonthString = " + firstDayOfMonthString);

        // lastDayOfMonth
        LocalDateTime lastDayOfMonth = localDateTime.with(TemporalAdjusters.lastDayOfMonth());
        String lastDayOfMonthString = lastDayOfMonth.format(dateTimeFormatter);
        System.out.println("lastDayOfMonthString = " + lastDayOfMonthString);
    }
}
