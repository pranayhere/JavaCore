package com.pranay;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'Hmmss'Z'");
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("Hmmss");

    public static void main(String[] args) throws ParseException {
        Long startDate = 1594339200000L;
        String inputString = "01:00";

//
//        Timestamp ts = new Timestamp(startDate);
//        System.out.println(ts);
//        LocalDateTime singaporeTime = ts.toInstant().atZone(ZoneId.of("Asia/Singapore")).toLocalDateTime();
//        System.out.println("Singapore time : " + singaporeTime);
        LocalDateTime triggerTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(startDate), TimeZone.getTimeZone("GMT-0").toZoneId());

        String[] split = inputString.split(":");
        triggerTime.plusHours(Integer.parseInt(split[0]));
        triggerTime.plusMinutes(Integer.parseInt(split[1]));

        System.out.println(triggerTime);

        ZonedDateTime zdt = triggerTime.atZone(ZoneId.of("Asia/Singapore"));
        System.out.println(zdt);
        System.out.println(zdt.withZoneSameInstant(ZoneId.of("Asia/Kolkata")));

//        SimpleDateFormat onlyDate = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = new Date(startDate);
//        String onlyDateStr = onlyDate.format(date);
//        System.out.println("timestamp to date : " + date + " only date  : " + onlyDateStr);
//
//        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        Date date2 = timeFormat.parse(onlyDateStr  + " " + inputString);
//        System.out.println(date2);
//
//        LocalDateTime singaporeDate = date2.toInstant()
//                .atZone(ZoneId.of("Asia/Singapore"))
//                .toLocalDateTime();
//
//        System.out.println("Singapore local Date time : " + singaporeDate);

//        Long startDate = 1594425600000L;
//        String inputString = "01:39";
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
//
//        Date date2 = sdf.parse("1970-01-01 " + inputString);
//        System.out.println("in milliseconds: " + date2.getTime());
//        long millis = date2.getTime();
//        startDate += millis;
//
//        System.out.println("IST : " + new Date(startDate));
//        SimpleDateFormat myDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//        String formatted = myDate.format(new Date(startDate));
//
//        myDate.setTimeZone(TimeZone.getTimeZone("GMT+8"));
//        Date newDate = myDate.parse(formatted);
//        System.out.println("New Date : " + newDate);
//
//        Date nowUtc = new Date();
//        TimeZone asiaSingapore = TimeZone.getTimeZone("GMT+8");


//        String startDate="20200706T000000Z";
//        String startTime="130900";
//        startDate = startDate.substring(0, startDate.indexOf('T') + 1);
//        startDate += startTime + 'Z';
//
//        LocalDateTime start = LocalDateTime.parse(startDate, formatter);
//        System.out.println(start);

//        Calendar pCalEnd = Calendar.getInstance(TimeZone.getTimeZone(TimeZone.getAvailableIDs(7200*1000)[0]));
//        System.out.println(pCalEnd.getTime());

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
