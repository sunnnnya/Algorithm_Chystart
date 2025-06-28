package job_interview.javase.datatime_test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @BelongsPackage: job_interview.javase.datatime_test
 * @ClassName: DataTimeTest
 * @Author: 丛虹羽
 * @Date: 2025/6/28 12:30
 * @Description: 有关 DataTime API Test
 */
public class DateTest {

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // SimpleDateFormat + Date
           // Date -> String
        String dateTimeFormatString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("dateTimeFormatString = " + dateTimeFormatString);

        String dateFormatString = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        System.out.println("dateFormatString = " + dateFormatString);

        String timeFormatString = new SimpleDateFormat("HH:mm:ss").format(new Date());
        System.out.println("timeFormatString = " + timeFormatString);

        System.out.println();

        // SimpleDateFormat + Date
            // String -> Date
        String dateString = "2025-12-04";
        Date parseDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        System.out.println("parseDate = " + parseDate);

        System.out.println();

        // LocalDateTime | LocalDate | LocalTime
        LocalDate date = LocalDate.now();
        System.out.println("LocalDate() -> " + date);

        LocalTime time = LocalTime.now().withNano(0);
        System.out.println("LocalTime() -> " + time);

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatLocalDateTimeString = localDateTime.format(dateTimeFormatter);
        System.out.println("LocalDateTime() + DateTimeFormatter() -> " + formatLocalDateTimeString);
    }
}
