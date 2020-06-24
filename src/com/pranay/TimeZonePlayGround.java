package com.pranay;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * LocalDateTime ldt = LocalDateTime.now();
 * Instant instant = ldt.atZone(ZoneId.of("GMT+05:30")).toInstant();
 * Instant instant = ldt.atZone(ZoneId.systemDefault()).toInstant();
 * System.out.println("Date (Local) : " + ldt);
 *
 * LocalDateTime gmtTime = LocalDateTime.ofInstant(instant, ZoneId.of("GMT"));
 * System.out.println("GMT : " + gmtTime);
 */


public class TimeZonePlayGround {
    static final String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) {

        Calendar pCalEnd = Calendar.getInstance(TimeZone.getTimeZone(TimeZone.getAvailableIDs(7200*1000)[0]));
        System.out.println(pCalEnd.getTime());

//        final SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
//        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
//        final String utcTime = sdf.format(new Date());
//        System.out.println("UTC Now : " + utcTime);

        //        LocalDateTime ldt = LocalDateTime.now();
//        Instant instant = ldt.atZone(ZoneId.of("GMT+05:30")).toInstant();
//        Instant instant = ldt.atZone(ZoneId.of("GMT")).toInstant();
//        System.out.println("Instant : " + instant);
//        LocalDateTime gmtTime = LocalDateTime.ofInstant(instant, ZoneId.of("GMT"));
//        System.out.println("GMT : " + gmtTime);
//
//        Date gmtDate = Date.from(gmtTime.atZone(ZoneId.systemDefault()).toInstant());
//        System.out.println("GMT DATE : " +gmtDate);

        // india time 19-6-2020:12.17.00 pm
//        LocalDateTime ldt2 = LocalDateTime.of(2020, 6, 19, 14, 47, 0); //singapore
//        Instant instantSingapore = ldt2.atZone(ZoneId.of("GMT+8")).toInstant();
//        LocalDateTime singaporeDateTime = LocalDateTime.ofInstant(instantSingapore, ZoneId.of("GMT+8"));
//        LocalDateTime indiaDateTime = LocalDateTime.ofInstant(instantSingapore, ZoneId.of("Asia/Kolkata"));
//        System.out.println("Singapore time now : " + singaporeDateTime);
//        System.out.println("India time now : " + indiaDateTime);

//        String timezone = "Europe/London";
//        LocalDateTime date = LocalDateTime.parse("2020-06-17T12:52");
//        System.out.println("Now : " + date);
//
//        ZonedDateTime zdt = ZonedDateTime.of(date, ZoneId.of(timezone));
//
//        ZonedDateTime europeTime = date.atZone(ZoneId.of(timezone));
//        System.out.println("Zdt : " + zdt + "\n" +
//                "Europe time now : " + ZonedDateTime.now(ZoneId.of(timezone)) +"\n"+
//                "Europe time of given : " + europeTime);
//
//        LocalDateTime ldt = LocalDateTime.parse("2018-07-01T08:00");
//        System.out.println("ldt : " + ldt);
//        ZonedDateTime zdtParis = ZonedDateTime.of(ldt, ZoneId.of("Europe/Paris"));
//        System.out.println("zdt Paris : " + zdtParis.toInstant());
//        // 2018-07-01T08:00+02:00[Europe/Paris]
//
//        ZonedDateTime zdtNewYork = ZonedDateTime.of(ldt, ZoneId.of("America/New_York"));
//        System.out.println("zdt New York : " + zdtNewYork);
//        // 2018-07-01T08:00-04:00[America/New_York]
//
//        boolean equal = zdtParis.isEqual(zdtNewYork); // false
//        System.out.println("Is equal : " + equal);
//
//
//        ZonedDateTime indiaDate = LocalDateTime.parse("2020-06-17T13:42").atZone(ZoneId.systemDefault());
//        ZonedDateTime europeDate = ZonedDateTime.now(ZoneId.of(timezone));
//
//        System.out.println("INDIA : " + Date.from(indiaDate.toInstant()));
//        System.out.println("EUROPE : " + europeDate);

    }
}
