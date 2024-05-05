package org.example.model;

import lombok.Data;

import java.util.UUID;

@Data
public class TimeSlotType {
    private UUID id;
    private String name;
    private Integer slot_size;
    private Boolean public_bookable;
    private String color;
    private String icon;
    private String clinic_id;
    private Boolean deleted;
    private Boolean out_of_office;
    private Boolean enabled;

}
