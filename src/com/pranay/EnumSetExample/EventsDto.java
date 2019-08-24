package com.pranay.EnumSetExample;

public class EventsDto {
    private String systemName;
    private String usage;

    public EventsDto(String systemName, String usage) {
        this.systemName = systemName;
        this.usage = usage;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    @Override
    public String toString() {
        return "EventsDto{" +
                "systemName='" + systemName + '\'' +
                ", usage='" + usage + '\'' +
                '}';
    }
}
