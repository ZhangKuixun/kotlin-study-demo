package com.kevin.java8;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * other：Kevin
 * create time：2021/7/3
 * describe：
 */
public class Tom5 {
    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.getZone());

        System.out.println("-------获取本地时间");
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        System.out.println("-------获取对于时区的本地时间");
        LocalDate localDate1 = LocalDate.now(ZoneId.of("America/Panama"));
        System.out.println(localDate1);

        System.out.println("-------对日期格式化");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = localDateTime.format(dateTimeFormatter);
        System.out.println(format);
    }
}

/**
 * 与SimpleDateFormat相比，DateTimeFormatter是线程安全的。
 * Instant 的精确度更高，会精确到纳秒。Date只能精确到毫秒。
 * Duration 可以快捷的操作时间，可以地得到时间段内的天数、小时。
 * LocalDateTime 快捷的获取年月日，下一个月
 */
