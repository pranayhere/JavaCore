package com.pranay;

import java.sql.Date;
import java.sql.SQLOutput;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class TimeZonePlayGround {
    public static void main(String[] args) {
        String timezone = "Europe/London";
        LocalDateTime date = LocalDateTime.parse("2020-06-17T12:52");
        System.out.println("Now : " + date);

        ZonedDateTime zdt = ZonedDateTime.of(date, ZoneId.of(timezone));

        ZonedDateTime europeTime = date.atZone(ZoneId.of(timezone));
        System.out.println("Zdt : " + zdt + "\n" +
                "Europe time now : " + ZonedDateTime.now(ZoneId.of(timezone)) +"\n"+
                "Europe time of given : " + europeTime);

        LocalDateTime ldt = LocalDateTime.parse("2018-07-01T08:00");
        System.out.println("ldt : " + ldt);
        ZonedDateTime zdtParis = ZonedDateTime.of(ldt, ZoneId.of("Europe/Paris"));
        System.out.println("zdt Paris : " + zdtParis.toInstant());
        // 2018-07-01T08:00+02:00[Europe/Paris]

        ZonedDateTime zdtNewYork = ZonedDateTime.of(ldt, ZoneId.of("America/New_York"));
        System.out.println("zdt New York : " + zdtNewYork);
        // 2018-07-01T08:00-04:00[America/New_York]

        boolean equal = zdtParis.isEqual(zdtNewYork); // false
        System.out.println("Is equal : " + equal);


        ZonedDateTime indiaDate = LocalDateTime.parse("2020-06-17T13:42").atZone(ZoneId.systemDefault());
        ZonedDateTime europeDate = ZonedDateTime.now(ZoneId.of(timezone));

        System.out.println("INDIA : " + Date.from(indiaDate.toInstant()));
        System.out.println("EUROPE : " + europeDate);

    }
}
