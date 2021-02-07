package com.example.collection.java8;

import java.time.*;

/**
 * Clock
 * 1.Clock类使用时区来返回当前的纳秒时间和日期。
 * 2.Clock可以替代System.currentTimeMillis()和TimeZone.getDefault()。
 */
public class NewTimeAPI {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Clock clock = Clock.systemUTC();
//        System.out.println(clock.getZone());
//        System.out.println(clock.instant());
//        System.out.println(clock.millis());

        LocalDate date = LocalDate.now();
        LocalDate dateForClock = LocalDate.now(clock);
        System.out.println(date);
        System.out.println(dateForClock);

        // 重点：LocalTime.now() 默认带上(系统)时区，而 Clock 没有带时区
        LocalTime time = LocalTime.now();
        LocalTime timeForClock = LocalTime.now(clock);
        System.out.println(time);
        System.out.println(timeForClock);

        // 重点：LocalDateTime.now() 默认带上(系统)时区，而 Clock 没有带时区
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime dateTimeForClock = LocalDateTime.now(clock);
        System.out.println(dateTime);
        System.out.println(dateTimeForClock);

        // Get the zoned date/time
        final ZonedDateTime zonedDatetime = ZonedDateTime.now();
        final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now( clock );
        final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now( ZoneId.of( "America/Los_Angeles" ) );

        System.out.println( zonedDatetime );
        System.out.println( zonedDatetimeFromClock );
        System.out.println( zonedDatetimeFromZone );

        // Get duration between two dates
        final LocalDateTime from = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
        final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );

        final Duration duration = Duration.between( from, to );
        System.out.println( "Duration in days: " + duration.toDays() );
        System.out.println( "Duration in hours: " + duration.toHours() );
    }
}
