package com.pranay.GeeksForGeeks;

import java.util.Arrays;
import java.util.TimeZone;

public class ValidateIpAddress {
    public static void main(String[] args) {
        TimeZone tz = TimeZone.getTimeZone("Europe/London");
        String timezone = tz.toZoneId().toString();
        System.out.println("Timezone : " + timezone);

        String[] inputs = new String[]{
                "172.11.54.1",
                "2001:0db8:85a3:0:0:8A2E:0370:7334",
                "256.256.256.256",
                "2001:0db8:85a3::8A2E:0370:7334",
                "02001:0db8:85a3:0000:0000:8a2e:0370:7334",
                "2001:0db8:85a3:0:0:8A2E:0370:7334:",
                "2001:0db8:85a3:0:0:8A2E:0370:7334:::::::",
                "255.255.255.255...",
        };
        for (String input: inputs) {
            String IpType = validIPAddress(input);
            System.out.println(input + " Ip Address Type : " + IpType);
        }
    }

    private static String validIPAddress(String input) {
        if (input == null) {
            return "neither";
        }

        if (input.contains(".") && validIPv4(input)) {
            return "IPv4";
        } else if (input.contains(":") && validIPv6(input)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    private static boolean validIPv4(String input) {
        if (input.endsWith(".")) {
            return false;
        }

        String[] components = input.split("\\.");
        if (components.length != 4) {
            return false;
        }

        for (String component: components) {
            if (component.equals("") || component.isEmpty()) {
                return false;
            }
            int num = Integer.parseInt(component);
            if (component.startsWith("0") && component.length() > 1) {
                return false;
            }

            if (num < 0 || num > 255) {
                return false;
            }
        }
        return true;
    }

    private static boolean validIPv6(String input) {
        if (input.endsWith(":")) {
            return false;
        }
        String[] components = input.split(":");
        if (components.length != 8) {
            return false;
        }

        for (String component: components) {
            if (component.equals("0000")) {
                return false;
            }
            if (component.equals("") || component.isEmpty()) {
                return false;
            }

            if (!component.matches("-?[0-9a-fA-F]+")) {
                return false;
            }
        }
        return true;
    }
}
