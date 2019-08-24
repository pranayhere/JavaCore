package com.pranay.EnumSetExample;

import java.util.*;
import java.util.stream.Collectors;

public enum SystemEvent {
    APP_INSTALLED("app_installed", "usage1"),
    APP_UPGRADED("app_upgraded", "usage2"),
    SMS_SENT("sms_sent", "usage1"),
    SMS_FAILED("sms_failed", "usage2"),
    SMS_SUCCESS("sms_success", "usage3");

    private String systemName;
    private String usage;

    private static EnumSet<SystemEvent> appEvents = EnumSet.of(APP_INSTALLED, APP_UPGRADED, SMS_FAILED);
    private static EnumSet<SystemEvent> smsEvents = EnumSet.of(SMS_FAILED, SMS_SENT);

    private static Map<String, List<EnumSet>> eventsFilterMap = null;

    SystemEvent(String systemName, String usage) {
        this.systemName = systemName;
        this.usage = usage;
    }

    public String getSystemName() {
        return systemName;
    }

    public String getUsage() {
        return usage;
    }

    public static Map<String, List<EnumSet>> getEventFilter() {
        if (eventsFilterMap == null) {
            System.out.println("Here to initialize");
            eventsFilterMap = new HashMap<>();
            eventsFilterMap.put("system", Arrays.asList(appEvents, smsEvents));
            eventsFilterMap.put("analytics", Arrays.asList(smsEvents));
        }
        return eventsFilterMap;
    }

    public static void main(String[] args) {
        System.out.println(SystemEvent.APP_INSTALLED.getSystemName());

        Map<String, List<EnumSet>> eventsFilterMap = SystemEvent.getEventFilter();
//        Map<String, List<EnumSet>> eventsFilterMap2 = SystemEvent.getEventFilter();
            List<EnumSet> list = eventsFilterMap.get("system");

            Set<SystemEvent> finalEvents = new HashSet<>();
            List<Enum> enumList = new ArrayList<>();
            for (EnumSet e : list) {
                finalEvents.addAll(e);
            }

            List<EventsDto> eventsList = finalEvents.stream().map(finalEvent -> new EventsDto(finalEvent.getSystemName(), finalEvent.getUsage())).collect(Collectors.toList());
            System.out.println(eventsList);
    }
}

// /events?group[]=appEvents&group[]=systemEvent