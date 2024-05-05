package org.example.model;
import lombok.Data;

import java.util.List;
import java.util.UUID;
@Data
public class Calendar {
    private UUID id;

    private List<Appointment> appointments;

    private List<TimeSlot> timeslots;
    private List<TimeSlotType> timeslottypes;
}
