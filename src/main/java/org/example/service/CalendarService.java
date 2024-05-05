package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Calendar;
import org.example.model.TimeSlot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CalendarService {
    private static List<Calendar> calendars;

    public CalendarService() {
        parseJsonData();
    }

    private void parseJsonData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            calendars = objectMapper.readValue(new File("src/main/resources/data.json"), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<UUID, List<String>> findAvailableTime(List<UUID> calendarIds, int durationInMinutes, String startTime, String endTime, UUID timeSlotTypeId) {
        LocalDateTime startDateTime = LocalDateTime.parse(startTime, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        LocalDateTime endDateTime = LocalDateTime.parse(endTime, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        Duration meetingDuration = Duration.ofMinutes(durationInMinutes);
        // Initialize map to store available time slots for each calendar
        Map<UUID, List<String>> availableSlotsMap = new HashMap<>();
        // Iterate through each calendar
        for (Calendar calendar : calendars) {
            if (calendarIds.contains(calendar.getId())) {
                List<String> availableSlots = new ArrayList<>();
                // Iterate through time slots
                for (TimeSlot timeSlot : calendar.getTimeslots()) {
                    LocalDateTime slotStart = LocalDateTime.parse(timeSlot.getStart());
                    LocalDateTime slotEnd = LocalDateTime.parse(timeSlot.getEnd());
                    // Check if the time slot falls within the search period and has sufficient duration
                    if (slotStart.isAfter(startDateTime) && slotEnd.isBefore(endDateTime) &&
                            Duration.between(slotStart, slotEnd).compareTo(meetingDuration) >= 0 &&
                            (timeSlotTypeId == null || timeSlot.getType_id().equals(timeSlotTypeId))) {
                        // Add the available time slot to the list
                        availableSlots.add("From: " + slotStart + " To: " + slotEnd);
                    }
                }
                // Add the list of available slots to the map
                availableSlotsMap.put(calendar.getId(), availableSlots);
            }
        }
        return availableSlotsMap;
    }


}