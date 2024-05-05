package org.example.model;

import lombok.Data;

import java.util.UUID;

@Data
public class TimeSlot {
    private UUID id;
    private UUID calendar_id;
    private String start;
    private String end;
    private UUID patient_id;
    private UUID type_id;
    private Boolean public_bookable;
    private Boolean out_of_office;

}