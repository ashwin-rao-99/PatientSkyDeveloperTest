package org.example;

import org.example.service.CalendarService;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        CalendarService calendarService = new CalendarService();
        List<UUID> calendarIds = List.of(
                UUID.fromString("48644c7a-975e-11e5-a090-c8e0eb18c1e9"),
                UUID.fromString("48cadf26-975e-11e5-b9c2-c8e0eb18c1e9")
        );
        Map<UUID, List<String>> availableSlotsMap = calendarService.findAvailableTime(calendarIds, 15, "2019-03-01T13:00:00Z", "2019-05-11T15:30:00Z", UUID.fromString("4529821e-975e-11e5-bbaf-c8e0eb18c1e9"));
        for (UUID calendarId : availableSlotsMap.keySet()) {
            System.out.println("Calendar ID: " + calendarId);
            System.out.println("Available slots: " + availableSlotsMap.get(calendarId));
        }
    }
}